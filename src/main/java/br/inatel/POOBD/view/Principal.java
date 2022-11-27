package br.inatel.POOBD.view;

import br.inatel.POOBD.controller.CofreDB;
import br.inatel.POOBD.controller.JogadorDB;
import br.inatel.POOBD.model.Cofre;
import br.inatel.POOBD.model.Jogador;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        //objetos de manipulaçao BD
        CofreDB [] cofreDB = new CofreDB[5];
        Jogador [] jogador = new Jogador[5];
        JogadorDB jogadorDB = new JogadorDB();

        int aux = 1;
        Scanner u = new Scanner(System.in);
        int i = 0;

//mscirl
        do {

            System.out.println("Crie seu personagem");
            String nome = u.next();
            int nivel = u.nextInt();

            jogador[i] = new Jogador(nome,nivel);
            jogadorDB.insertJogador(jogador[i]);

            System.out.println("Inserir novo jogador?");
            aux = u.nextInt();
        }while (aux != 0);
/*
        //objetos para inserir no BD
        Jogador j1 = new Jogador("PVF",20);
        Jogador j2 = new Jogador("W&N",5);
        Cofre c1 = new Cofre(10,"wiou",1);
        Cofre c2 = new Cofre(12,"qwer",2);

        //inserindo infos no BD
        jogadorDB.insertJogador(j1);
        jogadorDB.insertJogador(j2);
        cofreDB.insertCofre(c1);
        cofreDB.insertCofre(c2);

        //buscando info bd
        jogadorDB.researchJogador();
        cofreDB.researchCofre();
        System.out.println("--------ATUALIZANDO INFOS BD--------");
        jogadorDB.updateJogador(2,"Weslwy",4);
        jogadorDB.researchJogador();
        cofreDB.updateCofre(1,1);
        cofreDB.researchCofre();
        System.out.println("-------Excluindo infos BD----------");
        jogadorDB.deleteJogador(1);
        cofreDB.deleteCofre(2);

        //mostrandp resultado final BD
        jogadorDB.researchJogador();
        cofreDB.researchCofre();
*/

        jogadorDB.researchJogador();
    }
}
