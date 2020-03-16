// Week3_Day1_Exc1_PPT

/** 
 * DESCRIPTION
 * Gets your favorite movie quote 
 * and displays the total number of spaces contained in the String. 
 */
package exc1_howmanyemptyspaces;

import java.util.Scanner;


public class PPT_Exc1_HowManyEmptySpaces {
    
    public static void main(String[] args) {
        // Input
        String favoriteMovieQuote = getUserInput();
        // Calculates number of spaces
        int numOfSpaces = getNumberOfSpaces(favoriteMovieQuote);
        
        System.out.printf("Your favorite movie quote contains %d whitespaces!\n", numOfSpaces);
    }
    
    
    static String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        
        // Validate input
        while(userInput.length() == 0){
            System.out.println("Please enter your favorite movie.");
            userInput = scanner.nextLine().trim();
        }
        
        // Close the input stream
        scanner.close();
        
        return userInput;
    }
    
    static int getNumberOfSpaces(String str){
        int numOfWhiteSpaces = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                numOfWhiteSpaces++;
             
            }
            //System.out.println(str.charAt(i));
        }
        return numOfWhiteSpaces;
    }
}
