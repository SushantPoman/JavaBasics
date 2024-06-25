package Basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareFields {

    public static void main(String args[]){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Suhas","Kharadi",29));
        studentList.add(new Student(2, "Shrikant","Baner",34));
        studentList.add(new Student(3, "Shubham","Thergaon",24));
        studentList.add(new Student(4, "Sachin","Pirangut",32));

        Collections.sort(studentList); //Comparable sorting
        for(Student student: studentList)
            System.out.println(student.name+" "+student.add+" "+student.age);

//        Comparator<Student> ageComparator = (s1, s2) -> s1.age - s2.age;
        Comparator<Student> ageComparator = new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2) {
                return s1.age - s2.age;
            }
        };

        studentList.stream()
                .sorted(ageComparator)  //Using comparator
                .sorted((s1, s2) -> s1.age - s2.age) // Using lambda internally comparator only
                .sorted(Comparator.comparingInt(s -> s.age)) // Above line can be written like this
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .forEach(student -> System.out.println(student.name + " " + student.add + " " + student.age));
    }
}

class Student implements Comparable<Student>{

    public int id;
    public String name;
    public String add;
    public int age;

    public Student(int id, String name, String add, int age) {
        this.id = id;
        this.name = name;
        this.add = add;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student student) {
        if(age == student.age)
            return 0;
        else if(age < student.age)
            return 1;
        else
            return -1;
    }
}
