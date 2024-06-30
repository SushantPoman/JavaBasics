package Basics;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsCustom {

    static List<Employee> empList = new ArrayList<>();

    public static void main(String args[]) {

        addDataToList();

//        Employee names using forEach - map(Function - input and output)
        /*empList.stream()
                .map(emp -> emp.getName())
                .forEach(System.out::println);*/

//        Sum of salary
        /*int sum = empList.stream().mapToInt(emp -> emp.getSalary()).sum();
        System.out.println("Sum "+sum);*/

//        Filter Employee names starts with "Sh" - filter(Predicate - input and output boolean)
        /*empList.stream()
                .filter(emp -> emp.getName().startsWith("Sh"))
                .forEach(emp -> System.out.println(emp.getName()+" "+emp.getSalary()));*/

//        Filter out based on salary and increase the salary
        /*empList.stream()
                .filter(emp -> emp.getSalary() > 15000)
                .map(emp -> {
                    emp.setSalary(emp.getSalary()+10000);
                    return emp;
                })
                .forEach(emp -> System.out.println(emp.getName()+" "+emp.getSalary()));*/

//        Third highest salary
        /*Optional<Employee> thirdHighestEmp =empList.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .skip(2)
                .findFirst();
        System.out.println(thirdHighestEmp.get().getName()+" "+thirdHighestEmp.get().getSalary());*/

//        Group by city with all employees in city
        /*Map<String, List<Employee>> empMap = empList.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        empMap.forEach((k, listEmp) ->
                listEmp.forEach(emp ->
                        System.out.println(k + " " + emp.getName() + " " + emp.getSalary())
                ));*/

//        Group by city and count of employee within city
        /*Map<String, Long> empMap = empList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getCity,
                        Collectors.counting())
                );
        empMap.forEach((k,v) ->
                System.out.println(k +" "+v));*/

//        Group by city and then sort using highest salary within city
        /*Map<String, Employee> empMap = empList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getCity,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                                        Optional::get)
                        )
                );
        empMap.forEach((k, emp) ->
                System.out.println(k + " " + emp.getName() + " " + emp.getSalary()));*/

//        Partition employees using age, older and younger
        Map<Boolean, List<Employee>> empMap = empList.stream()
                .collect(
                        Collectors.partitioningBy(emp -> emp.getAge() >= 30)
                );
        empMap.forEach((k, listEmp) ->
                listEmp.forEach(emp ->
                        System.out.println((k ? "Older " : "Younger ") + " " + emp.getName() + " " + emp.getSalary())
                ));


    }

    private static void addDataToList() {
        empList.add(new Employee(1, "Sushant", 10000, "Pune", 30));
        empList.add(new Employee(2, "Shrikant", 15000, "Mumbai", 25));
        empList.add(new Employee(3, "Sachin", 30000, "Pune", 40));
        empList.add(new Employee(4, "Shubham", 20000, "Mumbai", 36));
        empList.add(new Employee(5, "Suhas", 14000, "Chennai", 23));
        empList.add(new Employee(6, "Pradip", 19000, "Delhi", 28));
    }

}

class Employee {
    private Integer id;
    private String name;
    private Integer salary;
    private String city;
    private Integer age;

    public Employee(Integer id, String name, Integer salary, String city, Integer age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }
}
