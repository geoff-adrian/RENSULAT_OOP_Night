package com.mycompany.rensulat_oop_night_1_2;

import java.util.Scanner;

public class Rensulat_OOP_Night_1_2 {
    public static void main(String[] args) {
        
        Scanner readmessage = new Scanner(System.in);
        while (true){ //PARA MAGSIGEG PANGUTANA KUNOHAY DAGHAN NITEXT NI IVANA HAHAHAA *TYPE EXIT PARA MAEND ANG PROGRAM*
            System.out.print("Enter the message: ");
            String message = readmessage.nextLine();

            char[] messChar = message.toCharArray(); //i-convert ang string na message into array of char
            int sizeSaMessage = message.length(); //compute ang length

            boolean flag = false;
            
            for (int i=1; i<sizeSaMessage-1; i++){           
                if (Character.isUpperCase(messChar[i])){ // UPPER CASE CHECK
                    if (messChar[i-1] == ' '){ //icheck niya kung ang gauna sa kana na letter is space (ex. I A*m handsome)
                        flag = true;
                    }
                    else if (messChar[i+2] == ' '){ //icheck niya kung ang sunod sa kana na letter is space (ex. i aM handsome)
                        flag = false;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
                else if (Character.isLowerCase(messChar[i])){ //LOWER CASE CHECK
                    if (messChar[i-1] == ' '){
                        flag = true;
                    }
                } 
            }
            if (Character.isUpperCase(messChar[sizeSaMessage-1])){
               flag = false;
            }
            
            if (flag){
                System.out.println("uWu");
            }
            else {
                System.out.println("JEJE!");
            }
        }
    }
}