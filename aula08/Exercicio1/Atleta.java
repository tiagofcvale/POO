package aula08.Exercicio1;

public class Atleta implements IKmPercorridos {
    private int distanciaTotal;
    private int ultimoTrajeto;

    public Atleta() {
        this.distanciaTotal = 0;
        this.ultimoTrajeto = 0;
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

    @Override
    public String toString() {
        return "Atleta: {Distância Total: " + distanciaTotal + " km, Último Trajeto: " + ultimoTrajeto + " km}";
    }
}