package DesignPatterns.creational;

import java.util.ArrayList;
import java.util.List;

public class DpPrototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employees emps = new Employees();
        emps.loadData();

        //Use the clone method to get the Employee object
        Employees empsClone = (Employees) emps.clone();
        Employees empsSecondClone = (Employees) emps.clone();
        List<String> list = empsClone.getEmpList();
        list.add("John");
        List<String> list1 = empsSecondClone.getEmpList();
        list1.remove("Pankaj");

        System.out.println("emps List: "+emps.getEmpList());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);
    }

}

class Employees implements Cloneable{

    private List<String> empList;

    public Employees(){
        empList = new ArrayList<>();
    }

    public Employees(List<String> empList){
        this.empList = empList;
    }

    public void loadData(){
        empList.add("Shrikant");
        empList.add("Suhas");
        empList.add("Sachin");
        empList.add("Pradip");
        empList.add("Shubham");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<>();
        for(String s : empList){
            tempList.add(s);
        }
        return new Employees(tempList);
    }
}
