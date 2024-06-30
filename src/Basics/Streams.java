package Basics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String args[]){

//        Sum using array
        /*int[] numArray = {3, 6, 2, 5, 2};
        int sum = Arrays.stream(numArray).sum();
        System.out.println("Sum: "+sum);*/

//        Avg using array
        /*int[] numArray = {10, 25, 30, 15, 20};
        OptionalDouble avg = IntStream.of(numArray).average();
        System.out.println("Avg: "+avg);*/

//        Multiplication using array
        /*int[] numArray = {10,2,5};
        OptionalInt mul = Arrays.stream(numArray).reduce((oldVal, newVal) -> oldVal*newVal);
        System.out.println("Avg: "+mul);*/

//        Accumulate names into a TreeSet
        /*Set<String> set = Arrays.asList("Mumbai", "Pune", "Mumbai", "Delhi")
                .stream()
                .collect(Collectors.toCollection(TreeSet::new));
        set.forEach(System.out::println);*/


//        Convert elements to strings and concatenate them, separated by commas
        String cityNames = Arrays.asList("Mumbai", "Pune", "Mumbai", "Delhi")
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("Cities: "+cityNames);

    }

}
