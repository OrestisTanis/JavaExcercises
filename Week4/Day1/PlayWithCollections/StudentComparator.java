package playwithcollections;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        int result = o2.getMark() - o1.getMark();
        if (result == 0){
            result = o1.getAge() - o2.getAge();
        }
        if (result == 0){
            result = o1.getMark() - o2.getMark();
            result = o1.getName().compareTo(o2.getName());
        }
        return result;
    }
}
