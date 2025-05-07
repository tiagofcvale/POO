package aula08.Exercicio3;

public interface Produto {
    String getNome(); 
    double getPreco();
    int getQuantidade();
    void setQuantidade(int quantidade);
    void removerQuantidade(int quantidade);
}
