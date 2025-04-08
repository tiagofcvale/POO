package aula07.Galeria;

public abstract class Obra {
    private String nome;
    private String autor;
    private double preco;
    private int id;
    boolean vendida;
    private static int idCounter = 33;
    public Obra(String nome, String autor, double preco) {
        this.nome = nome;
        this.autor = autor;
        this.preco = preco;
        this.id = idCounter++;
        this.vendida = false;
    }
    public void vender() {
        this.vendida = true;
    }
    public String getNome() {
        return nome;
    }
    public String getAutor() {
        return autor;
    }
    public double getPreco() {
        return preco;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Classe Obra: {Nome: "+nome+"; Autor: "+autor+"; Preço: "+preco+"; ID: "+id+"}";
    }
}