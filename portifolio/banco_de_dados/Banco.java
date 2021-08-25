/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futebol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author SESI_SENAI
 */
public class Banco {
    private static Connection connection;
   
    public static Connection getConnection(){
        if(connection == null){
            try{
                //Class.forName("com.mysql.jdbc.Driver"); //para mysql
                Class.forName("org.postgresql.Driver");//para postgresql
                String host = "localhost";
                String port = "5432";
                String database = "postgres";
                String user = "postgres";
                String pass = "senai";//digitar a senha do seu banco
                //String url = "jdbc:mysql://"+host+":"+port+"/"+database; //para mysql
                String url = "jdbc:postgresql://"+host+":"+port+"/"+database;//para postgresql
                connection = DriverManager.getConnection(url, user, pass);                
               
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void close(){
        if (connection == null){
            throw new RuntimeException("Nenhuma conexão aberta!");
        }
        else{
            try{
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
 
   
     public static void salvar (Jogadores jogadores){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO jogadores (nomes_times , nome, posição_jogadores, nivel, numero_camisa) values(?, ?, ?, ?, ?);");
            ps.setString(1, jogadores.getNomes_times());
            ps.setString(2, jogadores.getNome());
            ps.setString(3, jogadores.getPosição_jogadores());
            ps.setString(4, jogadores.getNivel());
            ps.setString(5, jogadores.getNumero_camisa());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
      public static void salvar (Campeonatos campeonato){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO campeonatos (estadio, nomes_campeonatos, posição_jogadores, pais) values(?, ?, ?, ?);");
            ps.setString(1, campeonato.getEstadio());
            ps.setString(2, campeonato.getNomes_campeonatos());
            ps.setString(3, campeonato.getPosição_jogadores());
            ps.setString(4, campeonato.getPais());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
       public static void salvar (Times times){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO times (tecnico, nomes, estadio_time,quantidade_titulos , quantidade_jogadores) values(?, ?, ?, ?, ?);");
            ps.setString(1, times.getTecnico());
            ps.setString(2, times.getNomes());
            ps.setString(3, times.getEstadioTime());
            ps.setInt(4, times.getQuantidadeTitulos());
            ps.setInt(5, times.getQuantidadeJogadores());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void visualiza_dados (String tabela, String...atributos){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tabela);
            ResultSet rs = ps.executeQuery();
            
            String resultado = "";
            while(rs.next()){
              for(String i : atributos){
                  resultado = resultado + " | " + rs.getString(i);
              }
              resultado = resultado + "\n";
            }
            System.out.println(resultado);
            
            
            
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleta(String Cpf){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete FROM usuario WHERE id = ?");
            ps.setString(1, Cpf);
            ps.executeUpdate();


            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*public static void atualizaBanco(pessoa pessoa){
        deleta(pessoa.getCpf());
        salvar(pessoa);
    }
    */
    public static void criar_tabela (String tabela, String... atributo){
        try{
            Connection con = Banco.getConnection();
            
            String comando = "CREATE TABLE " + tabela + "(";
            
            for (String i: atributo){
                comando = comando + i + ",";
            }
            comando = comando.substring(0, comando.length()-1);
            comando = comando + ");";
            //System.out.println(comando);
            PreparedStatement ps = con.prepareStatement(comando);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

