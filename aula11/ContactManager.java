package aula11;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Scanner;

import aula11.IContactCostCalculator.ContactType;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }


    public void addContact(Contact c) {
        for (Contact contact : contacts) {
            if (contact.getId() == c.getId()) {
                System.out.println("Contacto com id " + c.getId() + " já existe.");
                return;
            }
        }
        contacts.add(c);
        System.out.println("Contacto " + c.getName() + " adicionado.");
    }

    public void removeContact(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contacts.remove(contact);
                System.out.println("Contacto " + contact.getName() + " removido.");
                return;
            }
        }
        System.out.println("Contacto com id " + id + " não encontrado.");
    }

    public Contact getContact(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        System.out.println("Contacto com id " + id + " não encontrado.");
        return null;
    }

    public double calculateContactCost(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                StandardCostCalculator calculator = new StandardCostCalculator();
                ContactType type = contact.getTeleN() != 0 ? ContactType.CELLNUMBER : ContactType.EMAIL;
                return calculator.calculateCost(contact.getUnits(), type);
            }
        }
        System.out.println("Contacto com id " + id + " não encontrado.");
        return -1;
    }

    public void printAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void readFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.trim().split("\t");
                String name = parts[0].trim();
                String teleN = (parts[1].trim());
                String email = parts[2].trim();
                LocalDate birthDate = LocalDate.parse(parts[3].trim());
                Contact c = new Contact(name, Integer.parseInt(teleN), email, birthDate);
                addContact(c);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in file: " + filePath);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid file format: " + filePath);
        }
    }

    public void writeFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Contact contact : contacts) {
                writer.write(contact.getName() + "; " + contact.getTeleN() + "; " + contact.getEmail() + "; " + contact.getBirthDate() + ";\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filePath);
        }
    }

}
