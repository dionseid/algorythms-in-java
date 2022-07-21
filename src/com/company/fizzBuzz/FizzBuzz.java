package com.company.fizzBuzz;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static void fizzBuzz(int n) {
        // Write your code here
        if (0 < n && n < 2 * Math.pow(10, 5)) {
            IntStream.rangeClosed(1, n)
                    .mapToObj(i -> i % 5 == 0 ? (i % 3 == 0 ? "FizzBuzz" : "Buzz") : (i % 3 == 0 ? "Fizz" : i))
                    .forEach(System.out::println);
        }
    }
}
