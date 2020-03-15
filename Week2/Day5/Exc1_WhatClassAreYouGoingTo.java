/* Week2_Day5_Exc1
*
* DESCRIPTION:
* Outputs what class in school are you going, according to age
* 
*/
import java.util.Scanner;

public class Exc1_WhatClassAreYouGoingTo {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
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

		// If...ElseIf
		if (age < 6){
			System.out.println("You are going to the kindergarden!");
		}
		else if (age < 13){
			System.out.println("You are going to primary school");
		}
		else if (age < 16){
			System.out.println("You are going to secondary school!");
		}
		else if (age < 19){
			System.out.println("You are going to high school!");
		}
		else if (age < 24){
			System.out.println("You are going to university!");
		}
		else {
			System.out.println("You have finished with your studies!");
		}

		// Switch
		// You can't have relational operators in Switch's case check
		// One could use enums to achieve it but additional lines code would be needed

	}


}