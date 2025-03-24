package aula03;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TabSeparatedFileReader {

    // Define a Record to represent a person's data
    public record Person(String name, double noteP, double noteT) {}

    public static void main(String[] args) {
        String filePath = "notas.txt"; // Path to your tab-separated file
        List<Person> persons = new ArrayList<>();
        double sumNoteP = 0;
        double sumNoteT = 0;

        // Read the file and populate the list of persons
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    String name = parts[0];
                    double noteP = Double.parseDouble(parts[1]);
                    double noteT = Double.parseDouble(parts[2]);

                    persons.add(new Person(name, noteP, noteT));
                    sumNoteP += noteP;
                    sumNoteT += noteT;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!persons.isEmpty()) {
            // Calculate averages
            double averageNoteP = sumNoteP / persons.size();
            double averageNoteT = sumNoteT / persons.size();

            System.out.println("Average noteP: " + averageNoteP);
            System.out.println("Average noteT: " + averageNoteT);

            double averageGrade = averageNoteP *0.6 +averageNoteT *0.4;

            // Find names with noteT above the overall average
            System.out.println("Names with noteT above average:");
            for (Person person : persons) {
                double personP, personT, personGrade;
                String personN;
                personP = person.noteP;
                personT = person.noteT;
                personN = person.name;
                personGrade = personP *0.6 + personT*0.4;
                if (personGrade>=averageGrade) {
                    System.out.println(personN);
                }
            }
        } else {
            System.out.println("No data found in the file.");
        }
    }
}