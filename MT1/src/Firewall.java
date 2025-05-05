import java.util.List;
import java.util.ArrayList;

public class Firewall {
    public List<Pacote> fila = new ArrayList<>();
    public List<Pacote> processados = new ArrayList<>();
    public static Pacote ultimoProcessado = null;

    private String nome;

    public Firewall(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void addPacote(Pacote p) {
        fila.add(p);
    }

    public void removePacote(Pacote p) {
        fila.remove(p);
    }

    public boolean hasPacotes() {
        return !fila.isEmpty();
    }

    public void processarPacote() {
        Pacote pacote = fila.get(0);

        if (pacote.equals(ultimoProcessado)) {
            System.out.println("(pacote repetido)");
            return;
        }
        if (pacote instanceof Pedido) {
            System.out.println("[NEW] " + pacote);
        } else if (pacote instanceof Resposta) {
            System.out.println("[REPLIED] " + pacote);
        } else {
            System.out.println("[INVALID] " + pacote);
        }
        

        processados.add(pacote);
        ultimoProcessado = pacote;
        fila.remove(pacote);
    }

    public int getTamanhoFila() {
        int tamanho = 0;
        for (Pacote p : fila) {
            tamanho += p.getMensagem().length();
        }
        return tamanho;
    }

    @Override
    public String toString() {
        return "Firewall " + nome + " está UP, tamanhoFila=" + getTamanhoFila();
    }
}