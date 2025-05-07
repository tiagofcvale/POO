package aula08.Exercicio1;

public class Automovel_Ligeiro implements IKmPercorridos {
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia; // em cv
    private int nQuadros; // número de quadros
    private double capacidade;
    private int ultimoTrajeto;
    private int distanciaTotal;

    public Automovel_Ligeiro(String matricula, String marca, String modelo, int potencia, int nQuadros, double capacidade) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.nQuadros = nQuadros;
        this.capacidade = capacidade;
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
    public int getNQuadros() {
        return nQuadros;
    }
    public double getCapacidade() {
        return capacidade;
    }

    @Override
    public String toString() {
        return "Automovel_Ligeiro{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia +
                ", nQuadros=" + nQuadros +
                ", capacidade=" + capacidade +
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
