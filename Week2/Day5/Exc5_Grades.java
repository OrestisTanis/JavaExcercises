/* Week2_Day5_Exc5
*
* DESCRIPTION:
* Outputs a message ("Perfect, Good, Pass, Fail") based on grade (A, B, C-D, the rest). 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exc5_Grades {

	public static void main(String[] args){				
		System.out.println("************** Program Start ***************");	
		// Declarations && Initizations
		Scanner scanner = new Scanner(System.in);
		String grade = "";	
		String output;

		
		// Input validation
		while (!grade.matches("[A-F]")){
			try {
				System.out.println("Please enter your grade A, B, C, D, E, F :");
				grade = scanner.next();
			}
			catch(Exception e){
				System.out.println("Please provide a valid grade.");
				scanner.nextLine();
			}
		}

		// Main Logic
		switch (grade){
			case "A":
				output = "Perfect";
				break;
			case "B":	
				output = "Good";
				break;
			case "C":
				output = "Pass";
				break;
			default:	
				output = "Fail";
				break;
		}

		// Output
		System.out.println(output);
		System.out.println("************** Program End ***************");
	}

}