package aula03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import aula05.*;

public class Ex7 {
    public static void main(String[] args) throws IOException{ 
        Scanner input = new Scanner(new FileReader("major.txt")); 
        FileWriter writer = new FileWriter("Ex7.txt");
        while (input.hasNext()) {
            String word = input.next();
            if (word.length()>2) {
                writer.write(word + "\n");
            }
            if (word.endsWith("s") && isAllCharacter(word)) {
                System.out.println("Palavras filtradas: "+ word);
            }
        }
        DateYMD date = new DateYMD(4, 4, 2006);
        System.out.println("Data: "+date);
        input.close();
        writer.close();
    }
    public static boolean isAllCharacter(String word) {
        for (char character : word.toCharArray()) {
            if (!Character.isLetter(character) || character > 127) {
                return false;
            }
        }
        return true;
    }
    
}
