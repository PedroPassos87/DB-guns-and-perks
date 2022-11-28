package br.inatel.POOBD.model;

public class Arma {
    public int id;
    public String nome;
    public int cofre_id;
    public String tipoArma;
    public String tipoMunicao;
    public int ammocapacity;

    public int perk_id;

    public Arma(int id,String nome,String tipoArma,String tipoMunicao,int ammocapacity){
        this.id = id;
        this.nome = nome;
        this.tipoArma = tipoArma;
        this.tipoMunicao = tipoMunicao;
        this.ammocapacity = ammocapacity;

    }

}
