package aula07.Galeria;

public class Quadro extends Obra {
    boolean emoldurado;
    public enum TipoTinta {
        OLEO("Óleo"),
        AGUARELA("Aguarela"),
        GUACHE("Guache");

        private final String descricao;

        TipoTinta(String descricao) {
            this.descricao = descricao;
        }
        public String getDescricao() {
            return descricao;
        }
    }
    private TipoTinta tipoTita;

    public enum TamanhoTela {
        S("Pequeno"),
        M("Médio"),
        L("Grande"),
        XL("Extra Grande");

        private final String descricao;

        TamanhoTela(String descricao) {
            this.descricao = descricao;
        }
        public String getDescricao() {
            return descricao;
        }
    }

    TamanhoTela tamanhoTela;
    public Quadro(String nome, String autor, double preco, TipoTinta tipoTita, TamanhoTela tamanhoTela, boolean emoldurado) {
        super(nome, autor, preco);
        this.emoldurado = emoldurado;
        this.tipoTita = tipoTita;
        this.tamanhoTela = tamanhoTela;
    }
    public boolean isEmoldurado() {
        return emoldurado;
    }
    public TipoTinta getTipoTita() {
        return tipoTita;
    }
    public TamanhoTela getTamanhoTela() {
        return tamanhoTela;
    }
    @Override
    public String toString() {
        return "Classe Quadro: {Nome: "+getNome()+"; Autor: "+getAutor()+"; Preço: "+getPreco()+"; ID: "+getId()+"; Emoldurado: "+emoldurado+"; Tipo de Tinta: "+tipoTita+"; Tamanho da Tela: "+tamanhoTela+"}";
    }
}
