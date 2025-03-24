package aula01.tentar;
import java.util.Scanner;

public class KmToMiles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indique a distancia (kilometros): ");
        double km = sc.nextDouble();
        double miles = km / 1.609;
        System.out.println("A distância em milhas é " + miles);
        sc.close();
    }
    
}
