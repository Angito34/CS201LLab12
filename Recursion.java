import java.io.PrintWriter;
import java.util.ArrayList;

public class Recursion {
    //FactorialR and palindromeR autofilled in IDE
    public static long factorialR(long value){
        if (value <= 1){
            return 1;
        }
        return value * factorialR(value - 1);
    }
    
    public static boolean palindromeR(String str, int start, int end){
        if (start >= end){
            return true;
        }
        if (str.charAt(start) != str.charAt(end)){
            return false;
        }
        return palindromeR(str, start + 1, end - 1);
    }
    //copilot helped debug and develop rest of functions.
    //Prompt was fix my errors 
    //Got code from chatgpt when asked about how to recursively do these functions
    public static void reverseStringR(PrintWriter outputWriter, String str){
        if (str == null || str.length() == 0){
            return;
        }
            
            outputWriter.print(str.charAt(str.length() - 1));
            reverseStringR(outputWriter, str.substring(0, str.length() - 1));
    }

    public static boolean isPrimeR(int value, int n) {
        if (value < 2){
            return false;
        }
        if (n == 1){
            return true;
        }
        if (value % n == 0){
            return false;
        }
        return isPrimeR(value, n - 1);
    }
 
    public static int sumR(PrintWriter outputWriter, ArrayList<Integer> nums, int pos) {
        if (pos >= nums.size()){
            return 0;
        }
        int num = nums.get(pos);
        outputWriter.print(num + " ");
        return num + sumR(outputWriter, nums, pos + 1);

    }
 

}

   