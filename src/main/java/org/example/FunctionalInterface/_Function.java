package org.example.FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main( String[] args ) {
        Integer increment = incrementByOne(0);
        System.out.println(increment);
        Integer increment2 = incrementOneFunction.apply(increment);
        System.out.println(increment2);
        Integer multiply = multiplyByTen.apply(increment2);
        System.out.println(multiply);
        Function<Integer, Integer> addAndMultiply = incrementOneFunction.andThen(multiplyByTen);
        Integer addAndMultiplyNumber = addAndMultiply.apply(multiply);
        System.out.println(addAndMultiplyNumber);
        Integer biFunNum = incrementByOneAndMultiplyTen.apply(1, 10);
        System.out.println(biFunNum);
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyTen = (number1, number2) -> (number1 + 1) * number2;
    static Function<Integer, Integer> incrementOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyByTen = number -> number * 10;

    private static Integer incrementByOne(int number) {
        return number + 1;
    }
}
