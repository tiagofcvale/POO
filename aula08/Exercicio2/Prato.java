package aula08.Exercicio2;

import java.util.HashSet;
import java.util.Set;

import aula08.Exercicio2.Ementa.DiaSemana;

public class Prato {
    private String nome;
    protected Set<Alimento> composicao;
    private DiaSemana diasemana;
    public Prato(String nome) {
        this.nome=nome;
        this.composicao = new HashSet<>();
    }

    public boolean addIngrediente(Alimento a){
        return composicao.add(a);
    }

    public double getProteinas(){
        double proteinas = 0;
        for (Alimento a : composicao){
            proteinas += a.getProteinas();
        }
        return proteinas;
    }

    public double getCalorias(){
        double calorias = 0;
        for (Alimento a : composicao){
            calorias += a.getCalorias();
        }
        return calorias;
    }

    public double getPeso(){
        double peso = 0;
        for (Alimento a : composicao){
            peso += a.getPeso();
        }
        return peso;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Object getDiaSemana() {
        return diasemana;
    }

    public int getTotal()   {
        return composicao.size();
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diasemana = diaSemana;
    }
    
    @Override
    public String toString() {
        return "A sair Prato '"+ nome + "', composto por "+composicao.size()+" Ingredientes";
    }

}
