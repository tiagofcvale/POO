package aula02;
import java.util.Arrays;
import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        String texto, texto2 = "Primeiras 3 letras: ";
        char last;
        Scanner sc = new Scanner(System.in);
        System.out.println("String: "); 
        texto = sc.nextLine();
        System.out.println("Lower case: " + texto.toLowerCase());
        last = texto.charAt(texto.length()-1);
        System.out.println("Last Character: " + last);
        for (int i = 0; i < 3; i++) {
            texto2 = texto2 + texto.charAt(i) ;
        }
        System.out.println(texto2);
        String[] splitResult = texto.split("\\W");
        System.out.println("Texto separado pelos espaços: " + Arrays.toString(splitResult));
        sc.close();
    }
}
