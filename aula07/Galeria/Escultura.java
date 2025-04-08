package aula07.Galeria;

public class Escultura extends Obra {
    int NumPecas;

    public enum Material {
        MADEIRA("Madeira"),
        METAL("Metal"),
        CERAMICA("Cerâmica");

        private final String descricao;

        Material(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
    private Material material;

    public Escultura(String nome, String autor, double preco, Material material, int NumPecas) {
        super(nome, autor, preco);
        this.material = material;
        this.NumPecas = NumPecas;
    }
    public Material getMaterial() {
        return material;
    }
    public int getNumPecas() {
        if (NumPecas == 1) {
            pecaUnica();
        }
        return NumPecas;
    }
    public String pecaUnica() {
        return "Peça Unica";
    }
    @Override
    public String toString() {
        return "Classe Escultura: {Nome: "+getNome()+"; Autor: "+getAutor()+"; Preço: "+getPreco()+"; ID: "+getId()+"; Material: "+material+"; Número de Peças: "+NumPecas+"}";
    }
}
