/* Week2_Day5_Exc6
*
* DESCRIPTION:
* Outputs certain message depending on age provided by user input.
* lt 16>>You cannot drive
* 16-17>>You can drive but not vote
* 18-21>>You can vote but not drink
* gt 22>>You can do anything 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exc6 {

	public static void main(String[] args){				
		System.out.println("************** Program Start ***************");	
		// Declarations && Initizations
		Scanner scanner = new Scanner(System.in);
		String output;
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
		if (age < 16){
			output = "You cannot drive.";
		}
		else if (age < 18){
			output = "You can drive but not vote.";
		}
		else if (age < 22){
			output = "You can vote but not drink.";
		}
		else {
			output = "You can do anything.";
		}

		// Output
		System.out.println(output);
		System.out.println("************** Program End ***************");
	}

}