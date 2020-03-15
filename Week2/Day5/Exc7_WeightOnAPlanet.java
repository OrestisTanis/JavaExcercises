/* Week2_Day5_Exc7
*
* DESCRIPTION:
* Asks for weight and a planet. Computes weight on the planet based on the table below:
* #    Planet    Relative gravity
* 1    Venus        0.78
* 2    Mars         0.39
* 3    Jupiter      2.65
* 4    Saturn       1.17
* 5    Uranus       1.05
* 6    Neptune      1.23
* 
*/

import java.util.Scanner;

public class Exc7_WeightOnAPlanet {

	public static void main(String[] args){				
		System.out.println("************** Program Start ***************");	
		// Declarations && Initizations
		Scanner scanner = new Scanner(System.in);
		String output = "You weight ";	
		int weight = -1;	
		String userInput = "";	
		boolean inputValid = false;
		Object[][] data = {{"Venus","Mars", "Jupiter", "Saturn", "Uranus", "Neptune"},
                   		{0.78f, 0.39f, 2.65f, 1.17f, 1.05f, 1.23f}};
                   		
		
		// Input validation for 'weight'
		while (weight < 1){
			try {
				System.out.println("Please enter your weight in kgs.");
				weight = scanner.nextInt();
			}
			catch(Exception e){
				System.out.println("Please provide a valid integer number.");
				scanner.nextLine();
			}
		}

		// Input validation for 'planet'
		while (!inputValid){
			
			System.out.println("Please enter the name of your planet. The planet must be in our solar system.");
			userInput = scanner.next().trim().toLowerCase();

			for (int i = 0; i < data[0].length; i++){
				// Make matching case insensitive and trim whitespaces
				if (userInput.equals(((String) data[0][i]).toLowerCase())){
					// Don't go inside the while loop again
					inputValid = true;

					// Calculate the weight on the given planet
					float newWeight = (float) data[1][i] * weight;
					// Cut some decimal poitns
					String newWeightStr = String.format("%.1f",newWeight );

					output += newWeightStr + " kgs in " + data[0][i] + ".";					
				}									
			}
		}

		// Output
		System.out.println(output);
		System.out.println("************** Program End ***************");
	}

}