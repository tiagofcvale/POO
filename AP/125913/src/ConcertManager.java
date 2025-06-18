import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Nome: Tiago Francisco Crespo do Vale
// NMec: 125913

public class ConcertManager {
    public List<Concert> concertos;

    public ConcertManager() {
        concertos = new ArrayList<>();
    }

    public void addConcert(Concert c) {
        for (Concert concert : concertos) {
            if (concert.equals(c)){
                System.out.println("Concerto já consta no manager");
                return;
            }
        }
        concertos.add(c);
        System.out.println("Concerto adicionado com sucesso!");
    }

    public void removeConcert(int id) {
        for (Concert concert : concertos) {
            if (concert.getID() == id) {
                concertos.remove(concert);
                System.out.println("Concerto removido com sucesso");
            }
        }
        System.out.println("Concerto de id = "+id+" não consta no manager");
    }

    public Concert getConcert(int id) {
        for (Concert concert : concertos) {
            if (concert.getID() == id) {
                return(concert);
            }
        }
        return null;
    }

    public double calculateConcertProfit(int id) {
        StandardConcertProfitCalculator sProfitCalculator = new StandardConcertProfitCalculator();
        double profit;
        for (Concert concert : concertos) {
            if (concert.getID() == id) {
                profit = sProfitCalculator.calculateConcertProfit(concert);
                return profit;
            }
        }
        return -1;
    }

    public void printAllConcerts() {
        concertos.forEach(System.out::println);
    }

    public void sortConcertsByCost() {
        
    }

    public void readFile(String fich) {
        try{
            Scanner input = new Scanner(new File(fich),Charset.forName("UTF-8"));
            input.nextLine();
            while (input.hasNextLine()) {
                String linha = input.nextLine();
                String[] partes = linha.trim().split("; ");
                int id = Integer.parseInt(partes[0]);
                double duracao = Double.parseDouble(partes[1]);
                String local = partes[2];
                String date = partes[3];

                Concert c = new Concert(id, local, date, duracao);

                boolean found = false;
                for (int i = 0; i < concertos.size(); i++) {
                    if (concertos.get(i).getID() == id) {
                        concertos.set(i, c);
                        found = true;
                        Concert.idCounter--;
                        break;
                    }
                }
                if (!found) { 
                    concertos.add(c);
                }
            }
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Nenhum ficheiro: \""+fich+"\" encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String fich) {
        try {
            //Formatar para tirar o "T"
            DateTimeFormatter formate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            PrintWriter pW = new PrintWriter(new File(fich),Charset.forName("UTF-8"));
            pW.println("ID; Duração; Local do concerto; Data e hora do início; Lucro do Concerto");
            for (Concert concert : concertos) {
                String formattedDate = concert.getDate().format(formate);
                pW.println(concert.getID()+"; "+concert.getDuracao()+"; "+concert.getLocal()+"; "+formattedDate+"; "+calculateConcertProfit(concert.getID()));
            }
            pW.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
