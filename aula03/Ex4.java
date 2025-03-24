package aula03;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex4 {
    public static void main(String[] args) {
        double P, T;
        String name;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Name? ");
        name = sc.nextLine();
        System.out.print("Practical? ");
        P = sc.nextDouble();
        System.out.print("Theoretical? ");
        T = sc.nextDouble();

        ArrayList<StudentGrade> notas = new ArrayList<>();

        notas.add(new StudentGrade(name, P, T));

        Path fich = Paths.get("notas.txt");
		try {
			List<String> lines = Files.readAllLines(fich);

            for (String line : lines) {
                String[] parts = line.split("\\t| {2,}"); 


                if (parts.length != 3) { 
                    System.out.println("Invalid line format: " + line);
                    continue;
                }


                String gname = parts[0];
                double gradeT = Double.parseDouble(parts[1]);
                double gradeP = Double.parseDouble(parts[2]);

                notas.add(new StudentGrade(gname, gradeP, gradeT));
            }
        } catch (IOException e) {
            System.out.println("Error reading the file. Make sure \"notas.txt\" exists in the project directory.");
        }

        System.out.println("gradeP   gradeT   finalGrade");
        for (StudentGrade g : notas) {
            System.out.printf("%-15s %.1f     %.1f     %.0f%n", g.name, g.notaP, g.notaT, g.getFinalGrade());
            if (g.getFinalGrade()>=10) {
                System.out.println("Passed");
            } else {
                System.out.println("Not Passed");
            }
        }

        sc.close();
    }

    static class StudentGrade {
        double notaP;
        double notaT;
        String name;
    
        public StudentGrade(String name, double gradeP, double gradeT) {
            this.name = name;
            this.notaP = gradeP;
            this.notaT = gradeT;
        }
        public double getFinalGrade() {
            return (notaP * 0.4) + (notaT * 0.6);
        }
    }
}
