package br.inatel.POOBD.controller;

import br.inatel.POOBD.model.Cofre;

import java.sql.SQLException;
import java.util.ArrayList;

public class CofreDB extends Database {
    private boolean check = false;

    //inserindo
    public boolean insertCofre(Cofre cofre){
        connect();
        String sql = "INSERT INTO cofre(capacidade,senha,jogador_id) VALUES (?,?,?)";
        try{

            pst = connection.prepareStatement(sql);
            pst.setInt(1,cofre.capacidade);
            pst.setString(2, cofre.getSenha());
            pst.setInt(3,cofre.jogador_id);
            pst.execute();
            check = true;

        }catch (SQLException e){
            System.out.println("Erro de operação: "+e.getMessage());
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


    //selecionando
    public ArrayList<Cofre> researchCofre(){
        connect();
        ArrayList<Cofre> cofres = new ArrayList<>();
        String sql = "SELECT * FROM cofre";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Cofre cofreTemp = new Cofre(result.getInt("capacidade"),result.getString("senha"),result.getInt("jogador_id"));
                cofreTemp.id = result.getInt("id");


                System.out.println("Numero do cofre = "+ cofreTemp.id);
                System.out.println("Capacidade = "+ cofreTemp.capacidade);
                System.out.println("Senha = "+cofreTemp.getSenha());

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

    //atualizando registro
    public boolean updateCofre(int id, int jogador_id){
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

    public boolean deleteCofre(int id){
        connect();
        String sql = "DELETE FROM cofre WHERE id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: "+ e.getMessage());
            }
        }
        return check;
    }

}
