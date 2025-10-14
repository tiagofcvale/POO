package aula04;

public class Circle implements Forma {
    private double raio;
    private String cor;
    public Circle(double raio, String cor){
        this.raio = raio;
        this.cor = cor; 
    }

    @Override
    public String toString() {
        return "Circle [raio=" + raio + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(raio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Circle other = (Circle) obj;
        if (Double.doubleToLongBits(raio) != Double.doubleToLongBits(other.raio))
            return false;
        return true;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double calculateArea(){
        return Math.PI * raio * raio;
    }

    public double calculatePerimetro(){
        return Math.PI * raio * 2;
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
