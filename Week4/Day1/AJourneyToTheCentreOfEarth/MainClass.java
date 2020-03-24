package mypackage;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import java.util.regex.Pattern;

public class MainClass {

    /* Task
       Write a program to count the occurrences of each word the text file provided.               
       Allow the user to type a word and report how many times that word appeared in the book.     
       Report all words that appeared in the book at least 500 times, in alphabetical order.      
                                                                                                  
       The solution uses a HashMap to store the number of occurrences for each word as it is very  
       efficient for all operations and then a TreeSet of the map's entries to sort them by occurrence number. */
    
    public static void main(String[] args) {
        Scanner sc = null;
        FileReader fl = null;
        Map<String, Integer> wordOccurrenceMap;
        
        try{
            fl = new FileReader("/Users/orestis/Programming/aJourneyToTheInteriorOfTheEarth.txt");
            sc = new Scanner(fl).useDelimiter("[^a-zA-Z']+");;
        }
        catch(Exception e){
            System.out.println("ERROR: File not found.");
        }
        
        wordOccurrenceMap = new HashMap();
        while(sc.hasNext()){
            String word = sc.next().toLowerCase();
            // If the word is already contained in the HashMap, 
            // increase the number of times it was found by one
            if (wordOccurrenceMap.containsKey(word)){
                wordOccurrenceMap.put(word, wordOccurrenceMap.get(word) + 1);
            }  
            else { // put it in the hashMap as it's the first occurrence
                wordOccurrenceMap.put(word, 1);
            }
        }
        
        System.out.println("Enter a word you wish to find the number of occurrences for in Jules' Verne \"A Journey to the Interior of Earth\": ");
        String wordFromUser = getStringFromInput("[a-zA-Z]+", "Please enter a valid word: ");
        int numberOfOccurence = (wordOccurrenceMap.get(wordFromUser) == null)? 0 : wordOccurrenceMap.get(wordFromUser);
        System.out.printf("The word \"%s\" appears %d times in the book's text.\n", wordFromUser, numberOfOccurence);

        printWordsWithMoreThan500Occurrences(wordOccurrenceMap);
        sc.close();
    }
    
    public static String getStringFromInput(String allowedRegex, String invalidInputMessage) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        boolean inputValid = false;
        Pattern pattern = Pattern.compile(allowedRegex);
        while (!inputValid) {
            userInput = scanner.nextLine().trim().toLowerCase();
            inputValid = pattern.matcher(userInput).matches();
            if (!inputValid) {
                System.out.println(invalidInputMessage);
            }
        }
        return userInput;
    }
    
    public static void printWordsWithMoreThan500Occurrences(Map wordOccurrenceMap){
        WordComparator wordComparator = new WordComparator();
        Set<Entry<String, Integer>> treeSet = new TreeSet(wordComparator);
        treeSet.addAll(wordOccurrenceMap.entrySet());
        Iterator<Map.Entry<String,Integer>> iterator = treeSet.iterator();
        System.out.println("\n------------ PRINTING WORDS WITH MORE THAN 500 OCCURRENCES --------------");
        int i = 0;
        while (iterator.hasNext()){
            Map.Entry entry = iterator.next();
            if ((int)entry.getValue() > 499){
                i++;
                System.out.println(i + ". " + entry.getKey() + " ---> " + entry.getValue());
            }
        }
    }
}
