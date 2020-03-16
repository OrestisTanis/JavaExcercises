// Week3_Day1_Exc1

/** 
 * DESCRIPTION
 * Asks the user to enter Name, Age, Height, Weight for each person in his/her family.
 * Stores these details in a file in your Operating System.
 * The format of the file must is the following:
 * NAME        AGE        HEIGHT(m)    WEIGHT(kg)
 * Jack        12            1.85            65
 * Mary        24            1.76            76
 * The program should end only when the user enters "exit". 
 * The process cannot be interrupted while entering details of a user. 
 * Everytime the user inserts a person, the program should inform the user that "Person was successfully created".
 * Finally read the file that you created and print everything in the output
 */
package exc1_familyinfo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author orestis
 */
public class Exc1_FamilyInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("***************************************");
        System.out.println("********* FamilyWriter v1.0 ***********");
        System.out.println("***************************************\n");
        
        
        // Get the path of the file
        String filePath = "/Users/orestis/programming/FamilyWriter.txt";
        
        // Construct the string to be written to file 
        String strToWrite = String.format("NAME\tAGE\tHEIGHT(m)\tWEIGHT(kg)\n");
        writeToFile(filePath, strToWrite);

        System.out.println("Please enter a family person name: ");
        String name = getName(scanner);
        System.out.println();
        
        String charAfterApostrophy = Character.toLowerCase(name.charAt(name.length() - 1)) == 's'? "" : "s";
        System.out.printf("Please enter %s'%s age:  \n", name, charAfterApostrophy);
        int age = getAge(scanner);
        System.out.println();
        
        System.out.printf("Please enter %s'%s height:  \n", name, charAfterApostrophy);
        float height = getHeight(scanner);
        System.out.println();
        
        System.out.printf("Please enter %s'%s weight:  \n", name, charAfterApostrophy);
        int weight = getWeight(scanner);
        System.out.println();
        
        // Saving to file
        strToWrite = String.format("%s\t%d\t%f\t%d\n", name, age, height, weight);
        writeToFile(filePath, strToWrite);  
        
        System.out.println("Person was successfully created\n");
        scanner.close();
        
    }
    
    
    
    static void writeToFile(String filePath, String strToWrite) throws IOException{
        FileWriter writer = new FileWriter(filePath, true);
        // Write to file
        writer.append(strToWrite);
        // Close writer
        writer.close();
    }
    
    static String getName(Scanner scanner){
        String userInput = "";
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        
        // Input validation
        while(!pattern.matcher(userInput).matches()){
            userInput = scanner.next().trim();
            
            if (!pattern.matcher(userInput).matches()){
                System.out.println("Invalid name.");
            }
        }  
        
        //scanner.close();
        return userInput;       
    }
    
    static int getAge(Scanner scanner){
        int input = 0;
        
        do {       
            if (input < 0 || input > 100){
                System.out.println("Please enter a valid age (0-100): ");
            }
           
            try {
                input = scanner.nextInt();
            }
            catch (Exception e){                
                scanner.nextLine();
                input = -1;
            }
           
        } while (input < 0 || input > 100);
        
        return input;
    }
    
    static float getHeight(Scanner scanner){
        float input = 1f;
         
        do {            
            try {
                if (input < 0.5f || input > 2.50f){
                    System.out.println("Please enter a valid height in metres (0.5 - 2.50): ");
                }
                input = scanner.nextFloat();
            }
            catch (Exception e){                
                scanner.nextLine();
                input = -1f;
            }
        } while (input < 0.5f || input > 2.50f);
        
        // Format to 2 decimal digits
        String inputStr = String.format("%.2f", input);
        System.out.println(inputStr);
        return Float.parseFloat(inputStr);
    }
    
    static int getWeight(Scanner scanner){
        int input = 3;
        
        do {   
            if (input < 3 || input > 300){
                System.out.println("Please enter a valid weight in kgs (3-300): ");
            }
            
            try {
                input = scanner.nextInt();
            }
            catch (Exception e){                
                scanner.nextLine();
                input = -1;
            }
        } while (input < 3 || input > 300);
       
        return input;
    }
    
    
}
