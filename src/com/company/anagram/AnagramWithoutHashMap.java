package com.company.anagram;

public class AnagramWithoutHashMap {
    static boolean isAnagram(String a, String b) /*throws Exception*/ {
        // Complete the function
        int counterB = 0;
        int counterA = 0;

        if (1 <= a.length() && 1 <= b.length() && a.length() <= 50 && b.length() <= 50 && a.length() == b.length()) {
            if (a.matches("[a-zA-Z]+") && b.matches("[a-zA-Z]+")) {
                for (int i = 0; i < a.length(); i++) {
                    char letterA = a.toLowerCase().charAt(i);

                    // System.out.println(letterA);

                    // Counting the number of times a letter repeats in string 1
                    for (int j = 0; j < a.length(); j++) {
                        if (letterA == a.toLowerCase().charAt(j))
                            counterA++;
                    }

                    // Counting the number of times a letter of string 1 repeats in string 2
                    for (int j = 0; j < b.length(); j++) {
                        if (letterA == b.toLowerCase().charAt(j)) {
                            counterB++;
                        }
                    }

                    // System.out.println("counter A: " + counterA + ", counterB: " + counterB);
                    if (counterA != counterB) return false;
                    counterA = 0;
                    counterB = 0;
                }
            }

            return true;
        }

        return false;
    }
}
