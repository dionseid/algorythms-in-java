package com.company.closestNumbers;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HackerRankVersion {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        //arr.sort(Comparator.naturalOrder());
        List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());
        List<Integer> numsSeparatedByMinDiff = new LinkedList<>();

        int minDiff = Integer.MAX_VALUE;

        // for (int i = 1; i < sorted.size(); i += 2) {
        //     if (sorted.get(i) - sorted.get(i - 1) < minDiff)
        //         minDiff = sorted.get(i) - sorted.get(i - 1);
        // }

        for (int i = 1; i < sorted.size(); i++) {
            if (Math.abs(sorted.get(i - 1) - sorted.get(i)) < minDiff)
                minDiff = Math.abs(sorted.get(i - 1) - sorted.get(i));
        }

        for (int i = 1; i < sorted.size(); i++) {
            if (Math.abs(sorted.get(i - 1) - sorted.get(i)) == minDiff) {
                numsSeparatedByMinDiff.add(sorted.get(i - 1));
                numsSeparatedByMinDiff.add(sorted.get(i));
            }
        }

        return numsSeparatedByMinDiff;
    }
}
