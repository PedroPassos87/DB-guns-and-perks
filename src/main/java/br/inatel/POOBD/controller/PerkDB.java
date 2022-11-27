package br.inatel.POOBD.controller;

import br.inatel.POOBD.model.Jogador;
import br.inatel.POOBD.model.Perk;

import java.sql.SQLException;
import java.util.ArrayList;

public class PerkDB extends Database{

    private boolean check = false;

    //inserindo
    public boolean insertPerk(Perk perk){
        connect();
        String sql = "INSERT INTO perk(id,nome,raridade,habilidade) VALUES (?,?,?,?)";
        try{

            pst = connection.prepareStatement(sql);
            pst.setInt(1,perk.id);
            pst.setString(2, perk.nome);
            pst.setString(3,perk.habilidade);
            pst.setString(4,perk.habilidade);
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
    public ArrayList<Perk> researchPerk(){
        connect();
        ArrayList<Perk> perks = new ArrayList<>();
        String sql = "SELECT * FROM perk";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Perk perkTemp = new Perk(result.getInt("id"),result.getString("nome"),result.getString("raridade"),result.getString("habilidade"));


                System.out.println("ID = "+ perkTemp.id);
                System.out.println("PERK = "+perkTemp.nome);
                System.out.println("Raridade = "+perkTemp.raridade);
                System.out.println("Efeito = "+perkTemp.habilidade);
                System.out.println("---------------------------------------");
                perks.add(perkTemp);
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
        return perks;
    }
}
