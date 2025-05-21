package aula11;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;


public class ContactsTester {
    public static void main(String[] args) {
        ContactManager cm = new ContactManager();

        // --------------------------
        LocalDate b1 = LocalDate.of(1985, 1, 1);
        LocalDate b2 = LocalDate.of(1988, 1, 1);
        Contact c1 = new Contact("Maria Joaquina", 911234567, "joaquina@ua.pt", b1);      
        Contact c2 = new Contact("João Miguel", 911234568, "joao@ua.pt", b2);
        cm.addContact(c1);
        cm.addContact(c2);
        cm.printAllContacts();
        // --------------------------

        c1 = cm.getContact(1);
        System.out.println(c1);
        c2 = cm.getContact(2);
        System.out.println(c2);
        System.out.println(cm.getContact(5));           // -- não existe!
        System.out.println(cm.calculateContactCost(5)); // -- não existe!
        // --------------------------

        c1.call(3.5);
        c2.email();
        cm.printAllContacts();
        // --------------------------

        cm.readFile("contatos.txt");
        cm.printAllContacts();
        // --------------------------

        c1 = cm.getContact(1);
        System.out.println(c1);
        c2 = cm.getContact(2);
        System.out.println(c2);
        System.out.println(cm.getContact(5));
        System.out.println(cm.calculateContactCost(5));
        // --------------------------

        cm.writeFile("src\\aula11\\resources\\out.txt");
    }
}
