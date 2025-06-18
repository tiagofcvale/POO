import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Nome: Tiago Francisco Crespo do Vale
// NMec: 125913

public class Concert {
    private int id;
    public static int idCounter =1;
    private double duracao; //Minutos!
    private String local;
    private LocalDateTime date;

    public Concert(String local, String date, double duracao) {
        id = idCounter++;
        this.duracao = duracao;
        this.local = local;

        //String date para LocalDateTime datef
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime datef = LocalDateTime.parse(date,formatter);
        this.date = datef;
    }

    public Concert(int id,String local, String date, double duracao) {
        this.id = id;
        this.duracao = duracao;
        this.local = local;

        //String date para LocalDateTime datef
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime datef = LocalDateTime.parse(date,formatter);
        this.date = datef;

        idCounter++;
    }

    public double getDuracao() {
        return this.duracao;
    }

    public String getLocal() {
        return this.local;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public int getID() {
        return this.id;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String newDate = date.format(formate);
        return "Concerto = {ID: "+id+"; Duração: "+duracao+"; Local do Concerto: "+local+"; Data e hora do início: "+newDate+"}";
    }
}
