package aula02;
import java.util.Scanner;

public class distancia {
    public static void main(String[] args) {
        double x1, x2, y1, y2, dist;
        Scanner sc = new Scanner(System.in);
        System.out.println("Primeiro Ponto! (x): ");
        System.out.println("x1: ");
        x1 = sc.nextDouble();
        System.out.println("x2: ");
        x2 = sc.nextDouble();
        System.out.println("Segundo Ponto! (Y): ");
        System.out.println("y1: ");
        y1 = sc.nextDouble();
        System.out.println("y2: ");
        y2 = sc.nextDouble();
        dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2-y1, 2));
        System.out.printf("A distancia entre x e y é de %.2f%n",dist);
        sc.close();
    }
}
