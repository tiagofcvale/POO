package aula09.Exercicio2;

public class CommercialPlane extends Plane {

    private int nTripulantes;

    public CommercialPlane(String nome, String fabricante, String modelo, int anoProd, int capacidadeMax, int velocidadeMax,
            int capacidadePassageiros, int capacidadeCarga, String tipoAeronave) {
        super(nome, fabricante, modelo, anoProd, capacidadeMax, velocidadeMax);
        this.nTripulantes = capacidadePassageiros;
    }

    public int getNTripulantes() {
        return nTripulantes;
    }

    public void setNTripulantes(int nTripulantes) {
        this.nTripulantes = nTripulantes;
    }

    public String getPlaneType() {
        return "Comercial";
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: " + getPlaneType() + " | Tripulantes: " + nTripulantes;
    }
    
}
