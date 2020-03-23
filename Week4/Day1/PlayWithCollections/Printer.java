package playwithcollections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Printer {
    public static void printListOfStudents(List<Student> students, String message){
        System.out.println(message);
        for (Student s: students){
            System.out.println(s);
        }
    }
    
    public static void printSetOfStudents(Set<Student> setOfStudents, String message){
        System.out.println(message);
        for (Student s: setOfStudents){
            System.out.println(s);
        }
    }
    
    public static void printSetOfStrings(Set<String> set, String message){
        System.out.println(message);
        for (String name: set){
            System.out.println(name);
        }
    }
    
    public static void printHashMapValues(Map<String, Integer> hashMap, String message){
        Collection<Integer> values = hashMap.values();
        System.out.println(message);
        for (int value: values){
            System.out.println("Value: " + value);
        }
    }
    
    public static void printHashMapKeys(Map<String, Integer> hashMap, String message){
        Set<String> keysOfMap = hashMap.keySet();
        System.out.println(message);
        for(String key: keysOfMap){
            System.out.println(key + " -> " + hashMap.get(key));
        }
    }
    
    public static void printHashMapEntrySet(Map<String, Integer> hashMap, String message){
        System.out.println(message);
        Set<Map.Entry<String, Integer>> hashMapEntrySet = hashMap.entrySet();
        for(Map.Entry entry: hashMapEntrySet){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    
    public static void printHashMapEntrySetWithIterator(Map<String, Integer> hashMap, String message){
        Set<Map.Entry<String, Integer>> hashMapEntrySet = hashMap.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = hashMapEntrySet.iterator();
        System.out.println(message);
        while (iterator.hasNext()){
            Map.Entry entry = iterator.next();
//            if ((int)entry.getValue() < 95){
//                iterator.remove();
//            }
              System.out.println(entry);
        }
    } 
}
