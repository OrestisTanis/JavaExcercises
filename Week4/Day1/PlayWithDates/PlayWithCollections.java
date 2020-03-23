package playwithcollections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class PlayWithCollections {
    
    public static void main(String[] args) {
        StudentData data = new StudentData();
        playWithNames(data);
        playWithLists(data);
        playWithSets(data);
        playWithMaps(data); 
    }
    
    public static void playWithNames(StudentData data){
        List<String> names = data.getListOfNames();
        printListOfStrings(names, "\n------------- Printing List of Names ---------------");
    }
    
    public static void printListOfStrings(List<String> list, String message){
        System.out.println(message);
         for(String str: list){
            System.out.println(str);
        }
    }
    
    public static void playWithLists(StudentData data){
        List<Student> generalStudents = data.getLinkedListOfGeneralStudents();
        Printer.printListOfStudents(generalStudents, "\n------------- Printing General Students ---------------");
        List<Student> javaStudents = data.getLinkedListOfJavaStudents(generalStudents);
        Printer.printListOfStudents(javaStudents, "\n------------- Printing Java Students ---------------");
    }
    
    public static void playWithSets(StudentData data){
        Set<String> hashSetOfNames = data.getHashSetOfNames();
        Printer.printSetOfStrings(hashSetOfNames, "------------ PRINTING HASHSET OF STUDENTS ----------");
        Set<Student> setOfStudents = data.getLinkedHashSetOfStudents();
        Printer.printSetOfStudents(setOfStudents, "------------ PRINTING LINKEDHASHSET OF STUDENTS ----------");
        Set<String> treeOfNames = data.getTreeSetOfNames();
        Printer.printSetOfStrings(treeOfNames, "------------- PRINTING TREESET OF NAMES ----------");
        Set<Student> treeSetOfStudents = data.getTreeSetOfStudents();    
        Printer. printSetOfStudents(treeSetOfStudents,"------------- PRINTING TREESET OF STUDENTS (USING COMPARABLE) ----------" );        
        TreeSet<Student> treeSetStudentsByName = data.getTreeSetOfStudentsWithComparator();
        Printer.printSetOfStudents(treeSetStudentsByName, "------------- PRINTING TREESET OF STUDENTS (USING COMPARATOR) ----------");
    }
    
    public static void playWithMaps(StudentData data){
        Map<String,Integer> hashMap = data.getHashMapOfStudents();
//        System.out.println(hashMap.get("Nick"));;
//        System.out.println(hashMap.containsKey("Nick"));
        hashMap.replace("Mary", 100);
        Printer.printHashMapValues(hashMap, "------------- PRINTING HASHMAP VALUES ----------");
        Printer.printHashMapKeys(hashMap, "------------- PRINTING KEYS OF HASHMAP ----------");
        Printer.printHashMapEntrySet(hashMap, "------------- PRINTING ENTRYSET OF HASHMAP ----------");
        Printer.printHashMapEntrySetWithIterator(hashMap, "------------- PRINTING ENTRYSET OF HASHMAP WITH ITERATOR ----------");
    }
}
