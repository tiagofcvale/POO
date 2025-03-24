package aula02;
import java.util.Scanner;

public class Frases {
    public static void main(String[] args) {
        String frase;
        Scanner sc = new Scanner(System.in);
        System.out.println("Frase: ");
        frase = sc.nextLine();
        System.out.println("Quantidade de números na frase: " + CountDigits(frase));
        System.out.println("Quantidade de espaços na frase: " + CountSpaces(frase));
        System.out.println("Está tudo em minúsculas? " + (isAllLowerCase(frase)? "Sim" : "Não"));
        System.out.println("Frase com espaços corrigidos: " + FixSpaces(frase));
        if (isPalindrome(frase)) {
            System.out.println("A frase é um palindromo!");
        } else {
            System.out.println("A frase não é um palindromo!");
        }
        sc.close();
    }
    public static int CountDigits(String s) {
        int count = 0;
        for (char character : s.toCharArray()) {
            if (Character.isDigit(character)) {
                count++;
            }
        }
        return count;
    }
    public static int CountSpaces(String s) {
        int count = 0;
        for (char character : s.toCharArray()) {
            if (Character.isWhitespace(character)) {
                count++;
            }
        }
        return count;
    }
    public static String FixSpaces(String s) {
        StringBuilder texto = new StringBuilder();
        boolean lastWasSpace = false;
        for (char character : s.toCharArray()) {
            if (Character.isWhitespace(character)) {
                if (!lastWasSpace) {
                    texto.append(' ');
                    lastWasSpace = true;
                }
            } else {
                texto.append(character);
                lastWasSpace = false;
            }
        }
        return texto.toString().trim();
    }
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean isAllLowerCase(String s) {
        String comparador = "";
        comparador = s.toLowerCase();
        if (comparador.equals(s)) {
            return true;
        } else {
            return false;
        }
    }
}
