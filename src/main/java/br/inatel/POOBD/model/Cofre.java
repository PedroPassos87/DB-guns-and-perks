package br.inatel.POOBD.model;

public class Cofre {
    public int id;
    public int capacidade;
    public String senha;
    public int jogador_id ;

    public Cofre(String senha,int capacidade){
        this.senha = senha;

        this.capacidade = capacidade;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
