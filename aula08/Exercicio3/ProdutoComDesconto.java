package aula08.Exercicio3;

public class ProdutoComDesconto implements Produto{
    private double desconto;
    private String nome;
    private double preco;
    private int quantidade;

    public ProdutoComDesconto(String nome, double preco, int quantidade, double desconto) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco - (preco * desconto / 100);
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
    
}