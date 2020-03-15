/* Week2_Day5_Exc4
*
* DESCRIPTION:
* Prints the number of days each month has. Uses switch.
*/
import java.util.ArrayList;
import java.util.Arrays;

public class Exc4_NumberOfDaysPerMonth {

	public static void main(String[] args){		
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
		
		System.out.println("************** Program Start ***************");	

		// Calculating the exact numbert of days for each month
		// Using If..Else if
		// for (int i = 0; i < monthsList.size(); i++){
		// 	int numberOfDays;

		// 	if ( i == 1){
		// 		numberOfDays = 28;
		// 	}	
		// 	else if ((i < 7 && i % 2 == 0) || (i >= 7 && i % 2 != 0)){
		// 		numberOfDays = 31;
		// 	}
		// 	else {
		// 		numberOfDays = 30;
		// 	}

		// 	// Output
		// 	System.out.printf("%s has %d days.\n", monthsList.get(i), numberOfDays);
		// }	

		// Using Switch, Code repeat here
		for (int i = 0; i < monthsList.size(); i++){
			int numberOfDays;

			switch (i){
				case 0:
					numberOfDays = 31;
					break;
				case 1:
					numberOfDays = 28;
					break;
				case 2:
					numberOfDays = 31;
					break;
				case 3:
					numberOfDays = 30;
					break;
				case 4:
					numberOfDays = 31;
					break;
				case 5:
					numberOfDays = 30;
					break;
				case 6:
					numberOfDays = 31;
					break;
				case 7:
					numberOfDays = 31;
					break;
				case 8:
					numberOfDays = 30;
					break;
				case 9:
					numberOfDays = 31;
					break;
				case 10:
					numberOfDays = 30;
					break;
				default:
					numberOfDays = 31;
					break;

			}
			System.out.printf("%s has %d days.\n", monthsList.get(i), numberOfDays);
		}		
		
		System.out.println("************** Program End ***************");
	}

}