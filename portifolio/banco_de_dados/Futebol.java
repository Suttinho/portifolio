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
public class Futebol {
    

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        Banco.criar_tabela("Times", "nomes varchar", "tecnico varchar", "estadio_time varchar", "quantidade_titulos int", "quantidade_jogadores int");
        
        Times times = new Times();
        
        times.setTecnico("zulu");
        times.setNomes("zidane");
        times.setEstadioTime("Pb soccer");
        times.setQuantidadeTitulos(8);
        times.setQuantidadeJogadores(11);
        Banco.salvar(times);
          
        Banco.criar_tabela("jogadores", "nomes_times varchar ", "posição_jogadores varchar", "nome varchar", "nivel varchar", "numero_camisa varchar");
        
        Jogadores jogador = new Jogadores();
        
        jogador.setNivel("10");
        jogador.setNome("zidane");
        jogador.setNomes_times("chiquitas ph");
        jogador.setNumero_camisa("9");
        jogador.setPosição_jogadores("zaga");
        Banco.salvar(jogador);
        
        Banco.criar_tabela("Campeonatos", "nomes_campeonatos varchar", "estadio varchar", "posição_jogadores varchar", "pais varchar");
        
        Campeonatos campeonatos = new Campeonatos();
        
        campeonatos.setEstadio("zuluzao");
        campeonatos.setNomes_campeonatos("zidane champions");
        campeonatos.setPosição_jogadores("zaga");
        campeonatos.setPais("palhoça");
        
        Banco.salvar(campeonatos);
        System.out.println("tabela campeonato");
        Banco.visualiza_dados("Campeonatos","estadio", "nomes_campeonatos", "posição_jogadores", "pais");
         System.out.println("tabela times");
        Banco.visualiza_dados("Times","tecnico", "nomes", "estadio_time","quantidade_titulos" , "quantidade_jogadores");
         System.out.println("tabela jogadores");
        Banco.visualiza_dados("Jogadores","nomes_times" , "nome", "posição_jogadores", "nivel", "numero_camisa");
    }
    }
    

