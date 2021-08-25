package com.example.conexobancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Banco {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                //Class.forName("com.mysql.jdbc.Driver"); //para mysql
                Class.forName("org.postgresql.Driver");//para postgresql
                String host = "10.0.2.2";
                String port = "5432";
                String database = "postgres";
                String user = "postgres";
                String pass = "senai";//digitar a senha do seu banco
                //String url = "jdbc:mysql://"+host+":"+port+"/"+database; //para mysql
                String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;//para postgresql
                connection = DriverManager.getConnection(url, user, pass);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void close() {
        if (connection == null) {
            throw new RuntimeException("Nenhuma conexão aberta!");
        } else {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void salvar(Usuario usuario) {
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO usuario (id, nome, senha) values(?, ?, ?)");
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getSenha());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void visualiza_dados(String tabela, String... atributo) {
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tabela);
            ResultSet rs = ps.executeQuery();

            String resultado = "";
            while (rs.next()) {
                for (String i : atributo) {
                    resultado = resultado + " | " + rs.getString(i);
                }
                resultado = resultado + "\n";
            }
            System.out.println(resultado);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleta(int id) {
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete FROM usuario WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualiza(Usuario usuario) {
        deleta(usuario.getId());
        salvar(usuario);
    }
}