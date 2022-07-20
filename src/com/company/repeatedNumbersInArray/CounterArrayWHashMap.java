package com.company.repeatedNumbersInArray;

import java.util.HashMap;
import java.util.Map;

public class CounterArrayWHashMap { /* ❗ Requires importing Map & HashMap
This alternative Will save space and time */
    public static void main(String[] args) {
        int[] array = { 1, 6, 4, 6, 4, 8, 2, 4, 1, 1 };
        int arrayLength = array.length; // size of array

        HashMap<Integer, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < arrayLength; i++) {
            if (counterMap.containsKey(array[i])) {
                /* If element is already in map,
                then increase the value of element at index by 1 */
                int mapIndexValue = counterMap.get(array[i]);
                counterMap.replace(array[i], mapIndexValue + 1);
            } else // If element is not in map than assign it by 1
                counterMap.put(array[i], 1);
        }

        for (Map.Entry<Integer, Integer> i :
                counterMap.entrySet()) {
            // Print only if count of element is greater than 1
            if (i.getValue() > 1)
                System.out.println(i.getKey() + " "
                        + i.getValue());
            else
                continue;
        }
    }
}
