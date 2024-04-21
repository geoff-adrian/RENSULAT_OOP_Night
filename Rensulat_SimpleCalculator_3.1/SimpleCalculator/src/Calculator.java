import java.lang.Math;

public class Calculator {
    double firstNum, secondNum, result, facResult, finalFac = 1;

    public Calculator(double firstNum, double secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }
    
    double addition (double firstNum, double secondNum){
        result = firstNum + secondNum;
        return result;
    }
    
    double subtraction (double firstNum, double secondNum){
        result = firstNum - secondNum;
        return result;
    }
    
    double multiplication (double firstNum, double secondNum){
        result = firstNum * secondNum;
        return result;
    }
    
    double division (double firstNum, double secondNum){
        result = firstNum/secondNum;
        return result;
    }
    
    double squareAlgo (double firstNum){
        result = firstNum * firstNum;
        return result;
    }
    
    double modulo (double firstNum, double secondNum){
        result = firstNum % secondNum;
        return result;
    }
    
    double radical (double firstNum){
         result = Math.sqrt(firstNum);
         return result;
     }
    
     double nega (double firstNum){
         result = firstNum-(firstNum*2);
         return result;
     }
     
     double reciprocal (double firstNum){
         result = 1 / firstNum;
         return result;
     }
     
     double factorial (double firstNum){
         if (firstNum == 0){
             return 1;
         }
         else {
             facResult = firstNum * factorial(firstNum-1);
         }
         return facResult;
    }
}
