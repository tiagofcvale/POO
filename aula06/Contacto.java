package aula06;
import java.util.ArrayList;
import java.util.Scanner;

public class Contacto {
    Scanner sc = new Scanner(System.in);
    private int num;
    private String email;
    private Pessoa pessoa;
    private int idCounter = 0;
    private int id;
    private static ArrayList<Contacto> contactos = new ArrayList<>();

    public Contacto(int num, String email, Pessoa pessoa) {
        this.num = num;
        this.email = email;
        this.pessoa = pessoa;
        this.id = idCounter++;
    }

    public int getNum() {
        return num;
    }
    public String getEmail() {
        return email;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public int getId() {
        return id;
    }
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public boolean isValidNum(int num) {
        String numStr = String.valueOf(Math.abs(num));
        if (numStr.length() == 9) {
            if (numStr.charAt(0) != 9) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false; 
        }

        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex != email.lastIndexOf('@')) {
            return false; 
        }
        return true;
    }
    public void inserirContacto(Contacto contacto) {
        boolean existe = false;
        String certeza;
        if (contactos.contains(contacto)) {
            existe = true;
        }
        if (isValidEmail(contacto.getEmail()) || isValidNum(contacto.getNum())) {
            if (existe) {
                System.out.println("Tem acerteza que quer adicionar um contacto já existente há lista? ");
                certeza = sc.nextLine();
                if (certeza.equals("sim") || certeza.equals("Sim")) {
                    contactos.add(contacto);
                    System.out.println("Contacto adicionado com sucesso!");
                } else {
                    System.out.println("Contacto não adicionado");
                }
            } else {
                contactos.add(contacto);
                System.out.println("Contacto adicionado com sucesso!");
            }
        } else {
            System.out.println("Erro! Número ou email Inválidos");
        }
    }
    public void alterarContacto(int id, int newNum, String newEmail, Pessoa newPessoa) {
        for (Contacto contacto : contactos) {
            if (contacto.getId() == id) {
                if (isValidEmail(newEmail) && isValidNum(newNum)) {
                    contacto.email = newEmail;
                    contacto.num = newNum;
                    contacto.pessoa = newPessoa;
                    System.out.println("Contacto alterado com sucesso");
                    return;
                } else {
                    System.out.println("Erro! Número ou email Inválidos");
                    return;
                }
            }
        }
        System.out.println("Erro! Contacto não encontrado");
        return;
    }
    public boolean isIdInContacts(int id) {
        for (Contacto contacto : contactos) {
            if (contacto.getId() == id) {
                return true;
            }
        } return false;
    }
    public void apagarContacto(int id) {
        for (Contacto contacto : contactos) {
            if (contacto.getId() == id) {
                contactos.remove(contacto);
                System.out.println("Contacto apagado com sucesso");
                return;
            } else {
                System.out.println("Erro! Contacto não encontrado");
                return;
            }
        }
    }
    public void procurarContacto(String opcao) {
        boolean encontrado = false;
        
        if (opcao.equalsIgnoreCase("NO")) {
            System.out.println("Nome? ");
            String no = sc.nextLine();
            
            for (Contacto contacto : contactos) {
                if (contacto.getPessoa().getNome().toLowerCase().contains(no.toLowerCase())) {
                    System.out.println(contacto);
                    encontrado = true;
                }
            }
            
        } else if (opcao.equalsIgnoreCase("NU")) {
            System.out.println("Número? ");
            String nu = sc.nextLine();
            
            for (Contacto contacto : contactos) {
                if (String.valueOf(contacto.getNum()).contains(nu)) {
                    System.out.println(contacto);
                    encontrado = true;
                }
            }
            
        } else {
            System.out.println("Erro! Opção inválida");
            return;
        }
        
        if (!encontrado) {
            System.out.println("Nenhum contato encontrado.");
        }
    }
    
    
    public void listarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }
    @Override
    public String toString() {
        return "Contacto Id "+id+": {Pessoa: "+pessoa+"; Número: "+num+"; Email: "+email+"}";
    }
}