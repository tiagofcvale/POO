package aula07.Galeria;

import java.util.Scanner;

import aula07.Galeria.Escultura.Material;
import aula07.Galeria.Quadro.TamanhoTela;
import aula07.Galeria.Quadro.TipoTinta;

public class GaleriaTester {
    public static void main(String[] args) {
        Galeria galeria = new Galeria();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu Galeria ---");
            System.out.println("1. Adicionar Obra");
            System.out.println("2. Listar Obras");
            System.out.println("3. Vender Obra");
            System.out.println("4. Ver Lucro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("\n1. Quadro");
                    System.out.println("2. Escultura");
                    System.out.println("3. Obra Digital (NFT)");
                    System.out.print("Escolha o tipo de obra: ");
                    int tipoObra = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    System.out.print("Nome da Obra: ");
                    String nome = scanner.nextLine();

                    System.out.print("Autor da Obra: ");
                    String autor = scanner.nextLine();

                    System.out.print("Preço da Obra: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha

                    if (tipoObra == 1) { // Quadro
                        System.out.println("Escolha o Tipo de Tinta (Oleo, Aguarela, Guache):");
                        String tipoTintaTexto = scanner.nextLine().toUpperCase(); // Ler texto e converter para maiúsculas
                        TipoTinta tipoTinta;
                        try {
                            tipoTinta = TipoTinta.valueOf(tipoTintaTexto);
                        }  catch (IllegalArgumentException e) {
                            System.out.println("Tipo de tinta inválido. Usando padrão: Óleo.");
                            tipoTinta = TipoTinta.OLEO;
                        }

                        System.out.print("Obra emoldurada? (s/n): ");
                        char emolduradaChar = scanner.nextLine().toLowerCase().charAt(0);
                        boolean emoldurada = emolduradaChar == 's';

                        System.out.print("Tamanho da Tela (S,M,L,XL): ");
                        String tamanhoTelaText = scanner.nextLine();

                        TamanhoTela tamanhoTela;

                        try {
                            tamanhoTela = TamanhoTela.valueOf(tamanhoTelaText.toUpperCase()); // Converter para maiúsculas
                        } catch (IllegalArgumentException e) {
                            System.out.println("Tamanho da tela inválido. Usando padrão: Pequeno.");
                            tamanhoTela = TamanhoTela.S;
                        }

                        Quadro quadro = new Quadro(nome, autor, preco, tipoTinta, tamanhoTela, emoldurada);
                        galeria.adicionarObra(quadro);

                    } else if (tipoObra == 2) { 
                        System.out.println("Escolha o Material da Escultura (Madeira, Cerâmica, Metal): ");
                        String materialTexto = scanner.nextLine().toUpperCase(); // Ler texto e converter para maiúsculas

                        Material material;
                        try {
                            material = Material.valueOf(materialTexto); 
                        } catch (IllegalArgumentException e) {
                            System.out.println("Material inválido. Usando padrão: Mármore.");
                            material = Material.MADEIRA;
                        }

                        System.out.println("Quantas peças? (1 para peça única)");
                        int numPecas = scanner.nextInt();


                        Escultura escultura = new Escultura(nome, autor, preco, material, numPecas);
                        galeria.adicionarObra(escultura);

                    } else if (tipoObra == 3) { // Obra Digital
                        System.out.print("Blockchain: ");
                        String blockchain = scanner.nextLine();

                        System.out.print("Endereço do Contrato: ");
                        String enderecoContrato = scanner.nextLine();

                        ObraDigital obraDigital = new ObraDigital(nome, autor, preco, blockchain, enderecoContrato);
                        galeria.adicionarObra(obraDigital);

                    } else {
                        System.out.println("Tipo de obra inválido.");
                    }
                    break;

                case 2:
                    galeria.listarObras();
                    break;

                case 3:
                    System.out.print("Digite o ID da obra a ser vendida: ");
                    int id = scanner.nextInt();

                    System.out.print("Digite o preço de venda: ");
                    double precoVenda = scanner.nextDouble();

                    galeria.venderObra(id, precoVenda);
                    break;

                case 4:
                    System.out.println("Lucro total: " + galeria.lucro() + "€");
                    break;

                case 5:
                    scanner.close();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}