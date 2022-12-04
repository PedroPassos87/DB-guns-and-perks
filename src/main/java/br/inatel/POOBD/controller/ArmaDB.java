package br.inatel.POOBD.controller;

import br.inatel.POOBD.model.Arma;


import java.sql.SQLException;
import java.util.ArrayList;

public class ArmaDB extends Database{

    private boolean check = false;

    //inserindo
    //armas serao pré criadas e mostradas ao usuario. Ele escolherá por id e
    public boolean insertArma(Arma arma){
        connect();
        String sql = "INSERT INTO arma(id,nome,tipoArma,tipoMunicao,ammocapacity) VALUES (?,?,?,?,?)";
        try{

            pst = connection.prepareStatement(sql);
            pst.setInt(1,arma.id);
            pst.setString(2, arma.nome);
            pst.setString(3,arma.tipoArma);
            pst.setString(4,arma.tipoMunicao);
            pst.setInt(5,arma.ammocapacity);
            pst.setInt(6,arma.cofre_id);
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



    public int contador(){
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

         return armas.size();
    }


}
