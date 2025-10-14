package aula04;

public interface Forma {

    public abstract double calculateArea();
    public abstract double calculatePerimetro();
    public boolean equals(Object obj);
    public int hashCode();

    public String getCor();

    public void setCor(String cor);

}
