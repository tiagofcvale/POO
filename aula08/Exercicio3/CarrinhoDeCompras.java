package aula08.Exercicio3;
import java.util.Set;
import java.util.HashSet;


public class CarrinhoDeCompras implements Compra{

    private Set<Produto> produtos = new HashSet<>(); 
    private double total = 0.0;

    public CarrinhoDeCompras() {}


    @Override
    public void adicionarProduto(Produto produto, int quantidade) {
        if (quantidade > 0) {
            produto.setQuantidade(quantidade);
            produtos.add(produto);
            total += produto.getPreco() * quantidade;
        } else {
            System.out.println("Quantidade inválida.");
        }
    }

    @Override
    public void listarProdutos() {
        System.out.println("Carrinho de Compras:");
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + " - Preço: " + produto.getPreco() + " - Quantidade: " + produto.getQuantidade());
        }
    }

    @Override
    public double calcularTotal() {
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;
    }
    

}
