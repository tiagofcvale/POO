package aula09.Exercicio2;

public class MilitaryPlane extends Plane {

    private int nMunicoes;

    public MilitaryPlane(String nome, String fabricante, String modelo, int anoProd, int capacidadeMax, int velocidadeMax,
            int capacidadePassageiros, int capacidadeCarga, String tipoAeronave) {
        super(nome, fabricante, modelo, anoProd, capacidadeMax, velocidadeMax);
        this.nMunicoes = capacidadePassageiros;
    }

    public int getNMunicoes() {
        return nMunicoes;
    }

    public void setNMunicoes(int nMunicoes) {
        this.nMunicoes = nMunicoes;
    }

    public String getPlaneType() {
        return "Militar";
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: " + getPlaneType() + " | Municoes: " + nMunicoes;
    }
    
}
