package br.inatel.POOBD.model;

public class Perk {
    public int id;
    public String nome;
    public String raridade;
    public String habilidade;

    public Perk(int id,String nome,String raridade,String habilidade){
        this.id = id;
        this.nome = nome;
        this.raridade = raridade;
        this.habilidade = habilidade;
    }
}
