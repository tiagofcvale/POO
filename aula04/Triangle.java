package aula04;

public class Triangle implements Forma {
    int lado1, lado2, lado3;
    String cor;

    public Triangle(int lado1, int lado2, int lado3, String cor){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.cor = cor; 
    }

    @Override
    public String toString() {
        return "Triangle [lado1=" + lado1 + ", lado2=" + lado2 + ", lado3=" + lado3 + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + lado1;
        result = prime * result + lado2;
        result = prime * result + lado3;
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
        Triangle other = (Triangle) obj;
        if (lado1 != other.lado1)
            return false;
        if (lado2 != other.lado2)
            return false;
        if (lado3 != other.lado3)
            return false;
        return true;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public void setLado3(int lado3) {
        this.lado3 = lado3;
    }

    public int getLado1() {
        return lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public int getLado3() {
        return lado3;
    }

    public double calculateArea(){
        double p = (lado1+lado2+lado3)/2;
        return Math.sqrt(p*(p-lado1)*(p-lado2)*(p-lado3));
    }

    public double calculatePerimetro(){
        return lado1+lado2+lado3;
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

