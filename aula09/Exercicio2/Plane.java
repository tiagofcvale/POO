package aula09.Exercicio2;

public class Plane {
    private String nome;
    private String fabricante;
    private String modelo;
    private int anoProd;
    private int capacidadeMax;
    private int velocidadeMax;

    public Plane(String nome, String fabricante, String modelo, int anoProd, int capacidadeMax, int velocidadeMax) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anoProd = anoProd;
        this.capacidadeMax = capacidadeMax;
        this.velocidadeMax = velocidadeMax;
    }

    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoProd() {
        return anoProd;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public int getVelocidadeMax() {
        return velocidadeMax;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoProd(int anoProd) {
        this.anoProd = anoProd;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public void setVelocidadeMax(int velocidadeMax) {
        this.velocidadeMax = velocidadeMax;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "nome='" + nome + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoProd=" + anoProd +
                ", capacidadeMax=" + capacidadeMax +
                ", velocidadeMax=" + velocidadeMax +
                '}';
    }
    
}
