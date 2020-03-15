/* Week2_Day5_Exc10
*
* DESCRIPTION:
* Creates a classroom with a student capacity given by the user 
* and places students on seats until there are no empty seats left
* 
*/
import java.util.Scanner;
import java.util.Random;

public class Exc10_Classroom {

    public static void main(String[] args) {
        System.out.println("************** Program Start ***************");
        // Declarations && Initizations
        Scanner scanner = new Scanner(System.in);
        int numOfRows = -1;
        int studentCapacity = -1;
        String studentName = "";
        int randomRow = -1;
        int randomSeatInRow = -1;
        String userInput = "";

        // Input validation
        while (numOfRows < 1) {
            try {
                System.out.println("Please enter how many rows do you wish the classroom to have.");
                numOfRows = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please provide a positive integer number.");
                scanner.nextLine();
            }
        }

        while (studentCapacity < 1) {
            try {
                System.out.println("Please enter the desired student capacity.");
                studentCapacity = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please provide a positive integer number.");
                scanner.nextLine();
            }
        }

        // Calculate how many students fit in a single row
        int seatsPerRow = studentCapacity / numOfRows;

        // Calculate the number of extra sets 
        int extraSeatsNeeded = studentCapacity % numOfRows != 0 ? studentCapacity % numOfRows : 0;
        System.out.println("extraSeatsNeeded: " + extraSeatsNeeded + ", studentCapacity: " + studentCapacity);

        // Construct classroom with empty seats
        String[][] seats = new String[numOfRows][];
        for (int i = 0; i < seats.length; i++) {

            if (i != seats.length - 1) {
                seats[i] = new String[seatsPerRow];
            } else {
                seats[i] = new String[seatsPerRow + extraSeatsNeeded];
            }
        }
        
        // Get initial number of empty seats
        int numberOfEmptySeats = getNumberOfEmptySeats(seats);
        // Keep Asking for new students and place them until no seats are empty
        while (numberOfEmptySeats > 0) {
            boolean foundSeat = false;

            // Keep trying to fetch an empty seat until one is found
            while (!foundSeat) {
                // Get a random seat in a random row
                randomRow = getRandomRow(numOfRows);
                
                randomSeatInRow = getRandomSeatInRow(seats, randomRow);

                // If the random seat is empty get out of the while loop
                if (seats[randomRow][randomSeatInRow] == null) {
                    foundSeat = true;
                }
            }

            // Output the number of empty seats
            System.out.printf("%d seats are empty!\n", getNumberOfEmptySeats(seats));

            // Keep asking for student name until a valid one is given
            boolean inputValid = false;
            while (!inputValid) {
                System.out.printf("Please enter a valid student name for seat[%d][%d]:\n", randomRow, randomSeatInRow);
                userInput = scanner.next();
                inputValid = userInput.trim().matches("[a-zA-Z]+( +[a-zA-Z]+)*"); // regexp for "word word"
            }

            // Place student
            seats[randomRow][randomSeatInRow] = userInput;
            numberOfEmptySeats--;

            // Print the seats with all student seated
            printClassRoom(seats);
        }

    }

    static void printClassRoom(String[][] seats){
    	System.out.println("All students are placed on seats.");
        for (int i = 0; i < seats.length; i++) {
            System.out.printf("Row %d:\t", i + 1);
            for (int j = 0; j < seats[i].length; j++) {
               System.out.print(seats[i][j] + "\t");
            }
             System.out.println("");
        }
        System.out.println("************ End of Program *************");
    }

    static int getRandomRow(int numOfRows) {
        Random rnd = new Random();
        return rnd.nextInt(numOfRows);
    }

    static int getRandomSeatInRow(String[][] seats, int row) {
        Random rnd = new Random();
        return rnd.nextInt(seats[row].length);
    }

    static int getNumberOfEmptySeats(String[][] seats) {
        int emptySeats = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == null) {
                    emptySeats++;
                }
            }
        }
        return emptySeats;
    }

    static boolean seatIsEmpty(String seat) {
        return seat == null;
    }

}
