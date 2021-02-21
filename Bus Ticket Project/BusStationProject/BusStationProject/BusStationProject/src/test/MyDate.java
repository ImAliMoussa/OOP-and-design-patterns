package test;

import java.util.StringTokenizer;

/**
 * Created by FAST on 13-Mar-18.
 */
public class MyDate {
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean inputDate(String date)
    {
        StringTokenizer stringTokenizer = new StringTokenizer(date , "/");
        try {
            this.day = Integer.parseInt(stringTokenizer.nextToken());
            this.month = Integer.parseInt(stringTokenizer.nextToken());
            this.year = Integer.parseInt(stringTokenizer.nextToken());
            if( stringTokenizer.hasMoreElements()) return false;
        }
        catch (NumberFormatException e)
        {
            System.out.println("Enter only numbers in date");
            return false;
        }
        catch (Exception e)
        {
            System.out.println("Format error");
            return false;
        }
        return true;
    }
}






















