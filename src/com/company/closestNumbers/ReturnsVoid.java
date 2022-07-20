package com.company.closestNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReturnsVoid {
    public static void closestNumbers(List<Integer> numbers) {
        if (numbers.size() >= 2 && numbers.size() <= 100000) {
            numbers.sort(Comparator.naturalOrder());
            List<Integer> closestNumbers = new ArrayList<>();
            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i < numbers.size(); i++) {
                if (numbers.get(i) >= -Math.pow(10,9) && numbers.get(i) <= Math.pow(10,9)) {
                    if (Math.abs(numbers.get(i) - numbers.get(i - 1)) < minDiff) {
                        minDiff = Math.abs(numbers.get(i) - numbers.get(i - 1));
                        closestNumbers = new ArrayList<>();
                    }
                    if (Math.abs(numbers.get(i) - numbers.get(i - 1)) == minDiff) {
                        closestNumbers.add(numbers.get(i - 1));
                        closestNumbers.add(numbers.get(i));
                    }
                }
            }
            for (int i = 1; i < closestNumbers.size(); i = i + 2) {
                System.out.println(closestNumbers.get(i - 1) + " " + closestNumbers.get(i)); // Print the pairs
            }
        }
    }

    public static void main(String[] args) {
//        closestNumbers(Arrays.asList(6, 2, 4, 10)); // 2 4 \n 4 6
        closestNumbers(Arrays.asList(3, 8, 2, 10, 5, 15, 20, 21, 30, 31)); // 2 3 \n 20 21 \n 30 31
//        closestNumbers(Arrays.asList(3, 8, 30, 2, 20, 10, 5, 15, 21, 31));
//        closestNumbers(Arrays.asList(6, 339, 12, 0, 13, -5)); // 12 13
    }
}
