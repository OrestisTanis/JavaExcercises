package mypackage;

import java.util.Comparator;
import java.util.Map.Entry;


public class WordComparator implements Comparator<Entry<String, Integer>>{
    @Override
    public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
        int result = e2.getValue() - e1.getValue();
        if (result == 0){
            return e1.getKey().compareTo(e2.getKey());
        }
        return result;
//        int result = o2.getMark() - o1.getMark();
//        if (result == 0){
//            result = o1.getAge() - o2.getAge();
//        }
//        if (result == 0){
//            result = o1.getMark() - o2.getMark();
//            result = o1.getName().compareTo(o2.getName());
//        }
//        return result;
    }
}