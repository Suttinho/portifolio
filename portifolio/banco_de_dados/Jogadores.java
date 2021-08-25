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
public class Jogadores {
    
    private String nomes_times;
    private String posição_jogadores;
    private String nome;
    private String nivel;
    private String numero_camisa;

    public String getNomes_times() {
        return nomes_times;
    }

    public void setNomes_times(String nomes_times) {
        this.nomes_times = nomes_times;
    }

    public String getNumero_camisa() {
        return numero_camisa;
    }

    public void setNumero_camisa(String numero_camisa) {
        this.numero_camisa = numero_camisa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosição_jogadores() {
        return posição_jogadores;
    }

    public void setPosição_jogadores(String posição_jogadores) {
        this.posição_jogadores = posição_jogadores;
    }
    
    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
