package aula08.Exercicio1;

public class Motociclo implements IKmPercorridos {

    private int distanciaTotal;
    private int ultimoTrajeto;

    public enum TipoMotociclo {
       DESPORTIVO("Desportivo"),
       ESTRADA("Estrada");
       
       private final String descricao;

       TipoMotociclo(String descricao) {
           this.descricao = descricao;
       }

       public String getDescricao() {
           return descricao;
       }
    }

    private String matricula;
    private String marca;
    private String modelo;
    private int potencia; // em cv
    private TipoMotociclo tipoMotociclo;

    public Motociclo(String matricula, String marca, String modelo, int potencia, TipoMotociclo tipoMotociclo) {
        this.tipoMotociclo = tipoMotociclo;
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
    public TipoMotociclo getTipoMotociclo() {
        return tipoMotociclo;
    }

    @Override
    public String toString() {
        return "Motociclo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia +
                ", tipoMotociclo=" + tipoMotociclo.getDescricao() +
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
