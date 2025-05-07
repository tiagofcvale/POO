package aula08.Exercicio2;

public class Cereal implements Alimento{

    private double proteinas;
    private double calorias;
    private double peso;
    private String nome;

    public Cereal(double proteinas, double calorias, double peso, String nome) {
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
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
        return true;
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
            return "Cereal "+nome+", Proteinas " + proteinas + ", Calorias " + calorias + ", Peso " + peso;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + Double.hashCode(proteinas);
        result = 31 * result + Double.hashCode(calorias);
        result = 31 * result + Double.hashCode(peso);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica se é o mesmo objeto
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica se é da mesma classe
        Cereal cereal = (Cereal) obj; // Faz o cast para Legume
        return Double.compare(cereal.proteinas, proteinas) == 0 &&
            Double.compare(cereal.calorias, calorias) == 0 &&
            Double.compare(cereal.peso, peso) == 0 &&
            (nome != null ? nome.equals(cereal.nome) : cereal.nome == null);
    }
}
