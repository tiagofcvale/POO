package aula11;

import java.time.LocalDate;

public class Contact {
    public static int idCounter = 0;
    private int id;
    private String name;
    private int teleN;
    private String email;
    private LocalDate birthDate;


    private double units = 0;

    public Contact(String name, int teleN, String email, LocalDate birthDate) {
        this.id = ++idCounter;
        this.name = name;
        this.teleN = teleN;
        this.email = email;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTeleN() {
        return teleN;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeleN(int teleN) {
        this.teleN = teleN;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void call(double units) {
        this.units += units;
        System.out.println("Chamada de " + units + " unidades para o contacto " + name);
    }

    public void email() {
        System.out.println("Email enviado para " + name);
    }

    public double getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return "Contacto "+id+" de "+name+"; telefone: "+teleN+", email: "+email+", data de nascimento: "+birthDate;
    }
}
