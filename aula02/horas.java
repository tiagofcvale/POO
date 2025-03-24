package aula02;
import java.util.Scanner;

public class horas {
    public static void main(String[] args) {
        int horas, minutos, segundos;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dígite o tempo em segundos: ");
        segundos = sc.nextInt();
        horas = segundos / 3600;
        minutos = (segundos - (horas * 3600))/60;
        segundos = segundos - ((horas*3600)+(minutos*60));
        System.out.printf("HH:mm:ss\n%d:%d:%d",horas,minutos,segundos);
        sc.close();
    }
}
