package aula08.Exercicio3;

public class ProdutoGenerico implements Produto {

    private String nome;
    private double preco;
    private int quantidade;

    public ProdutoGenerico(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public void removerQuantidade(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
        } else {
            System.out.println("Quantidade insuficiente para remover.");
        }
    }

    @Override
    public String toString() {
        return "ProdutoGenerico [nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + "]";
    }
    
}
