/* Week2_Day5_Exc3 
*
* DESCRIPTION:
* Outputs what season is according to month. Accepts month as input from the terminal.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exc3 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String output;
		String month;

		ArrayList<String> monthsList = new ArrayList<String>(Arrays.asList(
			"January", 
			"February", 
			"March", 
			"April", 
			"May", 
			"June", 
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
		));		
			
		// Input Validation
		if (args.length == 0 || !monthsList.contains(args[0].trim())){
			output = "Please rerun the program and provide a month as a command line argument for the program to take as input. Example: January";
		}	
		else{
			month = args[0];

			switch (month){
				case "December":
				case "January" :
				case "February":
					output = "Winter.";
					break;
				case "March":			
				case "April":
				case "May":
					output = "Spring.";
					break;
				case "June":
				case "July":
				case "August":
					output = "Summer.";
					break;
				case "September":
				case "October":
				default:
					output = "Autumn.";
					break;			
			}
		}		

		// Output
		System.out.println(output);
		System.out.println("************** Program End ***************");
	}

}