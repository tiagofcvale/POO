package aula06;

import aula05.DateYMD;

public class Professor extends Pessoa {
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