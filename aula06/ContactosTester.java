package aula06;

import java.util.Scanner;
import aula05.DateYMD;

public class ContactosTester {
    public static void main(String[] args) {
        int escolha = -1;
        int id = 0;
        int cc = 0;
        int dia = 0, mes = 0, ano = 0;
        int numero = 0;
        String nome = "";
        String email = "";
        Pessoa pessoa = null;
        Contactos contacto = null;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. Inserir contacto");
            System.out.println("2. Alterar contacto");
            System.out.println("3. Apagar contacto");
            System.out.println("4. Procurar contacto");
            System.out.println("5. Listar contactos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Dados da Pessoa: ");
                    System.out.println("Nome? ");
                    nome = sc.nextLine();
                    System.out.println("CC? ");
                    cc = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Data de Nascimento: ");
                    System.out.println("Dia? ");
                    dia = sc.nextInt();
                    mes = sc.nextInt();
                    ano = sc.nextInt();
                    sc.nextLine();
                    DateYMD data = new DateYMD(dia, mes, ano);
                    pessoa = new Pessoa(nome, cc, data);
                    System.out.println("Número de telemovel? (9 caracteres, primeiro número tem de ser 9) ");
                    numero = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Email? (abcdefg@abc.efg) ");
                    email = sc.nextLine();
                    contacto = new Contactos(numero, email, pessoa);
                    contacto.inserirContacto(contacto);
                    break;
                case 2:
                    System.out.println("Contacto que pretende alterar (id): ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Dados da Pessoa: ");
                    System.out.println("Nome? ");
                    nome = sc.nextLine();
                    System.out.println("CC? ");
                    cc = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("Data de Nascimento: ");
                    System.out.println("Dia? ");
                    dia = sc.nextInt();
                    mes = sc.nextInt();
                    ano = sc.nextInt();
                    sc.nextLine();
                    DateYMD newData = new DateYMD(dia, mes, ano);
                    Pessoa newPessoa = new Pessoa(nome, cc, newData);
                    System.out.println("Número de telemovel? (9 caracteres, primeiro número tem de ser 9) ");
                    numero = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("Email? (abcdefg@abc.efg) ");
                    email = sc.nextLine();
                    contacto.alterarContacto(id, numero, email, newPessoa);
                    break;
                case 3:
                    System.out.println("Id para apagar? ");
                    id = sc.nextInt();
                    sc.nextLine(); 
                    contacto.apagarContacto(id);
                    break;
                case 4:
                    String opcao;
                    System.out.println("Procurar por nome (No) ou por número (Nu)");
                    opcao = sc.nextLine();
                    opcao.toUpperCase();
                    contacto.procurarContacto(opcao);
                    break;
                case 5:
                    contacto.listarContactos();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (escolha != 0);
        
        sc.close();
    }
}
