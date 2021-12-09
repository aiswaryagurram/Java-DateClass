/****************************************************************
 MonthInfo class

 Author:    Aiswarya Gurram
 Z-number:  z1887998

 Description: This class helps to find the number of days in an
              ordinary year and number of days in a leap year.
              Getters return the days for a particular month in
              a leap year or in a ordinary year.
 ****************************************************************/

public class MonthInfo {
    //declaration of variables
    private int numOfDays;
    private int numOfDaysInLeapYear;

    //constructor with days in a year and days in a leap year
    public MonthInfo(int numOfDays, int numOfDaysInLeapYear) {
        this.numOfDays = numOfDays;
        this.numOfDaysInLeapYear = numOfDaysInLeapYear;
    }

    //getter for number of days in a ordinary year
    public int getNumOfDays() {
        return numOfDays;
    }

    //setter for number of days in a ordinary year
    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    //getter for number of days in a leap year
    public int getNumOfDaysInLeapYear() {
        return numOfDaysInLeapYear;
    }

    //setter for number of days in a leap year
    public void setNumOfDaysInLeapYear(int numOfDaysInLeapYear) {
        this.numOfDaysInLeapYear = numOfDaysInLeapYear;
    }
}
