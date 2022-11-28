package br.inatel.POOBD.model;

public class Cofre {
    public int id;
    public int capacidade ;
    private String senha;
    public int jogador_id ;

    public Cofre(int capacidade,String senha,int jogador_id){
        this.capacidade = capacidade;
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
