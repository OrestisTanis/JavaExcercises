package playwithcollections;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int mark;

    public Student(String name, int age, int mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int compareTo(Student other){
        int result = other.mark - this.mark; //Sort by grade
        if (result == 0){
            result = this.age - other.age; //IF same grade, sort by age
        }
        if (result == 0){
            result = this.name.compareTo(other.name); //If same age, sort by name
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.age;
        hash = 29 * hash + this.mark;
        return hash;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.mark != other.mark) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", age=" + age + ", mark=" + mark + '}';
    }
}
