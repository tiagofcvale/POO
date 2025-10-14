package aula04;

public class Rectangle implements Forma {
    int comprimento, altura;
    String cor;

    public Rectangle(int comprimento, int altura, String cor){
        this.comprimento = comprimento;
        this.altura = altura;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Rectangle [comprimento=" + comprimento + ", altura=" + altura + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + comprimento;
        result = prime * result + altura;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rectangle other = (Rectangle) obj;
        if (comprimento != other.comprimento)
            return false;
        if (altura != other.altura)
            return false;
        return true;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double calculateArea(){
        return comprimento * altura;
    }

    public double calculatePerimetro(){
        return 2*(comprimento + altura);
    }

    @Override
    public String getCor() {
        return this.cor;
    }

    @Override
    public void setCor(String cor) {
        this.cor = cor;
    }
}
