package aula05;

import java.util.ArrayList;

public class DateYMD {
    int day;
    int month;
    int year;

    public DateYMD(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    public boolean validMonth(int month) {
        return month >= 1 && month <= 12;
    }

    public String monthToString(int month) {
        switch (month) {
            case 1:  return "Janeiro";
            case 2:  return "Fevereiro";
            case 3:  return "Março";
            case 4:  return "Abril";
            case 5:  return "Maio";
            case 6:  return "Junho";
            case 7:  return "Julho";
            case 8:  return "Agosto";
            case 9:  return "Setembro";
            case 10: return "Outubro";
            case 11: return "Novembro";
            case 12: return "Dezembro";
            default: return "MÊS INVÁLIDO";
        }
    }

    public boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int monthDays(int month, int year) {
        if (!validMonth(month)) {
            throw new IllegalArgumentException("Mês inválido: " + month);
        }
        switch (month) {
            case 4: case 6: case 9: case 11: return 30;
            case 2: return leapYear(year) ? 29 : 28;
            default: return 31;
        }
    }

    public boolean valid(int day, int month, int year) {
        return day >= 1 && day <= monthDays(month, year);
    }

    public void incrementDate(DateYMD date) {
        day++;
        if (day > monthDays(month, year)) {
            day = 1;
            month++;
        }
        if (month > 12) {
            month = 1;
            year++;
        }
    }

    public void decrementDate(DateYMD date) {
        day--;
        if (day < 1) {
            month--;
            if (month < 1) {
                month = 12;
                year--;
            }
            day = monthDays(month, year);
        }
    }

    public int calculateFirstWeekDayOfYear(int year) {
        int d = 1, m = 1, y = year;
        if (m < 3) {
            m += 12;
            y--;
        }
        int K = y % 100;
        int J = y / 100;
        int firstWeekday = (d + (13 * (m + 1)) / 5 + K + (K / 4) + (J / 4) + (5 * J)) % 7;
        
        // Ajuste para que Domingo seja 0, Segunda seja 1, etc.
        return (firstWeekday + 5) % 7;
    }

    public int firstWeekdayOfMonth(int month, int year) {
        int firstWeekDayOfYear = calculateFirstWeekDayOfYear(year);
        int count = firstWeekDayOfYear;
        for (int m = 1; m < month; m++) {
            count += monthDays(m, year);
        }
        return count % 7;
    }

    public ArrayList<DateYMD> addEvent(DateYMD date, ArrayList<DateYMD> lista) {
        lista.add(date);
        return lista;
    }

    public ArrayList<DateYMD> removeEvent(DateYMD date, ArrayList<DateYMD> lista) {
        if (lista.isEmpty()) {
            System.out.println("Sem eventos disponíveis");
        } else {
            lista.remove(date);
            System.out.println("Dia " + date + " removido com sucesso!");
        }
        return lista;
    }

    public void printMonth(int month, int year, ArrayList<DateYMD> eventList) {
        int firstWeekday = firstWeekdayOfMonth(month, year);
        int totalDays = monthDays(month, year);

        System.out.println("\n" + monthToString(month) + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        for (int i = 0; i < firstWeekday; i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= totalDays; day++) {
            boolean isEvent = false;

            for (DateYMD event : eventList) {
                if (event.day == day && event.month == month && event.year == year) {
                    isEvent = true;
                    break;
                }
            }

            if (isEvent) {
                System.out.printf("*%2d ", day);
            } else {
                System.out.printf("%2d ", day);
            }

            if ((firstWeekday + day) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void printCalendar(int year, ArrayList<DateYMD> eventList) {
        for (int m = 1; m <= 12; m++) {
            printMonth(m, year, eventList);
        }
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
