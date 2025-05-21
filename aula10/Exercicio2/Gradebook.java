package aula10.Exercicio2;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;


public class Gradebook {

    List<Student> students = new ArrayList<>();

    public Gradebook() {
        // Constructor implementation
    }

    public void load(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                String name = parts[0].trim();
                List<Double> grades = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    grades.add(Double.parseDouble(parts[i].trim()));
                }
                Student student = new Student(name, grades);
                addStudent(student);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in file: " + filePath);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid file format: " + filePath);
        }
    }

    public void addStudent(Student student) {
        for (Student student1 : students) {
            if (student == student1) {
                System.out.println("Student already in Gradebook");
                return;
            }
        }
        students.add(student);
    }

    public void removeStudent(String studentName) {
        for (Student student : students) {
            if (studentName == student.getName()){
                students.remove(student);
                System.out.println("Student "+ studentName +" removed Successfuly");
            }
        }
    
    }

    public Student getStudent(String studentName) {
        for (Student student : students) {
            if (student.getName()==studentName){
                return student;
            }
        }
        return null;
    }

    public double calculateAverageGrade(String studentName) {
        
        double total = 0.0;

        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                List<Double> grades = student.getGrades();
                for (Double grade : grades) {
                    total += grade;
                }
                return total / grades.size();
            }
        }
        return 0.0;
    }

    public void printAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
