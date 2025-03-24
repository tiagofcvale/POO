package aula06;

import aula05.DateYMD;

public class Pessoa {
    private String nome;
    private int cc;
    private DateYMD dataNasc;
    public Pessoa(String nome, int cc, DateYMD dataNasc) {
        this.nome = nome;
        this.cc = cc;
        this.dataNasc = dataNasc;
    }
    public String getNome(){
        return nome;
    }
    public int getCc(){
        return cc;
    }
    public DateYMD getDataNasc() {
        return dataNasc;
    }
    @Override
    public String toString() {
        return "Classe Pessoa: {Nome: "+nome+"; CC: "+cc+"; Data de Nascimento: "+dataNasc+"}";
    }
}
class Aluno extends Pessoa {
    private static int idCounter = 100;
    private int nMec;
    private DateYMD iDataInsc;
    public Aluno(String nome, int cc, DateYMD dataNasc, DateYMD iDataInsc) {
        super(nome, cc, dataNasc);
        this.nMec = ++idCounter;
        this.iDataInsc = iDataInsc;
    }
    public int getNMec() {
        return nMec;
    }
    public DateYMD getIDataInsc() {
        return iDataInsc;
    }
    @Override
    public String toString() {
        return "Classe Aluno: {Nome: "+getNome()+"; CC: "+getCc()+"; Data de Nascimento: "+getDataNasc()+"; Número Mecanográfico: "+getNMec()+"}";
    }
}

class Professor extends Pessoa {
    private String categoria;
    private String departamento;
    public Professor(String nome, int cc, DateYMD dataNasc, String categoria, String departamento) {
        super(nome, cc, dataNasc);
        this.categoria = categoria;
        this.departamento = departamento;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getDepartamento() {
        return departamento;
    }
    @Override
    public String toString() {
        return "Classe Pessoa: {Nome: "+getNome()+"; CC: "+getCc()+"; Data de Nascimento: "+getDataNasc()+"; Categoria: "+categoria+"}";
    }
}

class Bolseiro extends Aluno {
    Professor orientador;
    int bolsa;
    public Bolseiro(String nome, int cc, DateYMD dataNasc, Professor orientador, int bolsa) {
        super(nome, cc, dataNasc, new DateYMD(1, 1, 2024)); // Define uma data padrão
        this.orientador = orientador;
        this.bolsa = bolsa;
    }
    public int getBolsa() {
        return bolsa;
    }
    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
    }
    public Professor getOrientador() {
        return orientador;
    }
    @Override
    public String toString() {
        return "Classe Bolseiro: {Nome: " + getNome() + "; CC: " + getCc() + "; Data de Nascimento: " + getDataNasc() +"; Número Mecanográfico: " + getNMec() + "; Data de Inscrição: " + getIDataInsc() +"; Professor Responsável: " + orientador.getNome() + "; Bolsa: " + bolsa + "}";
    }
}