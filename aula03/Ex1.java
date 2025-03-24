package aula03;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int num, sum;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a positive number: ");
        num = sc.nextInt();
        sum = 0;
        while (num>0) {
            if (num == 1 || num == 2 || isPrimeNumber(num)) {
                System.out.println("Is Prime Number!");
                sum += num;
            } else {
                System.out.println("It's not Prime Number");
            }
            System.out.println("Input a positive number: ");
            num = sc.nextInt();
        }
        System.out.println("Soma = "+sum);
        sc.close();
    }
    public static boolean isPrimeNumber(int num) {
        for (int i = 2; i < num; i++) {
            if (num%i == 0) {
                return false;
            }
        }
        return true;
    }
}
