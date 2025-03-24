package aula05;
import java.util.ArrayList;
import java.util.Scanner;
public class Datas {
    public static void main(String[] args) {
        int opcao;
        Scanner sc = new Scanner(System.in);
        DateYMD date = null;
        ArrayList<DateYMD> eventList = new ArrayList<>();
        while (true) {
        System.out.println("Date operations: \n1 - create new date\n2 - show current date\n3 - increment date\n4 - decrement date\n5 - print calendar month\n6 - add event\n7 - remove event\n8 - print calendar\n0 - exit");
        opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Day?");
                    int day = sc.nextInt();
                    System.out.println("Month? ");
                    int month = sc.nextInt();
                    System.out.println("Year? ");
                    int year = sc.nextInt();
                    date = new DateYMD(day,month,year);
                    break;
                case 2:
                    System.out.println(date == null ? "No Date found" : "Current Date: "+date);
                    break;
                case 3:
                    if (date!=null) {
                        date.incrementDate(date);
                    } else {
                        System.out.println("No Date to increment");
                    } break;
                case 4:
                    if (date!=null) {
                        date.decrementDate(date);
                    } else {
                        System.out.println("No Date to decrement");
                    } break;
                case 5:
                    System.out.println("Year? ");
                    int yprint = sc.nextInt();
                    System.out.println("Month? ");
                    int mprint = sc.nextInt();
                    date.printMonth(mprint, yprint, eventList);
                    break;
                case 6:
                    System.out.println("Day? ");
                    int eventDay = sc.nextInt();
                    System.out.println("Month? ");
                    int eventMonth = sc.nextInt();
                    System.out.println("Year? ");
                    int eventYear = sc.nextInt();
                    eventList = date.addEvent(new DateYMD(eventDay, eventMonth, eventYear), eventList);
                    break;
                case 7:
                    if (!eventList.isEmpty()) {
                        System.out.println("Enter the event date to remove:");
                        System.out.println("Day?");
                        int removeDay = sc.nextInt();
                        System.out.println("Month?");
                        int removeMonth = sc.nextInt();
                        System.out.println("Year?");
                        int removeYear = sc.nextInt();

                        boolean removed = false;
                        for (int i = 0; i < eventList.size(); i++) {
                            DateYMD event = eventList.get(i);
                            if (event.day == removeDay && event.month == removeMonth && event.year == removeYear) {
                                eventList.remove(i);
                                removed = true;
                                System.out.println("Event on " + removeDay + "/" + removeMonth + "/" + removeYear + " removed successfully!");
                                break;
                            }
                        }
                        if (!removed) {
                            System.out.println("No event found on this date.");
                        }
                    } else {
                        System.out.println("No events available to remove.");
                    }
                    break;
                case 8:
                    System.out.println("Year? ");
                    int calendaryear = sc.nextInt();
                    date.printCalendar(calendaryear, eventList);
                    break;
                case 0:
                    sc.close();
                    return;
                default:
                    break;
            }
        }
    }
}
