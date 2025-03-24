package aula02;
import java.util.Scanner;
import java.util.ArrayList;

public class Media {
    public static void main(String[] args) {
        double x, soma = 0, count = 0, media;
        String texto;
        texto = "Números acima da média: ";
        ArrayList<Double> nums = new ArrayList<>();
        System.out.println("Valor: ");
        Scanner sc = new Scanner(System.in);
        x = sc.nextDouble();
        soma += x;
        nums.add(x);
        while (x != 0) {
            System.out.println("Valor: ");            
            x = sc.nextDouble();
            count = count +1;
            soma += x;
            nums.add(x);
        }
        nums.remove(nums.size()-1);
        media = soma / count;
        System.out.printf("Média dos valores introduzidos: %.2f%n",media);
        System.out.println("Lista: " + nums);
        for (Double num : nums) {
            if (num > media) {
                texto += num+", ";
            }
        }
        System.out.println(texto);
        sc.close();
    }
}
