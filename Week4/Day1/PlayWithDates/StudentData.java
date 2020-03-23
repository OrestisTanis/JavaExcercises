package playwithcollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StudentData {
    private List<Student> studentList;

    public StudentData() {
        studentList = new ArrayList();
        populateData();
    }
    
    private void populateData(){
        studentList.add(new Student("Mick", 30, 50));
        studentList.add(new Student("Nick", 50, 95));
        studentList.add(new Student("John", 10, 40));
        studentList.add(new Student("Mary", 50, 60));
        studentList.add(new Student("James", 50, 95));
    }
    
    public List<Student> getStudentList(){
        List<Student> list = new ArrayList(studentList);
        return list;
    }
    
    public List<String> getListOfNames(){
        List<String> names = new ArrayList();
        for (Student s: studentList){
            names.add(s.getName());
        }
        return names;
    }
    
    public List<Student> getLinkedListOfGeneralStudents(){
        LinkedList<Student> linkedListStudents = new LinkedList(studentList);
        return linkedListStudents;
    }
    
    public List<Student> getLinkedListOfJavaStudents(List list){
        LinkedList<Student> studentsJava = new LinkedList(list);
        studentsJava.add(new Student("Jonathan", 20, 0));
        return studentsJava;
    }
    
    public Set<Student> getLinkedHashSetOfStudents(){
        Set<Student> setOfStudents = new LinkedHashSet(studentList);
        return setOfStudents;
    }
    
    public Set<Student> getTreeSetOfStudents(){
        Set<Student> treeSetStudents = new TreeSet(studentList);
        return treeSetStudents;
    }
    
    public TreeSet<Student> getTreeSetOfStudentsWithComparator(){
        StudentComparator myComparator = new StudentComparator();
        TreeSet<Student> treeSetStudentsByName = new TreeSet(myComparator);
        treeSetStudentsByName.add(new Student("Mick", 30, 50));
        treeSetStudentsByName.add(new Student("Nick", 50, 95));
        treeSetStudentsByName.add(new Student("John", 10, 40));
        treeSetStudentsByName.add(new Student("Mary", 50, 60));
        treeSetStudentsByName.add(new Student("James", 50, 95));
        return treeSetStudentsByName;
    }
    
    public Map<String, Integer> getHashMapOfStudents(){
        Map<String, Integer> hashMap = new HashMap();
        hashMap.put("Nick", 80);
        hashMap.put("Mary", 50);
        hashMap.put("Jack", 85);
        hashMap.put("George", 90);
        hashMap.put("Jack", 90);
        return hashMap;
    }
    
    public Set<String> getHashSetOfNames(){
        Set<String> hashSet = new HashSet();
        List<String> names = getListOfNames();
        for (String name: names){
            hashSet.add(name);
        }
        return hashSet;
    }
    
    public Set<String> getTreeSetOfNames(){
        StudentData data = new StudentData();
        Set<String> treeSet = new TreeSet();
        List<String> names = data.getListOfNames();
        for (String name: names){
            treeSet.add(name);
        }
        return treeSet;
    }
}
