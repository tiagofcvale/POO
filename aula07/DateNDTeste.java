package aula07;

import aula05.DateYMD;

public class DateNDTeste {
    public static void main(String[] args) {
        // Criando uma data de referência
        DateYMD date1 = new DateYMD(1, 1, 2000);
        DateYMD date2 = new DateYMD(15, 3, 2025);  // Outra data para teste

        // Criando a instância de DateND
        DateND dateND = new DateND();

        // Contando os dias desde 01/01/2000 até 15/03/2025
        int daysBetween = dateND.countDays(date2);

        // Exibindo o resultado
        System.out.println("Número de dias desde " + date1 + " até " + date2 + ": " + daysBetween);
    }
}
