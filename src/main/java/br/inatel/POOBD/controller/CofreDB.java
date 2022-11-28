package br.inatel.POOBD.controller;

import br.inatel.POOBD.model.Cofre;

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

    //registros criados sem relacionamentos, aqui estamos criando relacionamento ja existentes
    public boolean updateJogador_id(int id, int jogador_id){
        connect();
        String sql = "UPDATE cofre SET jogador_id = ? where id = ? ";
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
