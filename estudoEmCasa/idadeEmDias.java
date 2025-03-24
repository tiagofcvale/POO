package estudoEmCasa;
import java.util.Scanner;

public class idadeEmDias {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int anos, meses, dias, total;
        System.out.print("Anos: ");
        anos = sc.nextInt();
        System.out.print("Meses: ");
        meses = sc.nextInt();
        System.out.print("Dias: ");
        dias = sc.nextInt();
        total = (anos * 365) + (meses * 30) + dias;
        System.out.printf("%d anos, %d meses e %d dias = %d dias",anos,meses,dias,total);
        sc.close();
    }
}
