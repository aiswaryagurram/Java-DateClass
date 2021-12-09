import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hw2 {
    public static void main(String[] args) {
        Dte dte1 = new Dte(3, 5, 2011);
        System.out.println("static add: " + dte1 + " + 100 = " + Dte.addDays(dte1, 100));

        Dte dte2 = new Dte(3, 5, 2014);
        System.out.println("static sub: " + dte2 + " -  30 = " + Dte.subDays(dte2, 30));

        Dte dte3 = new Dte(dte1);
        dte3.addDays(100);
        System.out.println("\nmember add: " + dte1 + " + 100 = " + dte3);

        Dte dte4 = new Dte(dte1);
        dte4.subDays(100);
        System.out.println("member sub: " + dte1 + " - 100 = " + dte4);

        System.out.println("\n--------------------");

        String fileName;
        if (args.length == 0) {
            fileName = "hw2-input.txt";
        } else {
            fileName = args[0].trim();
        }

        System.out.println("\nInput file is: " + fileName + "\n");
        int count = 0;

        try {
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            while (scanner.hasNext()) {
                count++;
                String s = scanner.nextLine().trim();
                String[] input = s.split("[\\s]+");
                if (s.isEmpty()) {
                    System.out.printf("%10s%9s%s\n", "", "", "line is empty");
                } else if (!input[0].contains("/")) {
                    System.out.printf("%10s%9s%s\n", input[0], "", "date has no slashes");
                } else {

                    String[] date = input[0].split("/");
                    int month, day, year;
                    if ( date[0].matches("\\d+"))
                    {
                        month = Integer.parseInt(date[0]);
                    }
                    else{
                        System.out.printf("%10s%9s%s\n", input[0], "", "month is not numeric");
                        continue;
                    }
                    if( date[1].matches("\\d+")){
                        day = Integer.parseInt(date[1]);
                    }
                    else
                    {
                        System.out.printf("%10s%9s%s\n", input[0], "", "day is not numeric");
                        continue;
                    }
                    if( date[2].matches("\\d+")){
                        year = Integer.parseInt(date[2]);
                    }
                    else
                    {
                        System.out.printf("%10s%9s%s\n", input[0], "", "year is not numeric");
                        continue;
                    }

                    if (input.length == 1) {
                        System.out.printf("%10s%9s%s\n", input[0], "", "no increment");
                        continue;
                    }
                    int increment;
                    if( input[1].matches("\\d+")){
                        increment = Integer.parseInt(input[1]);
                    }
                    else
                    {
                        System.out.printf("%10s%6s   %s\n", input[0], input[1], "increment is not numeric");
                        continue;
                    }

                    if (month == 0 || day == 0 || year == 0) {
                        System.out.printf("%10s%9s%s\n", input[0], "", "day is out of range");
                        continue;
                    }
                    Dte dte = new Dte(month, day, year);
                    System.out.printf("%10s%6s%13s%13s\n", input[0], input[1], Dte.addDays(dte, increment), Dte.subDays(dte, increment));
                }
            }

            System.out.println("\nNo. of records = " + count);

            System.out.println("\n------------------------------------------------------------");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
