package aula03;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int guess, rdm, tries;
        String ctn;
        ctn = "Y";
        Scanner sc = new Scanner(System.in);
        while (ctn.equals("Y") || ctn.equals("y")) {
            System.out.println("HighLow Game!");
            rdm = (int) (Math.random() * 101);
            System.out.println("Guess a number between 1 and 100: ");
            guess = sc.nextInt();
            tries = 1;
            while (rdm != guess) {
                if (guess > rdm) {
                    System.out.println("Number too High!");
                } else {
                    System.out.println("Number too Low!");
                }
                System.out.println("Guess a number between 1 and 100: ");
                guess = sc.nextInt();
                tries++;
            }
            ctn = sc.nextLine();
            System.out.println("Congratiulations!\nIt took you "+tries+" tries to guess the number "+rdm+"\nContinue? (Y/N)");
            ctn = sc.nextLine();
        }
        System.out.println("Terminating...");
        sc.close();
    }
    
}
