package classexcerciseendofweek1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EnterTheClubExcercise {

    public static void main(String[] args) {
        String name;
        char gender;
        byte age;
        float height;
        short weight;
        String favoriteSeason;
        String luckyDay;
        
        // To read user input
        Scanner scanner = new Scanner(System.in);
        
        // Meeting the user
        printMessage("Hello. What is your name?");
        name = getName(scanner);
        printMessage("*************************************");
        
        printMessage("What is your gender?");
        gender = getGender(scanner);
        printMessage("*************************************");
        
        printMessage("What is your age?");
        age = getAge(scanner);
        printMessage("*************************************");
        
        // Commenting on age
        printMessage(commentOnAge(age));
        
        // Calculating age in 1980 & 2040
        calculateAgeIn(age, 1980);
        calculateAgeIn(age, 2040);
        printMessage("*************************************");
        
        // Favorite Season
        ArrayList<String> seasonList = createListAndPopulate("Winter", "Spring", "Summer", "Autumn");
        
        printMessage("What is your favorite season?");
        printOptionsFromArrayList(seasonList);
        favoriteSeason = getSelectionFromList(seasonList, scanner);
      
        printMessage(commentOnFavSeason(favoriteSeason));
        printMessage("*************************************");
        
        // Body Mass
        printMessage("Ok.. Now enter your height. Like 1.90");
        height = getHeight(scanner);
        
        printMessage("And now your weight.");
        weight = getWeight(scanner);
        
        printMessage(commentOnBodyMass(height, weight));
        printMessage("*************************************");
        
        // Lucky Day
        luckyDay = getLuckyDay(age);
        printMessage("Your lucky day is: " + luckyDay);
        printMessage("*************************************");
        
        // At the club entrance
        boolean allowedInClub = checkIfAllowedInClub(luckyDay, age);
        if (allowedInClub){
            printMessage(getGreetingAfterEntrance(age, name, scanner, gender));
        }
        
        // Always close the input stream
        scanner.close();
        
    }
    
  
    static void printMessage(String message){
        System.out.println(message);
    }
    
    /**
     * Returns a string which contains only letters from the english or greek alphabet.
     */
    static String getName(Scanner sc){
        String input = "123";
        String regex = "[a-zA-Zα-ωΑ-Ω]+";
        
        while (!(input.matches(regex))){            
            printMessage("Please enter a valid name.");
            input = sc.next();            
        }
         
        return input;
    }
    
    /**
     * Reads input from the user and returns a char with the value of M, m, F, or f.
     */
    static char getGender(Scanner sc){
        char input = 'a';
        
        while (input != 'm' && input!= 'f' && input != 'M' && input != 'F'){            
            printMessage("M / F?");
            input = sc.next().charAt(0);          
        }
        
        return input;
    }
    
    /**
     * Reads input from the user and returns a byte within the range of 7-127.
     */
    static byte getAge(Scanner sc){
        byte input = -1;
        
        while (input <= 7 || input > 127){
            try {    
                printMessage("Now enter your age. Integer please and with a realistic value!");
                input = sc.nextByte();
            }
            catch (InputMismatchException e){
                sc.nextLine();
            }
        }
        
        return input;
    }
    
    /**
    * Reads input from the user and returns a float within the range of 1-3f.
    */
    static float getHeight(Scanner sc){
         float input = -1f;
    
         while (input <= 1f || input > 3f){
            try {    
                printMessage("A realistic value!");
                input = sc.nextFloat();
            }
            catch (InputMismatchException e){
                sc.nextLine();
            }
        }
       return input;
    }
     
    /**
     * Reads input from the user and returns a short within the range of 15-600.
     */
     static short getWeight(Scanner sc){
         short input = -1;
         
         while (input <= 15 || input > 600){
            try {    
                printMessage("No need for decimals here! Tomato-tomato!");
                input = sc.nextShort();
            }
            catch (InputMismatchException e){
                sc.nextLine();
            }
        }
       return input;
     }
    
     
    /**
    * Returns a string commenting about user's age.
    */ 
    static String commentOnAge(int age){
        int kidBound = 5;
        int studentBound = 18;
        int employedBound = 40;
        
        if (age < 0){
            return "You must be kidding me.";
        }
        else if (age < kidBound){
            return "You are too young for this app. \nCome back in " + (kidBound - age) + " years when you will be a student.";
        }
        else if (age < studentBound){
            return "Oh, you are a student. \nKeep up... " + (studentBound - age) + " years left and afterwards you'll start making money.";          
        }
        else if (age < employedBound){
            return "Oh, you must be employed. \nYou started working " + (age - studentBound) + " years ago.";
        }
        else {
            return "Oh, you are too old for this app";
        }
    }
    
    static void calculateAgeIn(int age, int targetYear){
        int yearNow = 2020;
        int yearBorn = yearNow - age;        
        
        if (yearBorn > targetYear){
            printMessage("You were not even born in " + targetYear + ", dude!");
        }
        else{
            printMessage("Your age in " + targetYear + ": " + (targetYear - yearBorn) + " years old.");
        }
    }
    
    
    static ArrayList<String> createSeasonList(){
        ArrayList<String> seasonList = new ArrayList();
        seasonList.add("Winter");
        seasonList.add("Spring");
        seasonList.add("Summer");
        seasonList.add("Autumn");
        return seasonList;
    }
    
    /**
    * Prints the contents of an arrayList of strings as numbered options
    */ 
    static void printOptionsFromArrayList(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++){
            printMessage(i+1 + ". " + list.get(i));
        }
    }
    
    /**
    * Returns the string at an arrayList's specified index, based on user input
    */ 
    static String getSelectionFromList(ArrayList<String> list, Scanner sc){
        byte input = -1;
        int listSize = list.size();
         
         while (input < 1 || input > listSize){
            try {    
                printMessage("Enter a valid number between 1 and " + listSize);
                input = sc.nextByte();
            }
            catch (InputMismatchException e){
                sc.nextLine();
            }
        }
       return list.get(input - 1);
    }
    
    
    static String commentOnFavSeason(String favoriteSeason){
        
        switch (favoriteSeason) {
            case "Winter":
                return "It must be cold outside!";
            case "Spring":
                return "Ohh, flowers are very beautiful these days!";
            case "Summer":
                return "Let's go for swimming!";
            default:
                return "The trees are full of brown leaves!";
        }        
        
    }
    
    static String commentOnBodyMass(double height, int weight){
       
        double bmi = weight / Math.pow(height, 2);
        
        if (bmi < 18.5) return "I hardly see you. You are underweight!";
        
        if (bmi < 24.9) return "Seems like you have normal weight.";
        
        if (bmi < 29.9) return "Whoops. You are overweight.";
       
        return "Hey! You are obese! Get up from that couch now!";
        
    }
    
    
    static String getLuckyDay(int age){
        ArrayList<String> weekDaysList = createListAndPopulate("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        
        int days = age * 365;
        int sumOfDigits = 0;
        
        while (days > 10){
            sumOfDigits += days % 10;
            days /= 10;
        }
        sumOfDigits += days;
                
        if (sumOfDigits > 6){
            sumOfDigits %= 7;
        }
        System.out.println(sumOfDigits );
                
        return weekDaysList.get(sumOfDigits);
    }
    
    /**
    * Returns a newly created arrayList of strings, populated with the specified string literal arguments
    */ 
    static ArrayList<String> createListAndPopulate(String ...args){
        ArrayList<String> list = new ArrayList();
        
        for (int i = 0; i < args.length; i++){
            list.add(args[i]);
        }
       
        return list;
    }
    
    static boolean checkIfAllowedInClub(String luckyDay, int age){
        String allowedFavDay = "Wednesday";
        
        if (!(luckyDay == allowedFavDay)){
            printMessage("You can't enter the club. Your lucky day is not " + allowedFavDay);
            return false;
        }
        
        if (age < 20){
            printMessage("You can't enter the club. You are too young");
            return false;
        }
        else if (age > 40){
            printMessage("You can't enter the club. You are too old");
            return false;
        }
        else {
            printMessage("You can enter the club.");
            return true;
        }
        
    }
    
    static String getGreetingAfterEntrance(int age, String name, Scanner sc, char gender){
        
        if (age < 25){
            return "Hello, " + name + ".";
        }
        else {            
            if (gender == 'M' || gender == 'm'){
                 return "Hello, Mr. " + name + ".";
            }
            else {
                printMessage("Are you married? Y/N?");
                return getWomanGreeting(name, sc);
            }
        }
    }    
    
    static String getWomanGreeting(String name, Scanner sc) {
        char isMarriedAns = getYesOrNoAnswer(sc);
        
        if (isMarriedAns == 'Y')
            return "Hello, Mrs. " + name + ".";
         else 
            return "Hello, Ms. " + name + ".";
    }
    
    
    static char getYesOrNoAnswer(Scanner sc){
        char input = 'a';
        
        while (input != 'y' && input!= 'Y' && input != 'n' && input != 'F'){            
            printMessage("Y / N?");
            input = sc.next().charAt(0);          
        }
        
        return input;
    }
    
}
