// Week3_Day1_Exc2

/** 
 * DESCRIPTION
 * Creates a .txt file that contains the following 5 URLs.
* https://www.javatpoint.com/
* https://docs.oracle.com/javase/8/docs/
* https://www.baeldung.com/
* https://www.vogella.com//tutorials/java.html
* https://www.tutorialspoint.com/java_technology_tutorials.htm
* Reads the file and prints only the subdomain of each url.
* It also prints only the urls that contain the word java.
 */
package exc2_subdomains;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author orestis
 */
public class Exc2_SubDomains {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/orestis/programming/Subdomains.txt";
        // Write data to file
        File file = new File(filePath);
        writeUrlsToFile(file);
        
        // Read sudomains from file
        Scanner scanner = new Scanner(file);
        System.out.println("***************** PRINTING SUBDOMAINS *******************");
        readSubdomains(file, scanner);
        
        scanner = new Scanner(file);
        System.out.println("******* PRINTING URLS THAT CONTAIN THE WORD JAVA ********");
        printJava(file, scanner);
        
        // close scanner
        scanner.close();
    }
    
    static void printJava(File file, Scanner scanner) throws FileNotFoundException{
        String line;
        
        while (scanner.hasNextLine()) {
            
            line = scanner.nextLine();
            if (line.indexOf("java") > 0){
                System.out.println(line);
            }
        }
    }
    
    static void readSubdomains(File file, Scanner scanner) throws FileNotFoundException{
        String line;
        
        while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String subdomain = line.indexOf("www.") == -1 ? line.substring(line.indexOf("/") + 2, line.lastIndexOf(".")) : line.substring(line.indexOf(".") + 1, line.lastIndexOf(".com"));
                System.out.println(subdomain);
        }
                
    }
    
    static void writeUrlsToFile(File file) throws IOException{
        FileWriter writer = new FileWriter(file, true);
        
        // Write URLS to file
        writer.append("https://www.javatpoint.com/\n");
        writer.append("https://docs.oracle.com/javase/8/docs/\n");
        writer.append("https://www.baeldung.com/\n");
        writer.append("https://www.vogella.com//tutorials/java.html\n");
        writer.append("https://www.tutorialspoint.com/java_technology_tutorials.htm\n");
        // Close writer
        writer.close();
    }
    
}
