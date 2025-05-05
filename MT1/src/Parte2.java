public class Parte2 {
    public static Pacote[] geraPacotes() {
        Pacote[] out = new Pacote[5];
        out[0] = new Pedido("1.1.1.1","2.2.2.2", "Comprar 5 morangos");
        out[1] = new Resposta("2.2.2.2","1.1.1.1", ((Pedido)out[0]).getSeq(), "Comprei 6 morangos");
        out[2] = new Pedido("1.1.1.1","2.2.2.2", "Remover 1 morango");
        out[3] = new Resposta("2.2.2.2","1.1.1.1", ((Pedido)out[2]).getSeq(), "Removi 1 morango");
        out[4] = new Resposta("2.2.2.2","1.1.1.1", ((Pedido)out[2]).getSeq(), "Removi 1 morango");
        return out;
    }

    public static void main(String[] args) {
        // --------------------------------------------------------
        // Run #1
        // --------------------------------------------------------
        Pacote[] pacotes = geraPacotes();
        Pacote p1 = pacotes[0];
        Pacote p2 = pacotes[1];
        Pacote p3 = pacotes[2];
        Pacote p4 = pacotes[3];
        Pacote p5 = pacotes[4];

        Firewall fw1 = new Firewall("Aveiro-FW");
        fw1.addPacote(p1);
        fw1.addPacote(p2);
        fw1.addPacote(p3);
        fw1.addPacote(p4);
        fw1.addPacote(p5);

        System.out.println(fw1);
        while(fw1.hasPacotes()) {
            fw1.processarPacote();
        }
        System.out.println(fw1);

        // --------------------------------------------------------
        // Run #2
        // --------------------------------------------------------
        pacotes = geraPacotes();
        p1 = pacotes[0];
        p2 = pacotes[1];
        p3 = pacotes[2];
        p4 = pacotes[3];
        p5 = pacotes[4];

        fw1.addPacote(p1);
        fw1.addPacote(p2);
        fw1.addPacote(p3);
        fw1.addPacote(p4);
        fw1.removePacote(p4);
        fw1.addPacote(p5);

        System.out.println(fw1);
        while(fw1.hasPacotes()) {
            fw1.processarPacote();
        }
        System.out.println(fw1);
    }
}
