package aula07.Galeria;

public class ObraDigital extends Obra {
    String blockchain;
    String enderecoContrato;

    public ObraDigital(String nome, String autor, double preco, String blockchain, String enderecoContrato) {
        super(nome, autor, preco);
        this.blockchain = blockchain;
        this.enderecoContrato = enderecoContrato;
    }
    public String getBlockchain() {
        return blockchain;
    }
    public String getEnderecoContrato() {
        return enderecoContrato;
    }
    @Override
    public String toString() {
        return "Classe Obra Digital: {Nome: "+getNome()+"; Autor: "+getAutor()+"; Preço: "+getPreco()+"; ID: "+getId()+"; Blockchain: "+blockchain+"; Endereço do Contrato: "+enderecoContrato+"}";
    }
}
