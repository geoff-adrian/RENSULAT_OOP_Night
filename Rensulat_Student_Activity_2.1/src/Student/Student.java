package Student;

public class Student {
       private String firstName; //INSTANCE VARIABLES or PROPERTIES
       private String lastName;
       private int age;
       private boolean isMinor;
       
       public Student (String firstName, String lastName, int age){  // CONSTRUCTOR
           this.firstName = firstName;
           this.lastName = lastName;
           this.age = age;
           this.isMinor = age < 18;
       }
       
       public String getName(){ //GETTER ni siya
           return lastName + ", " + firstName;
       }
       
       public void increaseAge(){ //SETTER ni siya
           age++;   
           isMinor = age < 18;
       }
       
       public String toString(){ //GETTER ni siya
           String ageLevel;
           if (isMinor){
               ageLevel = "minor";
           }
           else {
               ageLevel = "adult";
           }
           return getName() + " - " + age + " - " + ageLevel;
       }
}

