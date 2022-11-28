package br.inatel.POOBD.view;

import br.inatel.POOBD.controller.CofreDB;
import br.inatel.POOBD.controller.JogadorDB;
import br.inatel.POOBD.model.Cofre;
import br.inatel.POOBD.model.Jogador;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        //objetos de manipulaçao BD
        Cofre [] cofre= new Cofre[5];
        CofreDB cofreDB = new CofreDB();
        Jogador [] jogador = new Jogador[5];
        JogadorDB jogadorDB = new JogadorDB();

        int aux;
        Scanner u = new Scanner(System.in);
        int i = 0;
        int capacidade = 5;

        do {

            System.out.println("1 para cadastrar seu personagem");
            System.out.println("2 para adicionar arma ao seu personagem/cofre");
            System.out.println("3 para mudar seu nick");
            System.out.println("4 para deletar um personagem");
            System.out.println("0 para encerrar o programa");

            aux = u.nextInt();

            if(aux == 1) {
                System.out.println("Criando seu personagem");
                System.out.println("Insira o nick :");
                String nome = u.next();

                System.out.println("Insira sua TAG (a tag deve possuir 4 numeros.Ex = 1234)");
                int tag = u.nextInt();

                //criando o objeto jogador
                jogador[i] = new Jogador(nome, tag);
                //colocando ele no banco de dados
                jogadorDB.insertJogador(jogador[i]);

                System.out.println("Insira a senha do seu cofre: ");
                String senha = u.next();
                //criando o cofre dele
                cofre[i] = new Cofre(capacidade,senha,jogador[i].id);
                cofreDB.insertCofre(cofre[i]);
            }


        }while (aux != 0);



        jogadorDB.researchJogador();
    }
}


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