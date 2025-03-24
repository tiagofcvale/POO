package estudoEmCasa;
import java.util.Scanner;

class Car {
    int ano;
    String nome;
    public Car(int a, String n) {
        ano = a;
        nome = n;
    }
    public int getAno () {
        return ano;
    }
    public String getNome() {
        return nome;
    }
    
    @Override
    public String toString() {
        return "Carro {Nome : "+nome+", Ano : "+ano+"}";
    }
}

public class Carro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome;
        int ano;
        System.out.println("Nome do carro: ");
        nome = sc.nextLine();
        System.out.println("Ano do carro: ");
        ano = sc.nextInt();
        Car cr = new Car(1998,"Seat");
        int anoDoCarro = cr.getAno();
        String nomeDoCarro = cr.getNome();
        System.out.println("Carro = "+cr);
        System.out.println("Ano: "+anoDoCarro);
        System.out.println("Nome: "+nomeDoCarro);
        System.out.println("----------------");
        Car nCr = new Car(ano,nome);
        anoDoCarro = nCr.getAno();
        nomeDoCarro= nCr.getNome();
        System.out.println("Carro Criado: "+nCr);
        System.out.println("Ano: "+anoDoCarro);
        System.out.println("Nome: "+nomeDoCarro);
        sc.close();
    }
}
