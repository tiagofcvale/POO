package aula08.Exercicio1;

public class Pesado_Mercadorias implements IKmPercorridos{
    private int distanciaTotal;
    private int ultimoTrajeto;
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia; // em cv
    private int nQuadros; // número de quadros
    private double peso; // peso em kg
    private double cargaMax;

    public Pesado_Mercadorias(String matricula, String marca, String modelo, int potencia, int nQuadros, double peso, double cargaMax) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.nQuadros = nQuadros;
        this.peso = peso;
        this.cargaMax = cargaMax;
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
    public int getNQuadros() {
        return nQuadros;
    }
    public double getPeso() {
        return peso;
    }
    public double getCargaMax() {
        return cargaMax;
    }

    @Override
    public String toString() {
        return "Pesado_Mercadorias{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia +
                ", nQuadros=" + nQuadros +
                ", peso=" + peso +
                ", cargaMax=" + cargaMax +
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
