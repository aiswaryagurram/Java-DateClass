/****************************************************************
 Dte.java

 Author:    Aiswarya Gurram
 Z-number:  z1887998

 Description: This class is used to initialize the variables, setters
              getters and constructors. addDays and subDays methods
              are used to add to given date or subtract days from
              a given date. Leapyear() function is used to check a
              year is leap year or not. Initializes an array contains
              12 elements of MonthInfo class.
 ****************************************************************/

public class Dte {
    // variable initialized
    private int year;
    private int month;
    private int day;

    //monthData array that contains 12 MonthInfo elements
    private static MonthInfo[] monthData ={ new MonthInfo(31, 31),
                                             new MonthInfo(28, 29),
                                             new MonthInfo(31, 31),
                                             new MonthInfo(30, 30),
                                             new MonthInfo(31, 31),
                                             new MonthInfo(30, 30),
                                             new MonthInfo(31, 31),
                                             new MonthInfo(31, 31),
                                             new MonthInfo(30, 30),
                                             new MonthInfo(31, 31),
                                             new MonthInfo(30, 30),
                                             new MonthInfo(31, 31)};

    //default constructor
    public Dte(){
        this.month = 0;
        this.day = 0;
        this.year = 0;
    }

    //three-arg constructor that builds a Dte with value month/day/year
    public Dte(int month, int day, int year) {
       // this();
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Dte constructor that builds a new Dte with the same value as its input
    public Dte(Dte a) {
      //  this();
        this.year = a.year;
        this.month = a.month;
        this.day = a.day;
    }

    // getter to return the year
    public int getYear() {
        return year;
    }

    //getter to return the month
    public int getMonth() {
        return month;
    }

    //getter to return the day
    public int getDay() {
        return day;
    }

    //sets the this.year to the given year
    public void setYear(int year) {
        this.year = year;
    }

    //sets the this.month to the given month
    public void setMonth(int month) {
        this.month = month;
    }

    //sets the this.day to the given day
    public void setDay(int day) {
        this.day = day;
    }

    //toString() prints as month/day/year format
    @Override
    public String toString() {
        return String.format("%2d/%2d/%4d", month, day, year);
    }

    //checks whether the given year is leap year or not and returns a boolean value
    private boolean isLeapYear() {
        if ((year % 400 == 0)
                || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        } else {
            return false;
        }
    }


    //adds n days to the Dte it is called with.
    public void addDays(int daysToAdd) {
        for (int i = 0; i < daysToAdd; i++) {
            int numberOfDaysInMonth = isLeapYear() ? monthData[month - 1].getNumOfDaysInLeapYear() : monthData[month - 1].getNumOfDays();
            if (day < numberOfDaysInMonth) {
                day++;
            } else {
                month++;
                day = 1;
                if (month == 13) {
                    year++;
                    month = 1;
                }
            }
        }
    }

    //subtracts n days from the Dte it is called with
    public void subDays(int daysToSub) {
        for (int i = 0; i < daysToSub; i++) {
            if (day > 1) {
                day--;
            } else {
                month--;
                if (month == 0) {
                    year--;
                    month = 12;
                }
                day = isLeapYear() ? monthData[month - 1].getNumOfDaysInLeapYear() : monthData[month - 1].getNumOfDays();
            }
        }
    }

    //adds n days to the Dte in the first argument
    public static Dte addDays(Dte d, int daysToAdd) {
        Dte dte = new Dte(d);
        dte.addDays(daysToAdd);
        return dte;
    }

    //subtracts n days from the Dte in the first argument
    public static Dte subDays(Dte d, int daysToSub) {
        Dte dte = new Dte(d);
        dte.subDays(daysToSub);
        return dte;
    }
}
