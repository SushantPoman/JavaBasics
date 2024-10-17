package Basics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String args[]) {

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
        System.out.println("Cities: " + cityNames);

//        Find out first non repeated char
        String name = "Desserted";
        Map<Character, Long> map = name.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Character firstNon = map.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey();
        System.out.println("firstNon - " + firstNon);

//        Sort by descending count of character occurrences
        String countLetters = "Sushantsunilpoman";
        Map<Character, Long> countMap = countLetters.chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));
        Map<Character, Long> maxCount = countMap.entrySet().stream().sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (a, b) -> b, LinkedHashMap::new));
        maxCount.forEach((k, v) -> System.out.println(k + " " + v));



    }

}
