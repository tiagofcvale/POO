package aula06;
import aula05.DateYMD;

public class Aluno extends Pessoa {
    private static int idCounter = 100;
    private int nMec;
    private DateYMD iDataInsc;
    public Aluno(String nome, int cc, DateYMD dataNasc, DateYMD iDataInsc) {
        super(nome, cc, dataNasc);
        this.nMec = ++idCounter;
        this.iDataInsc = iDataInsc;
    }
    public int getNMec() {
        return nMec;
    }
    public DateYMD getIDataInsc() {
        return iDataInsc;
    }
    @Override
    public String toString() {
        return "Classe Aluno: {Nome: "+getNome()+"; CC: "+getCc()+"; Data de Nascimento: "+getDataNasc()+"; Número Mecanográfico: "+getNMec()+"}";
    }
}
