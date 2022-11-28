package br.inatel.POOBD.controller;

import br.inatel.POOBD.model.Arma;
import br.inatel.POOBD.model.Cofre;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArmaDB extends Database{

    private boolean check = false;

    //inserindo
    //armas serao pré criadas e mostradas ao usuario. Ele escolherá por id e
    public boolean insertArma(Arma arma){
        connect();
        String sql = "INSERT INTO arma(cofre_id) VALUES (?)";
        try{

            pst = connection.prepareStatement(sql);
            pst.setInt(1,arma.cofre_id);
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

    public ArrayList<Arma> researchArma(){
        connect();
        ArrayList<Arma> armas = new ArrayList<>();
        String sql = "SELECT * FROM arma";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Arma armaTemp = new Arma(result.getInt("id"),result.getString("nome"),
                        result.getString("tipoArma"),result.getString("tipoMunicao"),
                        result.getInt("ammocapacity"));


                System.out.println("Arma = "+armaTemp.nome);
                System.out.println("Numero da arma = "+ armaTemp.id);
                System.out.println("Tipo = "+armaTemp.tipoArma);
                System.out.println("Municao = "+ armaTemp.tipoMunicao);
                System.out.println("Maximo de municao = "+armaTemp.ammocapacity);
                System.out.println("-------------------------------------------");
                armas.add(armaTemp);
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

        return armas;

    }

    //atualizando registro
    public boolean updateArma(int id, String nome){
        connect();
        String sql = "UPDATE arma SET nome=? where id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,nome);
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

    public boolean deleteArma(int id){
        connect();
        String sql = "DELETE FROM arma WHERE id=?";
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
