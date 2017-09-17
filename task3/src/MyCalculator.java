import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class MyCalculator implements PrimitiveCalculator {

    public MyCalculator(double a, String o, double b) {
        if (o.equals("+")) {
            System.out.println(a + " + " + b + " = " + add(a,b));
            return;
        }
        if (o.equals("-")) {
            System.out.println(a + " + " + b + " = " + sub(a,b));
            return;
        }
        if (o.equals("*")) {
            System.out.println(a + " + " + b + " = " + mul(a,b));
            return;
        }
        if (o.equals("/")) {
            System.out.println(a + " + " + b + " = " + div(a,b));
            return;
        }
        System.out.println("Unknown operation");
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
        System.out.println("Please, enter parameters like this: 1 + 1, or write \"quit\" for exit");
        String enterText = in.nextLine();
        enterText.toLowerCase();
        //while (enterText!="quit")
            String[] parseText = Parser(enterText);
            if (parseText!=null)
            {
                double first = Double.parseDouble(parseText[0]);
                String operator = parseText[1];
                double second = Double.parseDouble(parseText[2]);
                new MyCalculator(first, operator, second);

            }
            else System.out.println("Enter parameters like this: 1 + 1");
    }
    public static String[] Parser(String enterText)
    {
        String[] parsedArray = new String[3];
        String[] operator = enterText.split("[^+/*-]+");
        String[] values = enterText.split("[+*/-]");
            parsedArray[0] = values[0];
            parsedArray[1] = operator[1];
            parsedArray[2] = values[1];
            return parsedArray;
    }
}