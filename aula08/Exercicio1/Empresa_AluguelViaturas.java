package aula08.Exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Empresa_AluguelViaturas {
    private String nome;
    private String codigoPostal;
    private String email;
    private List<IKmPercorridos> viaturas; // Lista de objetos que implementam IKmPercorridos

    public Empresa_AluguelViaturas(String nome, String codigoPostal, String email) {
        this.nome = nome;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.viaturas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public List<IKmPercorridos> getViaturas() {
        return viaturas;
    }

    public void adicionarViatura(IKmPercorridos viatura) {
        this.viaturas.add(viatura);
    }

    public void alugarViatura(IKmPercorridos viatura, int quilometros, Atleta atleta) {
        if (viaturas.contains(viatura)) {
            viatura.trajeto(quilometros); 
            System.out.println("Viatura alugada a "+atleta+" : " + viatura + " por " + quilometros + " km.");
        } else {
            System.out.println("A viatura especificada não pertence à empresa.");
        }
    }

    public void listarViaturas() {
        System.out.println("Viaturas da Empresa " + nome + ":");
        for (IKmPercorridos viatura : viaturas) {
            System.out.println(viatura);
        }
    }
}