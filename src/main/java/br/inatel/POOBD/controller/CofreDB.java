package br.inatel.POOBD.controller;

import br.inatel.POOBD.model.Cofre;
import br.inatel.POOBD.model.Jogador;

import java.sql.SQLException;
import java.util.ArrayList;

public class CofreDB extends Database {
    private boolean check = false;

    //inserindo
    public boolean insertCofre(Cofre cofre){
        connect();
        String sql = "INSERT INTO cofre(capacidade,senha) VALUES (?,?)";
        try{

            pst = connection.prepareStatement(sql);
            pst.setInt(1,cofre.capacidade);
            pst.setString(2, cofre.getSenha());
            pst.execute();
            check = true;

        }catch (SQLException e){
            System.out.println("Erro de operação : "+e.getMessage());
            check = false;
        }
        finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: "+ e.getMessage());
            }
        }


        return check;
    }

    public boolean att( String password, Jogador jogador){
        connect();
        String sql = "UPDATE cofre set jogador_id = ? where senha = ?";
        try{

            pst = connection.prepareStatement(sql);
            pst.setInt(1,jogador.id);
            pst.setString(2, password);
            pst.execute();
            check = true;

        }catch (SQLException e){
            System.out.println("Erro de operação : "+e.getMessage());
            check = false;
        }
        finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: "+ e.getMessage());
            }
        }


        return check;
    }


    //update cofre set jogador_id = 1 where id = 1;
    //selecionando
    public ArrayList<Cofre> researchCofre(){
        connect();
        ArrayList<Cofre> cofres = new ArrayList<>();
        String sql = "SELECT * FROM cofre";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Cofre cofreTemp = new Cofre(result.getString("senha"),result.getInt("capacidade"));
                cofreTemp.id = result.getInt("id");
                cofreTemp.jogador_id = result.getInt("jogador_id");
               // System.out.println("Numero do cofre = "+ cofreTemp.id);
              //  System.out.println("Capacidade = "+ cofreTemp.capacidade);
               // System.out.println("Senha = "+cofreTemp.senha);
                if(cofreTemp.jogador_id > 0){
                   // System.out.println("Id do dono: "+ cofreTemp.jogador_id);
                }
             //   System.out.println("--------------------------------------------------------");
                cofres.add(cofreTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: "+e.getMessage());
            }
        }

        return cofres;

    }

    //registros criados sem relacionamentos, aqui estamos criando relacionamento ja existentes
    public boolean updateJogador_id(int id, int jogador_id){
        connect();
        String sql = "UPDATE cofre SET jogador_id=? where id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,jogador_id);
            pst.setInt(2,id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operacao: "+ e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }

        return check;
    }

}
