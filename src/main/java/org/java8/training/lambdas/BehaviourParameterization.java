package org.java8.training.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @author Bharath.MC
 * @since Aug-2020
 */
public class BehaviourParameterization {

    public static void main(String[] args) {
        BehaviourParameterization1();
    }

    private static void BehaviourParameterization1() {
        List<Integer> numbers = Arrays.asList(8, 2, 1, 6, 5);

        Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        Predicate<Integer> oddPredicate = x -> x % 2 != 0;

        filterNumbers(numbers, evenPredicate);
        System.out.println("----------");
        filterNumbers(numbers, oddPredicate);
        System.out.println("----------");
        filterNumbers(numbers, x -> x % 3 == 0);
    }

    private static void filterNumbers(List<Integer> numbers, Predicate<Integer> oddPredicate) {
        numbers.stream()
                .filter(oddPredicate)
                .forEach(System.out::println);
    }





}
