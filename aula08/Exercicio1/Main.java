package aula08.Exercicio1;

public class Main {
    String nome = "Aluguel de Viaturas";
    String codigoPostal = "1234-567";
    String email = "aluguel@gmail.com";
    public static void main(String[] args) {
        String nome = "Aluguel de Viaturas";
        String codigoPostal = "1234-567";
        String email = "aluguel@gmail.com";
        Empresa_AluguelViaturas empresa = new Empresa_AluguelViaturas(nome, codigoPostal, email);
        Automovel_Ligeiro carro1 = new Automovel_Ligeiro("AA-00-BB", "Toyota", "Corolla", 150, 4, 1.8);
        empresa.adicionarViatura(carro1);
        Motociclo moto1 = new Motociclo("CC-11-DD", "Yamaha", "MT-07", 150, Motociclo.TipoMotociclo.DESPORTIVO);
        empresa.adicionarViatura(moto1);
        Taxi taxi1 = new Taxi("EE-22-FF", "Mercedes", "E-Class", 200, 4, 2.0, 12345);
        empresa.adicionarViatura(taxi1);
        Pesado_Passageiros pesado1 = new Pesado_Passageiros("GG-33-HH", "Volvo", "FH16", 500, 6, 18.0, 50);
        empresa.adicionarViatura(pesado1);
        Pesado_Mercadorias pesado2 = new Pesado_Mercadorias("II-44-JJ", "Scania", "R 450", 500, 6, 18.0, 50);
        empresa.adicionarViatura(pesado2);

        empresa.listarViaturas();

        carro1.trajeto(100);
        moto1.trajeto(50);
        taxi1.trajeto(30);
        pesado1.trajeto(200);
        pesado2.trajeto(150);

        IKmPercorridos vmaiorDistancia = null;
        double dmaior = 0;
        for (IKmPercorridos viatura : empresa.getViaturas()) {
            if (viatura.distanciaTotal() > dmaior) {
                dmaior = viatura.distanciaTotal();
                vmaiorDistancia = viatura;
            }
        }
        System.out.println("Viatura com maior distância percorrida: ");
        System.out.println(vmaiorDistancia);

        IKmPercorridos vmenorDistancia = null;
        double dmenor = 0;
        for (IKmPercorridos viatura : empresa.getViaturas()) {
            if (viatura.distanciaTotal() < dmenor || dmenor == 0) {
                dmenor = viatura.distanciaTotal();
                vmenorDistancia = viatura;
            }
        }
        System.out.println("Viatura com menor distância percorrida: ");
        System.out.println(vmenorDistancia);

        Atleta atleta1 = new Atleta();
        empresa.alugarViatura(carro1, 2700, atleta1);
    }
}
