import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class MyCalculator implements PrimitiveCalculator {

    public MyCalculator(double a, String o, double b) {
        if (o.equals("+")) {
            System.out.println("result = " + add(a,b));
            return;
        }
        if (o.equals("-")) {
            System.out.println("result = " + sub(a,b));
            return;
        }
        if (o.equals("*")) {
            System.out.println("result = " + mul(a,b));
            return;
        }
        if (o.equals("/")) {
            System.out.println("result = " + div(a,b));
            return;
        }
    }
// overwrite interface method
    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        return a / b;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter parameters like this: 1+1 and press ENTER. Write \"quit\" for exit");
        String enterText = in.nextLine();
        enterText.toLowerCase();
        if (!(enterText.equals("quit")))
        {
            CalculateDeliver(enterText); //call parser to execute values
        }
    }

    /* Delivering string to parser and calculating parsed values */
    private static void CalculateDeliver(String enterText) {
        String[] parseText = Parser(enterText);
        if (parseText != null) {
            try {
                double first = Double.parseDouble(parseText[0]);
                double second = Double.parseDouble(parseText[2]);
            } catch (Exception ex) {
                System.out.println("Please, enter the numbers. Use dot for separate double numbers.");
                main(null);
            }
            double first = Double.parseDouble(parseText[0]);
            double second = Double.parseDouble(parseText[2]);
            String operator = parseText[1];
            new MyCalculator(first, operator, second);
            main(null);
        } else {
            main(null);
        }
    }

    /* Parser. Cases: 1) more than 3 values 2) spaces 3) no operators */
    public static String[] Parser(String enterText)
    {
        String[] parsedArray = new String[3];
        String[] operator = enterText.split("[^+/*-]+");
        String[] values = enterText.split("[+*/-]");
        if(operator.length>2)
        {
            parsedArray=null;
            return parsedArray;
        }
        else if(operator.length==0)
        {
            System.out.println("Please, use operators like +,-,* and /");
            parsedArray=null;
            return parsedArray;
        }
        else
        {
            if(values.length>=3)
            {
                if(operator[0].equals("-"))
                {
                    parsedArray[0] = ((operator[0]+values[1])).replaceAll(" ", "");
                    parsedArray[2] = values[2].replaceAll(" ", "");
                }
                else
                {
                    parsedArray=null;
                    return parsedArray;
                }
            }
            else
            {
                parsedArray[0] = (values[0]).replaceAll(" ", "");
                parsedArray[2] = values[1].replaceAll(" ", "");
            }
            parsedArray[1] = operator[1];
            return parsedArray;
        }
    }
}