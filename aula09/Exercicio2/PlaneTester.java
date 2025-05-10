package aula09.Exercicio2;

import java.util.Scanner;

public class PlaneTester {
    public static void main(String[] args) {
        PlaneManager manager = new PlaneManager();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Plane Manager ---");
            System.out.println("1. Adicionar Avião");
            System.out.println("2. Remover Avião");
            System.out.println("3. Procurar Avião");
            System.out.println("4. Listar Todos os Aviões");
            System.out.println("5. Listar Aviões Comerciais");
            System.out.println("6. Listar Aviões Militares");
            System.out.println("7. Avião Mais Rápido");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (option) {
                case 1:
                    System.out.print("Tipo de Avião (1-Comercial, 2-Militar): ");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Fabricante: ");
                    String fabricante = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ano de Produção: ");
                    int anoProd = scanner.nextInt();
                    System.out.print("Capacidade Máxima: ");
                    int capacidadeMax = scanner.nextInt();
                    System.out.print("Velocidade Máxima: ");
                    int velocidadeMax = scanner.nextInt();

                    if (type == 1) {
                        System.out.print("Número de Tripulantes: ");
                        int nTripulantes = scanner.nextInt();
                        manager.addPlane(new CommercialPlane(nome, fabricante, modelo, anoProd, capacidadeMax, velocidadeMax, nTripulantes, 0, "Comercial"));
                    } else if (type == 2) {
                        System.out.print("Número de Munições: ");
                        int nMunicoes = scanner.nextInt();
                        manager.addPlane(new MilitaryPlane(nome, fabricante, modelo, anoProd, capacidadeMax, velocidadeMax, nMunicoes, 0, "Militar"));
                    }
                    break;

                case 2:
                    System.out.print("Nome do Avião a Remover: ");
                    String idToRemove = scanner.nextLine();
                    if (manager.removePlane(idToRemove)) {
                        System.out.println("Avião removido com sucesso.");
                    } else {
                        System.out.println("Avião não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Nome do Avião a Procurar: ");
                    String idToSearch = scanner.nextLine();
                    Plane foundPlane = manager.searchPlane(idToSearch);
                    if (foundPlane != null) {
                        System.out.println("Avião encontrado: " + foundPlane);
                    } else {
                        System.out.println("Avião não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Lista de Todos os Aviões:");
                    manager.printAllPlanes();
                    break;

                case 5:
                    System.out.println("Lista de Aviões Comerciais:");
                    for (Plane plane : manager.getCommercialPlanes()) {
                        System.out.println(plane);
                    }
                    break;

                case 6:
                    System.out.println("Lista de Aviões Militares:");
                    for (Plane plane : manager.getMilitaryPlanes()) {
                        System.out.println(plane);
                    }
                    break;

                case 7:
                    Plane fastestPlane = manager.getFastestPlane();
                    if (fastestPlane != null) {
                        System.out.println("Avião Mais Rápido: " + fastestPlane);
                    } else {
                        System.out.println("Nenhum avião na frota.");
                    }
                    break;

                case 8:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 8);

        scanner.close();
    }
}