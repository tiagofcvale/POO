package aula08.Exercicio2;

import aula08.Exercicio2.Ementa.VariedadeCarne;

public class Carne implements Alimento{

    private VariedadeCarne tipo;
    private double proteinas;
    private double calorias;
    private double peso;

    public Carne(VariedadeCarne tipo, double proteinas, double calorias, double peso){
        this.tipo = tipo;
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }

    public VariedadeCarne getTipoCarne(){
        return tipo;
    }

    public void setTipoCarne(VariedadeCarne tipo){
        this.tipo = tipo;
    }

    @Override
    public double getProteinas() {
        return proteinas;
    }

    @Override
    public double getCalorias() {
        return calorias;
    }

    @Override
    public double getPeso() {
        return peso;
    }

    @Override
    public boolean isVegetariano() {
        return false;
    }

    @Override
    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    @Override
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    @Override
    public void setPeso(double peso) {
        this.peso = peso;
    }
    @Override
    public String toString() {
        return "Carne "+tipo+", Proteinas " + proteinas + ", Calorias " + calorias + ", Peso " + peso;
    }

    @Override
    public int hashCode(){
        int result = tipo != null ? tipo.hashCode() : 0;
        result = 31 * result + Double.hashCode(proteinas);
        result = 31 * result + Double.hashCode(calorias);
        result = 31 * result + Double.hashCode(peso);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica se é o mesmo objeto
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica se é da mesma classe
        Carne carne = (Carne) obj; // Faz o cast para Legume
        return Double.compare(carne.proteinas, proteinas) == 0 &&
               Double.compare(carne.calorias, calorias) == 0 &&
               Double.compare(carne.peso, peso) == 0 &&
               (tipo != null ? tipo.equals(carne.tipo) : carne.tipo == null);
    }

}