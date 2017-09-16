import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;
import java.math.RoundingMode;

public class Application {
    public static void main(String[] args) {
        Student[] groupA = new Student[5];
        CreateStudents(groupA);
        int[] results = PassExam(groupA);
        PrintAverageResult(results);
    }
/* Create list of student using 'Student' ctor */
    private static void CreateStudents(Student[] groupA) {
        groupA[0] = new Student("Ivan","Ivanov");
        groupA[1] = new Student("Boris","Borisov");
        groupA[2] = new Student("Kolya","Kolynov");
        groupA[3] = new Student("Petr","Petrov");
        groupA[4] = new Student("Semen","Semenov");
    }
/* Create array 'results' and define random value */
    public static int[] PassExam(Student[] groupA)
    {
        int[] results = new int[groupA.length];
        for(int i=0;i<groupA.length;i++)
        {
            Random randomInt = new Random();
            results[i]=randomInt.nextInt(5)+1;
            //It's not by task, but I prefer to print results before print average
            System.out.println(results[i]);
        }
        return results;
    }
/* Calculate sum of results and print average value */
    public static void PrintAverageResult(int[] results)
    {
        double sum=0;
        for (int x:results)
        {
         sum+=x;
        }
        // Nothing said about type of average
        int average =(int)Math.round(sum/results.length);
        System.out.println("Average result of group: "+average);
    }
}
