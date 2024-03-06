package StudentMain;

import Student.Student;
import java.util.Scanner;

public class StudentMainProg {  
    
    public static void main (String[] args){
        Scanner readTestCase = new Scanner(System.in);
        
        Student student1 = new Student("Jemar Jude", "Maranga", 17);
        Student student2 = new Student("Jose", "Cruz", 19);
            
        System.out.print("Enter test case number: ");
        int testCase = readTestCase.nextInt();
        
        switch (testCase){
            case 1:
                System.out.println("Test Case 1: Student under 18");
                System.out.println(student1);
                break;
            case 2:
                System.out.println("Test Case 2: Increase age of student1");
                student1.increaseAge();
                System.out.println(student1);
                break;
            case 3:
                System.out.println("Test Case 3: Student over 18");
                System.out.println(student2);
                break;
            default:
                System.out.println("Test Case not VALID");
                break;   
        }
        readTestCase.close();
    }
}
