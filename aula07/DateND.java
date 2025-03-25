package aula07;
import aula05.DateYMD;

public class DateND extends Date {
    private int day, month, year;
    @Override
    public int getDay() {
        return day;
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public int getYear() {
        return year;
    }

    public int countDays(DateYMD date) {
        DateYMD base = new DateYMD(1, 1, 2000); 
        int count = 0;
        if (date.getYear()<2000) {
            return 0;
        } else {
            while (base.getDay() != date.getDay() || base.getMonth() != date.getMonth() || base.getYear() != date.getYear()) {
                base.incrementDate(base);
                count++;
            }
        } return count;
    }
    
}
