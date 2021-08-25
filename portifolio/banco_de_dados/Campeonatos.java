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
public class Campeonatos {
    
    private String estadio;
    private String posição_jogadores;
    private String nomes_campeonatos;
    private String pais;

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getNomes_campeonatos() {
        return nomes_campeonatos;
    }

    public void setNomes_campeonatos(String nomes_campeonatos) {
        this.nomes_campeonatos = nomes_campeonatos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPosição_jogadores() {
        return posição_jogadores;
    }

    public void setPosição_jogadores(String posição_jogadores) {
        this.posição_jogadores = posição_jogadores;
    }
}
