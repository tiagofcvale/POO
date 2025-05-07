package aula08.Exercicio1;

public class Taxi extends Automovel_Ligeiro{
    private int nLicensa;

    public Taxi(String matricula, String marca, String modelo, int potencia, int nQuadros, double capacidade, int nLicensa) {
        super(matricula, marca, modelo, potencia, nQuadros, capacidade);
        this.nLicensa = nLicensa;
    }

    public int getnLicensa() {
        return nLicensa;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "nLicensa=" + nLicensa +
                ", matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", potencia=" + getPotencia() +
                ", nQuadros=" + getNQuadros() +
                ", capacidade=" + getCapacidade() +
                '}';
    }
    
}
