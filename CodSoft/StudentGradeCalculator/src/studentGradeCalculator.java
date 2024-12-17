import java.util.Scanner;

public class studentGradeCalculator {
    public static double gradeSum=0;
    public static double averagePercentage=0;
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        double mark;
        int numOfSubjects=0;

    
        while((mark=getMark(input)) != -1){
            if(mark>=0 && mark<=100){
                numOfSubjects++;
                computeGradeSum(mark);
            }
            else{
                System.out.println("Your mark should be between 0 and 100.");
            
            }
        }
        if(numOfSubjects>0){

        
        averagePercentage = gradeSum/numOfSubjects;
        System.out.println(String.format("Total marks: %.0f", gradeSum));
        System.out.println(String.format("Average percentage: %.0f%%", averagePercentage));
        System.out.println(String.format("Grade : %s",assignGrade(averagePercentage)));
        }
        else{
            System.out.println("No marks were typed in.");
        }
            

        input.close();
    }
    public static double getMark(Scanner input){
        while(!input.hasNextInt()){
            System.out.println("the input should be a number,try again.");
            input.next();
        }
    
        return input.nextInt();
    }
    public static void computeGradeSum(double mark){
        gradeSum+=mark;
    }
    public static String assignGrade(double mean){
        String Grade ="";
        if(mean>=75){
            Grade = "A";
        }
        else if(mean>=70 && mean<75){
            Grade = "B";
        }
        else if(mean>=60 && mean<70){
            Grade = "C";
        }
        else if(mean>=50 && mean<60){
            Grade = "D";

        }
        else{
            Grade = "F";
        }
        


        return Grade;

    }
}
