package org.java8.training.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Bharath.MC
 * @since Aug-2020
 */
public class FunctionalInterfaces {

    public static void main(String[] args) {
        functionalInterface02();
    }

    private static void functionalInterface02() {
        Function<Integer, String> formatter = x -> "Value of X="+x;
        List<Integer> numbers = Arrays.asList(8,2,1,6,5);

        numbers.stream()
                .map(formatter)
                .forEach(System.out::println);

        //Consumenr take input and no output
        Consumer<Integer> printConsumer = (x) -> System.out.println("x="+x);
        numbers.stream()
                .forEach(printConsumer);

        //Supplier : No Input -> but return something [something like factory]
        Supplier<Integer> randomIntegerSupplier = () -> new Random().nextInt();
        System.out.println(randomIntegerSupplier.get());

    }


    private static void functionalInterface01() {
        List<Integer> numbers = Arrays.asList(8,2,1,6,5);
        BinaryOperator<Integer> sumOp1 = Integer::sum;

        BinaryOperator<Integer> sumOp2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                System.out.println(integer +" "+ integer2+" = "+ (integer+integer2));
                return integer+integer2;
            }
        };

        BinaryOperator<Integer> sumOp3 = (x,y) -> x+y;

        int sum = numbers.stream()
                .reduce(0, sumOp3);

        int sum2 = numbers.stream()
                .reduce(0, (x,y) -> x+y);
        System.out.println(sum2);
    }


}
