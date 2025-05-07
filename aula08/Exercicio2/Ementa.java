package aula08.Exercicio2;
import java.util.Set;
import java.util.HashSet;

public class Ementa {
    public enum DiaSemana {
        SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO;
    }

    public enum VariedadeCarne{
        VACA("Vaca"),
        PORCO("Porco"),
        PERU("Peru"),
        FRANGO("Frango"),
        OUTRO("Outra");

        private final String descricao;

        VariedadeCarne(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }
    public enum TipoPeixe{
        CONGELADO("Congelado"),
        FRESCO("Fresco");

        private final String descricao;

        TipoPeixe(String descricao){
            this.descricao=descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }
    
    private String nome;
    private Set<Prato> pratos;
    private String local;

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.pratos = new HashSet<>();
        this.local = local;
    }


    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addPrato(Prato prato, DiaSemana dia) {
        prato.setDiaSemana(dia);
        pratos.add(prato);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Prato prato : pratos) {
            sb.append("Prato '").append(prato.getNome()).append("', composto por ")
            .append(prato.getTotal()).append(" Ingredientes, dia ")
            .append(prato.getDiaSemana()).append("\n");
        }
        return sb.toString();
    }
}
