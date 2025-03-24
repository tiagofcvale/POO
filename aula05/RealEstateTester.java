package aula05;

import java.util.Scanner;

public class RealEstateTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RealEstate imobiliaria = new RealEstate();
        int opcao;

        do {
            System.out.println("\n===== MENU IMOBILIÁRIA =====");
            System.out.println("1 - Adicionar imóvel");
            System.out.println("2 - Vender imóvel");
            System.out.println("3 - Criar leilão");
            System.out.println("4 - Listar imóveis");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome da localidade: ");
                    String nome = sc.nextLine();
                    System.out.print("Número de quartos: ");
                    int quartos = sc.nextInt();
                    System.out.print("Preço: ");
                    int preco = sc.nextInt();
                    imobiliaria.newProperty(nome, quartos, preco);
                    System.out.println("Imóvel adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("ID do imóvel a vender: ");
                    int idVenda = sc.nextInt();
                    imobiliaria.sell(idVenda);
                    break;

                case 3:
                    System.out.print("ID do imóvel para leilão: ");
                    int idLeilao = sc.nextInt();
                    System.out.print("Data do leilão (dia mês ano): ");
                    int dia = sc.nextInt();
                    int mes = sc.nextInt();
                    int ano = sc.nextInt();
                    System.out.print("Duração do leilão (dias): ");
                    int duracao = sc.nextInt();
                    DateYMD data = new DateYMD(dia, mes, ano);
                    imobiliaria.setAuction(idLeilao, data, duracao);
                    break;

                case 4:
                    System.out.println(imobiliaria);
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
