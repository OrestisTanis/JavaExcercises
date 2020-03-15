/* Week2_Day5_Exc8
*
* DESCRIPTION:
* Uses a ternary to return a message child or adult. Older than 18 is adult.
*/

import java.util.Scanner;

public class Exc8 {

	public static void main(String[] args){				
		System.out.println("************** Program Start ***************");	
		// Declarations && Initizations
		Scanner scanner = new Scanner(System.in);
		String output = "You're a ";
		int age = -1;			
		
		// Input validation
		while (age < 1){
			try {
				System.out.println("Please enter your age.");
				age = scanner.nextInt();
			}
			catch(Exception e){
				System.out.println("Please provide a valid number.");
				scanner.nextLine();
			}
		}

		// Main Logic 
		output += (age < 19)? "child!" : "adult!";

		// Output
		System.out.println(output);
		System.out.println("************** Program End ***************");
	}

}