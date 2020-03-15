/* Week2_Day5_Exc9
*
* DESCRIPTION:
* Creates a program that stores the names of your 4 best friends in an array. 
* Then prints the contents of the array. Uses for-traditional, for enhanced, while, do-while loops.
* 
*/

import java.util.Scanner;

public class Exc9_BestFriends {

	public static void main(String[] args){				
		System.out.println("************** Program Start ***************");	
		// Declarations && Initizations
		Scanner scanner = new Scanner(System.in);
		String output = "";	
		String userInput = "";	
		String[] friendsArr = new String[4];		
	    short counter = 0;
	    boolean inputValid = false;  

		// Input validation
		while ((friendsArr[friendsArr.length - 1] == null)){			

			System.out.println("Enter the name of a best friend of yours.");
			userInput = scanner.next().trim();
			
			inputValid = userInput.matches("[a-zA-z]+");			

			if (inputValid){
				System.out.println("Adding friend in: friendsArr["+counter+"]");
				friendsArr[counter] = userInput;
				counter++;
				inputValid = false;
			}		
		}

		// For-loop
		printWithFor(friendsArr);

		// Enhanced for-loop
		printWithEnhancedFor(friendsArr);

		// While loop
		printWithWhile(friendsArr);		

		// Do While loop
		printWithDoWhile(friendsArr);		
	}

	static void printWithFor(String[] friendsArr){
		System.out.println("********* Printing using for-loop **********");
		System.out.print("[ ");
		for (int i = 0; i < friendsArr.length; i++){
			if (i == friendsArr.length - 1){
					System.out.print(friendsArr[i] + " ");
			}
			else{
				System.out.print(friendsArr[i] + ", ");
			}
		}
		System.out.print("]\n");
	}

	static void printWithEnhancedFor(String[] friendsArr){
		System.out.println("********* Printing using enhanced for-loop **********");		
		System.out.print("[ ");
		int i = 0;
		for (String friend: friendsArr){			
			if (i == friendsArr.length - 1){
					System.out.print(friend + " ");
			}
			else{
				System.out.print(friend + ", ");
			}
			i++;
		}
		System.out.print("]\n");
	}

	static void printWithWhile(String[] friendsArr){
		System.out.println("********* Printing using while loop **********");
		System.out.print("[ ");
		int i = 0;
		while (i < friendsArr.length){
			if (i == friendsArr.length - 1){
				System.out.print(friendsArr[i] + " ");
			}
			else{
				System.out.print(friendsArr[i] + ", ");
			}
			i++;
		}
		System.out.print("]\n");		
	}

	static void printWithDoWhile(String[] friendsArr){
		System.out.println("********* Printing using do-while loop **********");
		System.out.print("[ ");
		int i = 0;
		do {
			if (i == friendsArr.length - 1){
					System.out.print(friendsArr[i] + " ");
			}
			else{
				System.out.print(friendsArr[i] + ", ");
			}
			i++;
		} while (i < friendsArr.length);
		System.out.print("]\n");
	}
}