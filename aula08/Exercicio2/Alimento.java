package aula08.Exercicio2;

public interface Alimento {
    double getProteinas();
    double getCalorias();
    double getPeso();
    boolean isVegetariano();
    void setProteinas(double proteinas);
    void setCalorias(double calorias);
    void setPeso(double peso);
    int hashCode();
    boolean equals(Object obj);
} 
