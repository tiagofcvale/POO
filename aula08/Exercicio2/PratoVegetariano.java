package aula08.Exercicio2;

import java.util.HashSet;
import java.util.Set;

public class PratoVegetariano extends Prato {
    private String nome;
    protected Set<Alimento> composicao;

    public PratoVegetariano(String nome) {
        super(nome);
        this.nome=nome;
        this.composicao = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public boolean addIngrediente(Alimento a) {
        if (a.isVegetariano()) {
            return composicao.add(a);
        }
        return false;
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


    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "A sair Prato '"+ nome + "', composto por "+composicao.size()+" Ingredientes - Prato Vegetariano";
    }
}
