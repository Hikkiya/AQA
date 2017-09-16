import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        Student[] groupA = new Student[5];
        groupA[0] = new Student("Ivan","Ivanov");
        groupA[1] = new Student("Boris","Borisov");
        groupA[2] = new Student("Kolya","Kolynov");
        groupA[3] = new Student("Petr","Petrov");
        groupA[4] = new Student("Semen","Semenov");
        int[] results = PassExam(groupA);
        PrintAverageResult(results);
    }
    public static int[] PassExam(Student[] groupA)
    {
        int[] results = new int[groupA.length];
        for(int i=0;i<groupA.length;i++)
        {
            Random randomInt = new Random();
            results[i]=randomInt.nextInt(5)+1;
            System.out.println(results[i]);
        }
        return results;
    }
    public static void PrintAverageResult(int[] results)
    {
        int sum=0;
        for (int x:results)
        {
         sum+=x;
        }
        double average =average=(sum/(results.length));
        System.out.println("Average result of group: "+average);
    }
}
