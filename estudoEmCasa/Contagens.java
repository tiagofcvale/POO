package estudoEmCasa;
import java.util.Scanner;

public class Contagens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Número de loops?: ");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println(i);
        }
        System.out.println("Fim");
        sc.close();
    }
}
