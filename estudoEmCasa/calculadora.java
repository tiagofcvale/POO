package estudoEmCasa;
import java.util.Scanner;

public class calculadora {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n1, n2;
        String op;
        System.out.print("\nIndique o primeiro número: ");
        n1 = sc.nextDouble();
        System.out.print("\nIndique o operador:  ");
        op = sc.next();
        System.out.print("\nIndique o segundo número: ");
        n2 = sc.nextDouble();
        if (n2 == 0 && op.equals("/")) {
            System.out.print("\nErro! O segundo número tem de ser difirente de 0!");
            System.out.print("\nIndique o segundo número: ");
            n2 = sc.nextDouble();
        }
        switch (op) {
            case "+":
                adicao(n1, n2);
                break;
            case "-":
                subtracao(n1, n2);
                break;
            case "*":
                System.out.println(multiplicacao(n1, n2));
                break;
            case "/":
                divisao(n1, n2);
                break;
            default:
                System.out.println("Operador inválido.");
                break;
        }
        sc.close();
    }
    public static void adicao(double n1, double n2) {
        double res;
        res = n1 + n2;
        System.out.printf("Resultado = %.2f%n",res);
    }
    public static void subtracao(double n1, double n2) {
        double res;
        res = n1 - n2;
        System.out.printf("Resultado = %.2f%n",res);
    }
    public static String multiplicacao(double n1, double n2) {
        double res;
        String texto;
        res = n1 * n2;
        texto = "Resultado = " + res;
        return texto;
    }
    public static void divisao(double n1, double n2) {
        double res;
        res = n1 / n2;
        System.out.printf("Resultado = %.2f%n",res);
    }
}
