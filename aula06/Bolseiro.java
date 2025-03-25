package aula06;

import aula05.DateYMD;

public class Bolseiro extends Aluno {
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