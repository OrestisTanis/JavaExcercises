// Week3_Day1_Exc3_PPT

/** 
 * DESCRIPTION
 * Asks for the user to write his/she’s name, surname, age, favorite color. 
 * Then writes the data in a text file. 
 */
package exc2_askforvariousinputs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author orestis
 */
public class PPT_Exc3_AskForVariousInputs {
    
    public static void main(String[] args) throws IOException {
        // Get input
        String firstName = getStringFromInput("Please enter your first name: ");
        String lastName = getStringFromInput("Please enter your last name: ");
        int age = getPositiveIntFromInput("What is your age? (1-99)");
        String favColor = getStringFromInput("Please enter your favorite color: ");
        System.out.println(firstName + " " + lastName + " " + age + " " + favColor);
        
        // Asks the user about his OS
        String os = getOS();
        
        // Get filePath according to OS
        String filePath = getFilePath(os);
        
        // Construct the string to be written to file in JSON format
        String strToWrite = String.format("{ \"firstName\": \"%s\", "
                + "\"lastName\": \"%s\", "
                + "\"age\": \"%d\", "
                + "\"favoriteColor\": \"%s\""
                + " }", firstName, lastName, age, favColor);
        
        // Write data to file
        writeToFile(filePath, strToWrite);
        
        System.out.println("Success! File written to " + filePath);
        
    }
    
    static String getStringFromInput(String question){
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        
        while(!userInput.matches("[a-zA-Z]+")){
            System.out.println(question);
            userInput = scanner.next();
        } 
        
        // Close input stream
        //scanner.close();
        return userInput;       
    }
    
    static int getPositiveIntFromInput(String question){
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        
        do {
            System.out.println(question);
            try {
                input = scanner.nextInt();
            }
            catch (Exception e){
                System.out.println("Please enter a positive integer number.");
                scanner.nextLine();
            }
        } while (input < 1 || input > 99);
        
        // Close input stream
        //scanner.close();
        return input;
    }
    
    static String getOS(){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        
        while(input.equals("windows") && input.equals("linux") && input.equals("macos")){
            System.out.println("Do you have Windows, MacOs, or Linux?");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        }
        
        return input;
    }
    
    
    static String getFilePath(String os){
        switch(os){
            case "windows":
                return "C:\\Users\\file.txt";
            default:
                return "/Users/orestis/programing/file.txt"; //TODO: give path as input
        }
    }
    
    static void writeToFile(String filePath, String strToWrite) throws IOException{
        FileWriter writer = new FileWriter(filePath, true);
        // Write to file
        writer.append(strToWrite);
        // Close writer
        writer.close();
    }
    
    
}
