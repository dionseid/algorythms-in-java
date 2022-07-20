package com.company.anagram;

import java.util.Arrays;

public class SimplifiedVersionWithoutArray {
    /* However, the overall running time of this algorithm is O(n log n)
    because sorting an array of n characters takes O(n log n) time
    For the algorithm to function,
    it must make a copy of both input strings as character arrays,
    using a little extra memory */
    boolean isAnagramSort(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        char[] a1 = string1.toCharArray();
        char[] a2 = string2.toCharArray();

        for (int i = 0; i < a1.length; i++) {
            for (int j = 1; j < a1.length; j++) {
                if (a1[i] < a1[j])
                    a1[i] = a1[j];
            }
        } // ...

//        Arrays.sort(a1);
//        Arrays.sort(a2);
//        return Arrays.equals(a1, a2);

        return true;
    }
}