package org.java8.training.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bharath.MC
 * @since Aug-2020
 */
public class BasicLambdas {

    public static void main(String[] args) {
        //printAllNumbersInList(Arrays.asList(1,2,3,4,5, 12, 23 ,45, 67, 89, 90));
        createNewListWithlengthOfCources();
    }

    public static void createNewListWithSquareofNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 12, 23, 45, 67, 89, 90);
        List<Integer> doubleList = numbers.stream()
                .filter(number -> number%2==0)
                .map(number -> number * number)
                .collect(Collectors.toList());
        System.out.println(doubleList);
    }

    public static void createNewListWithlengthOfCources() {
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<String> doubleList = courses.stream()
                .map(course -> course+":"+course.length())
                .collect(Collectors.toList());
        System.out.println(doubleList);
    }


    public static void distinctValues() {
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.stream()
                .distinct()
                .sorted()
                .sorted(Comparator.reverseOrder())  //reverse order -desc
                //.sorted(Comparator.comparing(course -> course.length())) //based on length
                .forEach(System.out::println);
    }

    public static void printList(int number) {
        System.out.println(number);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printAllNumbersInList(List<Integer> numbers) {
        numbers.stream()
                .filter(BasicLambdas::isEven)
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }

    public static void excersise01() {
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.stream()
                .forEach(course -> System.out.println(course + ":" + course.length()));
    }

    public static void excersise05() {
        //Print the cubes of odd numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 12, 23, 45, 67, 89, 90);
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number + ":" + number * number * number)
                .forEach(number -> System.out.println(number));
    }

    public static void excersise07() {
        //Cube every odd number in a list and find the sum of cubes
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 12, 23, 45, 67, 89, 90);
        int sum = numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> (number * number * number))
                .reduce(0, Integer::sum); // reduce acept, initialAggigat value and next value
        System.out.println(sum);
    }

    public static int sum(int aggerigate, int nextNumber) {
        return aggerigate + nextNumber;
    }

    public static void excersise08() {
        //sum of numbers in list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 12, 23, 45, 67, 89, 90);
        int sum = numbers.parallelStream()
                .reduce(0, BasicLambdas::sum)
                .intValue();
        System.out.println(sum);

        sum = numbers.parallelStream()
                .reduce(0, (x,y) -> x+y)
                .intValue();
        System.out.println(sum);

        sum = numbers.parallelStream()
                .reduce(0, Integer::sum)
                .intValue();
        System.out.println(sum);
    }

    public static void excersise09() {
        //sum of numbers in list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 12, 23, 45, 67,124,  89, 90);

        int max = numbers.parallelStream()
                .reduce(0, (x,y) -> x>y? x :y)
                .intValue();
        System.out.println(max);

        max = numbers.parallelStream()
                .reduce(0, Integer::max)
                .intValue();
        System.out.println(max);
    }
}
