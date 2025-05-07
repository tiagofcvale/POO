package aula08.Exercicio2;

import java.util.HashSet;
import java.util.Set;

public class PratoDieta extends Prato {
    private String nome;
    private Set<Alimento> composicao;
    private double limiteCalorias;
    
    public PratoDieta(String nome, double limiteCalorias) {
        super(nome);
        this.nome = nome;
        this.composicao = new HashSet<>();
        this.limiteCalorias = limiteCalorias;
    }

    public boolean addIngrediente(Alimento alimento) {
        if (getCalorias() + alimento.getCalorias() <= limiteCalorias) {
            return composicao.add(alimento); 
        }
        return false; 
    }

    public double getLimiteCalorias() {
        return limiteCalorias;
    }

    public void setLimiteCalorias(double limiteCalorias) {
        this.limiteCalorias = limiteCalorias;
    }

    public boolean addAlimento(Alimento a){
        boolean b = composicao.add(a);
        if (b && getCalorias()<=limiteCalorias){
            return composicao.add(a);
        } else {
            return false;
        }
    }

    public double getProteinas() {
        double proteinas = 0;
        for (Alimento alimento : composicao) {
            proteinas += alimento.getProteinas();
        }
        return proteinas;
    }

    public double getCalorias() {
        double calorias = 0;
        for (Alimento alimento : composicao) {
            calorias += alimento.getCalorias();
        }
        return calorias;
    }

    public double getPeso() {
        double peso = 0;
        for (Alimento alimento : composicao) {
            peso += alimento.getPeso();
        }
        return peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "A sair Prato '" + nome + "', composto por " + composicao.size() + " Ingredientes - Prato Dieta ("+limiteCalorias+" Calorias)";
    }
}
