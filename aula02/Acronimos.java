package aula02;
import java.util.Scanner;

public class Acronimos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto, acr="";
        System.out.println("Texto: ");
        texto = sc.nextLine();
        texto = texto.toUpperCase();
        String[] palavras = texto.split("\\s+");
        for (String string : palavras) {
            if (string.length()>=3) {
                acr += string.charAt(0);
            }
        }
        System.out.println(acr);
        sc.close();
    }
}
