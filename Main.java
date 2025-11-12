import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
//comment name, lecture & lab section


class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String errorFile = "error.txt";

        System.out.println("Starting Recursion Program");
        //Try catch block autofilled by IDE
        //copilot helped develop rest of input handling and error checking
        try (BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
             PrintWriter outputWriter = new PrintWriter(new FileWriter(outputFile));
             PrintWriter errorWriter = new PrintWriter(new FileWriter(errorFile))) {

            String line;
            while ((line = inputReader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                String cmd = parts[0].trim();

                switch (cmd) {
                    case "factorialR": {
                        if (parts.length != 2) {
                            errorWriter.println("Invalid arguments for factorialR: " + line);
                            break;
                        }
                        String arg = parts[1].trim();
                        if (!isDigits(arg)) {
                            errorWriter.println("Invalid input for factorialR (not a non-negative integer): " + arg);
                            break;
                        }
                        long value = Long.parseLong(arg);
                        if (value < 0) {
                            errorWriter.println("Invalid input for factorialR (negative): " + arg);
                            break;
                        }
                        long fact = Recursion.factorialR(value);
                        outputWriter.println("Factorial of " + value + " is " + fact);
                        break;
                    }
                    case "isPrimeR": {
                        if (parts.length != 2) {
                            errorWriter.println("Invalid arguments for isPrimeR: " + line);
                            break;
                        }
                        String arg = parts[1].trim();
                        if (!isDigits(arg)) {
                            errorWriter.println("Invalid input for isPrimeR (not a non-negative integer): " + arg);
                            break;
                        }
                        int value = Integer.parseInt(arg);
                        boolean prime = Recursion.isPrimeR(value, Math.max(1, value - 1));
                        outputWriter.println(value + " is a " + (prime ? "prime" : "not prime") + " number");
                        break;
                    }
                    case "palindromeR": {
                        if (parts.length != 2) {
                            errorWriter.println("Invalid arguments for palindromeR: " + line);
                            break;
                        }
                        String s = parts[1];
                        boolean isPal = Recursion.palindromeR(s, 0, Math.max(0, s.length() - 1));
                        outputWriter.println(s + (isPal ? " is a palindrome" : " is not a palindrome"));
                        break;
                    }
                    case "sumR": {
                        if (parts.length < 2) {
                            errorWriter.println("Invalid arguments for sumR: " + line);
                            break;
                        }
                        ArrayList<Integer> nums = new ArrayList<>();
                        boolean bad = false;
                        for (int i = 1; i < parts.length; i++) {
                            String token = parts[i].trim();
                            if (!isDigits(token)) {
                                errorWriter.println("Invalid number in sumR: " + token + " (line: " + line + ")");
                                bad = true;
                                break;
                            }
                            nums.add(Integer.parseInt(token));
                        }
                        if (bad) break;
                        outputWriter.print("Sum of numbers: ");
                        int sum = Recursion.sumR(outputWriter, nums, 0);
                        outputWriter.println("is " + sum);
                        break;
                    }
                    case "reverseStringR": {
                        if (parts.length != 2) {
                            errorWriter.println("Invalid arguments for reverseStringR: " + line);
                            break;
                        }
                        String s = parts[1];
                        StringWriter sw = new StringWriter();
                        PrintWriter pw = new PrintWriter(sw);
                        Recursion.reverseStringR(pw, s);
                        pw.flush();
                        String rev = sw.toString();
                        outputWriter.println("Reverse of " + s + " is " + rev);
                        break;
                    }
                    default: {
                        errorWriter.println("Invalid command: " + cmd + " (line: " + line + ")");
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("An error occurred while processing the files: " + e.getMessage());
        }
    }

    public static boolean isDigits(String str){
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
