package aula04;
import java.util.ArrayList;
import java.util.Scanner;


interface FormaGeometrica {
}

class Circulo implements FormaGeometrica{
    double raio;
    public Circulo(double raio) {
        if (raio<=0) {
            System.out.println("ERRO: MEDIDA INVÁLIDA");
            new Formas();
        } else {
            this.raio = raio;
        }
    }
    public double getRaio() {
        return raio;
    }
    public double setArea() {
        return Math.PI * raio * raio;
    }
    public double setPerimetro() {
        return 2*Math.PI*raio;
    }
    @Override
    public String toString() {
        return "Circulo = {Raio : "+raio+", Area: "+setArea()+", Perimetro: "+setPerimetro()+"}";
    }
}

class Retangulo implements FormaGeometrica{
    double comprimento,altura;
    public Retangulo(double comprimento, double altura) {
        if (comprimento<=0 || altura<=0) {
            System.out.println("ERRO: MEDIDA INVÁLIDA");
            new Formas();
        } else {
            this.comprimento = comprimento;
            this.altura = altura;
        }
    }
    public double getComprimento() {
        return comprimento;
    }
    public double getAltura() {
        return altura;
    }
    public double setArea() {
        return altura*comprimento;
    }
    public double setPerimetro() {
        return altura*2+comprimento*2;
    }
    @Override
    public String toString() {
        return "Retangulo = {Comprimento: "+comprimento+", Altura: "+altura+", Area: "+setArea()+", Perimetro: "+setPerimetro()+"}";
    }
}

class Triangulo implements FormaGeometrica{
    double lado1,lado2,lado3;
    public Triangulo(double lado1,double lado2, double lado3) {
        if (lado1 + lado2 <=lado3 || lado1 + lado3 <= lado2 || lado2+ lado3 <= lado1) {
            System.out.println("ERRO: MEDIDA INVÁLIDA");
            new Formas();
        } else {
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
        }
    }
    public double getLado1() {
        return lado1;
    }
    public double getLado2() {
        return lado2;
    }
    public double getLado3() {
        return lado3;
    }
    public double setArea() {
        double s = (lado1 + lado2 + lado3) / 2; 
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }
    public double setPerimetro() {
        return lado1+lado2+lado3;
    }
    @Override
    public String toString() {
        return "Triangulo = {Lado1: "+lado1+", Lado2: "+lado2+", Lado2: "+lado2+", Area: "+setArea()+", Perimetro: "+setPerimetro()+"}";
    }
}

public class Formas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        ArrayList<FormaGeometrica> formas = new ArrayList<>();
        
        while (true) {
            System.out.println("\nEscolha uma opção: \n1. Adicionar Círculo\n2. Adicionar Triângulo\n3. Adicionar Retângulo\n4. Listar Formas\n5. Sair");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o raio do círculo: ");
                    double raio = sc.nextDouble();
                    if (raio>0) {
                        formas.add(new Circulo(raio));
                        break;
                    } else {
                        System.out.println("Medida Inválida");
                        break;}
                case 2:
                    System.out.print("Digite os três lados do triângulo: ");
                    double lado1 = sc.nextDouble(), lado2 = sc.nextDouble(), lado3 = sc.nextDouble();
                    formas.add(new Triangulo(lado1, lado2, lado3));
                    break;
                case 3:
                    System.out.print("Digite o comprimento e altura do retângulo: ");
                    double comprimento = sc.nextDouble(), altura = sc.nextDouble();

                    formas.add(new Retangulo(comprimento, altura));
                    break;
                case 4:
                if (formas.isEmpty()) {
                    System.out.println("Não possui formas na lista");
                } else {
                    for (FormaGeometrica forma : formas) {
                        System.out.println(forma);
                    }
                    
                }break;
                case 5:
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
