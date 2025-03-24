package aula03;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;


public class Ex6 {
    public static String getDayStringOld(Date date, Locale locale) {
    DateFormat formatter = new SimpleDateFormat("EEEE", locale);
    return formatter.format(date);
}
    public static void main(String[] args) {
        Date currentDate = new Date();
        System.out.println(currentDate);
        System.out.println("Today's date: " + getDayStringOld(currentDate, Locale.ENGLISH));
        Scanner sc = new Scanner(System.in);
        int ano;
        String mes;
        System.out.println("\nMês? ");
        mes = sc.nextLine();
        System.out.println("Ano? ");
        ano = sc.nextInt();

        Map<String, Integer> monthMap = new HashMap<>();
        monthMap.put("janeiro", Calendar.JANUARY);
        monthMap.put("fevereiro", Calendar.FEBRUARY);
        monthMap.put("março", Calendar.MARCH);
        monthMap.put("abril", Calendar.APRIL);
        monthMap.put("maio", Calendar.MAY);
        monthMap.put("junho", Calendar.JUNE);
        monthMap.put("julho", Calendar.JULY);
        monthMap.put("agosto", Calendar.AUGUST);
        monthMap.put("setembro", Calendar.SEPTEMBER);
        monthMap.put("outubro", Calendar.OCTOBER);
        monthMap.put("novembro", Calendar.NOVEMBER);
        monthMap.put("dezembro", Calendar.DECEMBER);

        int monthConstant = monthMap.getOrDefault(mes.toLowerCase(), Calendar.JANUARY);

        Calendar one = new GregorianCalendar(ano, monthConstant,1);
        System.out.println("First day of month: " +one.get(Calendar.DAY_OF_WEEK));


        Calendar calendar = new GregorianCalendar(ano, monthConstant, 1);

        System.out.println(new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH).format(calendar.getTime()));

        System.out.println("Su Mo Tu We Th Fr Sa");

        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("   ");
        }

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);

            if ((day + firstDayOfWeek - 1) % 7 == 0) {
                System.out.println();
            }
        }

        if ((daysInMonth + firstDayOfWeek - 1) % 7 != 0) {
            System.out.println();
        }
        sc.close();
    }
}
