package aula08.Exercicio1;

public class Veiculo implements IKmPercorridos {
    private int distanciaTotal;
    private int ultimoTrajeto;
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia; // em cv

    public Veiculo(String matricula, String marca, String modelo, int potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.distanciaTotal = 0;
        this.ultimoTrajeto = 0;
    }
    public String getMatricula() {
        return matricula;
    }
    public String getModelo() {
        return modelo;
    }
    public String getMarca() {
        return marca;
    }
    public int getPotencia() {
        return potencia;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia +
                '}';
    }

    @Override
    public void trajeto(int quilometros) {
        if (quilometros > 0) {
            this.ultimoTrajeto = quilometros;
            this.distanciaTotal += quilometros;
        } else {
            System.out.println("A distância do trajeto deve ser positiva.");
        }
    }
    @Override
    public int ultimoTrajeto() {
        return this.ultimoTrajeto;
    }
    @Override
    public int distanciaTotal() {
        return this.distanciaTotal;
    }
}