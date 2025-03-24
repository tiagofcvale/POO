package aula02;
import java.util.Scanner;

public class Hip {
    public static void main(String[] args) {
        double A, B, hip, ang, ahip;
        Scanner sc = new Scanner(System.in);
        System.out.println("Comprimento do Cateto A: ");
        A = sc.nextDouble();
        System.out.println("Comprimento do Cateto B: ");
        B = sc.nextDouble();
        hip = Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2));
        ahip = A/hip;
        ang = Math.acos(ahip);
        System.out.printf("\nA: %.2f%n \nB: %.2f%n \nHipotenusa (C): %.2f%n \nÂngulo entre C e A: %.2f%n",A,B,hip,ang);
        sc.close();
    }
}
