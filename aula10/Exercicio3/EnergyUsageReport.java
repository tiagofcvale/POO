package aula10.Exercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class EnergyUsageReport {

    private List<Customer> customers = new ArrayList<>();

    public EnergyUsageReport() {
        // Constructor implementation
    }

    public void load(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0].trim());
                List<Double> meterReadings = new ArrayList<>();

                for (int i = 1; i < parts.length; i++) {
                    meterReadings.add(Double.parseDouble(parts[i].trim()));
                }

                Customer customer = new Customer(id, meterReadings);
                customers.add(customer);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ficheiro não encontrado: " + filePath);
        } catch (NumberFormatException e) {
            System.err.println("Formato de número inválido no ficheiro: " + filePath);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Formato de linha inválido no ficheiro: " + filePath);
        }
    }

    public void addCustomer(Customer c) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == c.getCustomerId()) {
                return;
        } else {
            customers.add(c);
            System.out.println("Customer "+c.getCustomerId()+" added successfuly");
            return;
            }
        }
    }

    public Customer getCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == id) {
                return customer;
            }
        }
        return null;
    }

    public double calculateTotalUsage(int id) {
        double total = 0;
        for (Customer customer : customers) {
            if (customer.getCustomerId() == id) {
                List <Double> list = customer.getMeterReadings();
                for (Double double1 : list) {
                    total+=double1;
                }
            }
        }
        return total;
    }

    public void generateReport(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Customer customer : customers) {
                int id = customer.getCustomerId();
                double totalUsage = calculateTotalUsage(id);
                writer.write("ID: " + id + " | Total Usage: " + totalUsage + " kWh\n");
            }
            System.out.println("Relatório gerado com sucesso em: " + filePath);
        } catch (IOException e) {
            System.err.println("Erro ao gerar o relatório: " + e.getMessage());
        }
    }

    public void removeCustomer(int id){
        for (Customer customer : customers) {
            if (customer.getCustomerId() == id){
                customers.remove(customer);
                System.out.println("Customer "+ id +" removed Successfuly");
                return;
            }
        }
    }
}
