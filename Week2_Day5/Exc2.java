/* Week2_Day5_Exc2
*
* DESCRIPTION:
* Outputs different message depending on a provided by the user day of the week using switch
*/ Monday-Friday: go to work. Sat-Sun: relaxing
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Exc2 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> daysOfTheWeekList = new ArrayList<String>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
		String output;
		String day = "";
		
		// Input Validation
		while (!daysOfTheWeekList.contains(day)){
			System.out.println("Please type a day of the week. Monday, Tuesday, ...");
			day = scanner.next();
		}		

		// Main Logic
		switch (day){
			case "Monday" :
			case  "Tuesday":
			case "Wednesday":
			case "Thursday":
			case "Friday":
				output = "Going to work.";
				break;
			default:
				output = "Relaxing";
				break;
		}

		// Output
		System.out.println(output);
	}

}