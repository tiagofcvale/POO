package aula04.exemplos;

import java.util.Scanner;

class Car {
    public String make;
    public String model;
    public int year;
    public int kms;

    public Car(String make, String model, int year, int kms) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kms = kms;
    }

    public void drive(int distance) {
        kms += distance;
    }

}

public class CarDemo {

    static Scanner sc = new Scanner(System.in);

    static int registerCars(Car[] cars) {

        // registo de carros termina quando o utilizador inserir uma linha vazia 
        // devolve número de carros registados
        int count = 0;

        while (count < cars.length) {
            System.out.print("Insira dados do carro (marca modelo ano quilómetros) ou pressione Enter para parar: ");
            String make = sc.nextLine();
            String model = sc.nextLine();
            int year = sc.nextInt();
            int kms = sc.nextInt();


            cars[count] = new Car(make, model, year, kms);
            count++;
        }

        return count; // Retorna o número de carros cadastrados
    }

    static void registerTrips(Car[] cars, int numCars) {
        // registo de viagens termina quando o utilizador inserir uma linha vazia
        while (true) {
            System.out.print("Registe uma viagem no formato \"carro:distância\" ou pressione Enter para sair: ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                break; // Sai do loop se o usuário não digitar nada
            }

            String[] data = input.split(":");
            if (data.length != 2) {
                System.out.println("Erro: Insira os dados corretamente (ex: 0:100)");
                continue;
            }

            int carIndex, distance;
            try {
                carIndex = Integer.parseInt(data[0]);
                distance = Integer.parseInt(data[1]);

                if (carIndex < 0 || carIndex >= numCars) {
                    System.out.println("Erro: Índice do carro inválido!");
                    continue;
                }

                cars[carIndex].drive(distance);
            } catch (NumberFormatException e) {
                System.out.println("Erro: O índice do carro e a distância devem ser números!");
            }
        }
    }


    static void listCars(Car[] cars) {
        System.out.println("\nCarros registados: ");
        // Exemplo de resultado
        // Carros registados:
        // Toyota Camry, 2010, kms: 234346
        // Renault Megane Sport Tourer, 2015, kms: 32536
        
        System.out.println("\n");
    }

    public static void main(String[] args) {

        Car[] cars = new Car[10];

        int numCars = registerCars(cars);

        if (numCars>0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }

        sc.close();

    }
}