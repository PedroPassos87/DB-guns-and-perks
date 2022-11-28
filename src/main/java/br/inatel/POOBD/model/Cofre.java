package br.inatel.POOBD.model;

public class Cofre {
    public int id;
    public int capacidade = 5;
    private String senha;
    public int jogador_id ;

    public Cofre(String senha,int jogador_id){
        this.senha = senha;
        this.jogador_id = jogador_id;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
