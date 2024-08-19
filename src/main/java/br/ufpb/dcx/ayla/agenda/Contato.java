package br.ufpb.dcx.ayla.agenda;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable {


    private String nome;
    private int diaAniversario;
    private int mesAniversario;

    public Contato(String nome,int dia, int mes){
        this.nome=nome;
        this.diaAniversario=dia;
        this.mesAniversario=mes;
    }

    public boolean equals(Object a){
        if(this==a) return true;
        if(a==null||getClass()!=a.getClass())return false;
        Contato contato=(Contato) a;
        return Objects.equals(nome, contato.nome)&& Objects.equals(diaAniversario, contato.diaAniversario)&& Objects.equals(mesAniversario, contato.mesAniversario);
    }


    public int hashCode() {
        return Objects.hash(nome, diaAniversario, mesAniversario);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public int getMesAniversario() {
        return mesAniversario;
    }

    public void setMesAniversario(int mesAniversario) {
        this.mesAniversario = mesAniversario;
    }

    public String ToString(){
        return "a pessoa com o nome:"+this.nome+" faz aniversario no dia:"+this.diaAniversario+" do mes:"+this.mesAniversario;
    }
}
