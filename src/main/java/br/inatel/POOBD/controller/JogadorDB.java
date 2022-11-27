package br.inatel.POOBD.controller;

import br.inatel.POOBD.model.Cofre;
import br.inatel.POOBD.model.Jogador;

import java.sql.SQLException;
import java.util.ArrayList;

public class JogadorDB extends Database{
    private boolean check = false;

    //inserindo
    public boolean insertJogador(Jogador jogador){
        connect();
        String sql = "INSERT INTO jogador(nick,xp) VALUES (?,?)";
        try{

            pst = connection.prepareStatement(sql);
            pst.setString(1,jogador.nick);
            pst.setInt(2, jogador.xp);
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
    public ArrayList<Jogador> researchJogador(){
        connect();
        ArrayList<Jogador> jogadores = new ArrayList<>();
        String sql = "SELECT * FROM jogador";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Jogador jogadorTemp = new Jogador(result.getString("nick"),result.getInt("xp"));
                jogadorTemp.id = result.getInt("id");

                System.out.println("ID = "+ jogadorTemp.id);
                System.out.println("Nick = "+jogadorTemp.nick);
                System.out.println("Nivel = "+jogadorTemp.xp);
                System.out.println("---------------------------------------");
                jogadores.add(jogadorTemp);
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
        return jogadores;
    }

    //atualizando registro
    public boolean updateJogador(int id, String nick,int xp){
        connect();
        String sql = "UPDATE jogador SET nick=?,xp=? where id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,nick);
            pst.setInt(2,xp);
            pst.setInt(3,id);
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

    //deletar
    public boolean deleteJogador(int id){
        connect();
        String sql = "DELETE FROM jogador WHERE id=?";
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
