package aula07.Galeria;
import java.util.ArrayList;
import java.util.List;

public class Galeria {
    List<Obra> galeria;
    double valor;
    public Galeria() {
        this.galeria = new ArrayList<>();
        this.valor = 0.0;
    }

    public void adicionarObra(Obra obra) {
        galeria.add(obra);
    }

    public void listarObras() {
        for (Obra obra : galeria) {
            System.out.println(obra);
        }
    }
    
    public void venderObra(int id, double preco) {
        for (Obra obra : galeria) {
            if (obra.getId() == id) {
                if (obra.vendida) {
                    System.out.println("Obra já foi vendida!");
                    return;
                } else {
                    obra.vender();
                    System.out.println("Obra vendida: " + obra.getNome() + " por " + preco);
                    valor += preco;
                }
            }
        }
    }

    public double lucro() {
        double total = 0.0;
        for (Obra obra : galeria) {
            total += obra.getPreco();
        }
        return (total - valor);
    }

    public void gerirVendas() {
        for (Obra obra : galeria) {
            if (obra.vendida) {
                System.out.println("Obra vendida: " + obra.getNome() + " por " + obra.getPreco());
            } else {
                System.out.println("Obra não vendida: " + obra.getNome());
            }
        }
    }
}
