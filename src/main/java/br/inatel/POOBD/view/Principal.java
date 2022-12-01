package br.inatel.POOBD.view;

import br.inatel.POOBD.controller.ArmaDB;
import br.inatel.POOBD.controller.CofreDB;
import br.inatel.POOBD.controller.JogadorDB;
import br.inatel.POOBD.model.Cofre;
import br.inatel.POOBD.model.Jogador;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        //objetos de manipulaçao BD
        JogadorDB jogadorDB = new JogadorDB();
        CofreDB cofreDB = new CofreDB();
        ArmaDB armaDB = new ArmaDB();

        Jogador [] jogador = new Jogador[100];
        Cofre [] cofre= new Cofre[100];


        int aux;
        Scanner u = new Scanner(System.in);
        int i = 1;


        do {

            System.out.println("-------------------------------------------------------");
            System.out.println("1 para cadastrar seu personagem");
            System.out.println("2 para adicionar arma ao seu personagem/cofre");
            System.out.println("3 para mudar seu nick");
            System.out.println("4 para deletar um personagem");
            System.out.println("5 para mostrar os jogadores cadastrados");
            System.out.println("0 para encerrar o programa");
            System.out.println("-------------------------------------------------------");
            aux = u.nextInt();

            if(aux == 1) {//FUNCIONANDO
                System.out.println("Criando seu personagem");
                System.out.println("Insira o nick :");
                String nome = u.next();

                System.out.println("Insira sua TAG (a tag deve possuir 4 numeros.Ex = 1234)");
                int tag = u.nextInt();

                //criando o objeto jogador
                jogador[i] = new Jogador(nome, tag);
                //colocando ele no banco de dados
                jogadorDB.insertJogador(jogador[i]);



                //criando o cofre dele
                    System.out.println("Insira a senha do seu cofre: ");
                    String password = u.next();

                    try {
                        cofre[i] = new Cofre(password,5);
                        cofreDB.insertCofre(cofre[i]);

                    }catch (SQLException e){
                        System.err.println("ESSA SENHA JA EXISTE, crie seu perfil novamente");
                        jogadorDB.deleteJogador(tag);
                    }

                //atualizando a chave estrangeira do cofre
                cofreDB.att();
            }

            else if(aux == 2){
                //insira a senha do seu cofre
                String valid = u.next();

                //validando senha

                //mostrar armas
                System.out.println("Escolha sua arma pelo id");
                System.out.println("---------------------------------------");
                armaDB.researchArma();

                //usuario escolhe armas
                int escolha = u.nextInt();

                //tratar o erro da escolha. Ser diferente de um id de arma


                //colocar a arma no cofre do usuario


            }

            else if(aux == 3){ //FALTA TRATAR ERRO DA TAG

                //mudar nick
                System.out.println("Insira sua TAG para confirmarmos o usuario: ");
                int tagop = u.nextInt();
                //tratar de ser uma tag existente

                //inserir o novo nick
                System.out.println("Insira seu novo nick :");
                String newnick = u.next();

                //chamando a funçao
                boolean change = jogadorDB.updateJogador(newnick,tagop);
                if(change == true){
                    System.out.println("NICK alterado para : "+ newnick);
                }
                else if(change == false){
                    System.out.println("erro ao tentar trocar seu nick");
                }
            }


           //FUNCIONANDO
            else if(aux == 4){
                //deletar personagem

                //confirmar se o usuario realmente deseja excluir sua conta
                System.err.println("Esta acao nao podera ser desfeita. Realmente deseja realizar essa operacao?");
                System.err.println("1 para sim, 0 para nao");
                int op = u.nextInt();
                if(op == 1){
                    System.out.println("Insira sua TAG para confirmarmos o usuario: ");
                    int tagdel = u.nextInt();

                    //deletando
                    jogadorDB.deleteJogador(tagdel);
                    System.out.println("Usuario deletado");
                }


            }

            //FUNCIONANDO
            else if (aux == 5) {
                //mostrando o nick dos jogadores cadastrados
                jogadorDB.researchJogador();

            }

            //FUNCIONANDO
            else{
                //chamar erro
                if (aux != 0) //diferente de 0 pois 0 encerrar o processo por completo
                   System.err.println("Nenhuma operacao valida. Tente novamente");
            }


        }while (aux != 0);



    }
}
