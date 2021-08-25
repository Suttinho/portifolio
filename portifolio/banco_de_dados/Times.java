/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futebol;

/**
 *
 * @author SESI_SENAI
 */
public class Times {
    
    private String nomes;
    private String tecnico;
    private String estadio_time;
    private int quantidade_titulos;
    private int quantidade_jogadores;

    public String getNomes() {
        return nomes;
    }

    public void setNomes(String nomes) {
        this.nomes = nomes;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getEstadioTime() {
        return estadio_time;
    }

    public void setEstadioTime(String estadio_time) {
        this.estadio_time = estadio_time;
    }

    public int getQuantidadeTitulos() {
        return quantidade_titulos;
    }

    public void setQuantidadeTitulos(int quantidade_titulos) {
        this.quantidade_titulos = quantidade_titulos;
    }
    public int getQuantidadeJogadores() {
        return quantidade_jogadores;
    }

    public void setQuantidadeJogadores(int quantidade_jogadores) {
        this.quantidade_jogadores = quantidade_jogadores;
    }
}

