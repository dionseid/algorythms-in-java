package com.company.anagram;

import java.util.HashMap;

public class AnagramWHashMap {
    static boolean isAnagram(String a, String b) throws Exception {
        // Complete the function
        HashMap<Character, Integer> mapForStringA = new HashMap<>();
        HashMap<Character, Integer> mapForStringB = new HashMap<>();

        if (1 <= a.length() && 1 <= b.length() && a.length() <= 50 && b.length() <= 50 && a.length() == b.length()) {
            if (a.matches("[a-zA-Z]+") && b.matches("[a-zA-Z]+")) {

                for (int i = 0; i < a.length(); i++) {
                    if (mapForStringA.containsKey(a.charAt(i))) {
                        /* If element is already in map,
                        then increase the value of element at index by 1 */
                        int mapCurrentValue = mapForStringA.get(a.charAt(i));
                        mapForStringA.replace(a.charAt(i), mapCurrentValue + 1);
                    } else // If element is not in map than assign it by 1
                        mapForStringA.put(a.charAt(i), 1);
                }

                for (int i = 0; i < b.length(); i++) {
                    if (mapForStringB.containsKey(b.charAt(i))) {
                        /* If element is already in map,
                        then increase the value of element at index by 1 */
                        int mapCurrentValue = mapForStringB.get(b.charAt(i));
                        mapForStringB.replace(b.charAt(i), mapCurrentValue + 1);
                    } else // If element is not in map than assign it by 1
                        mapForStringB.put(b.charAt(i), 1);
                }
            } else
                throw new Exception("Only English alphabetic characters are supported");
        } else
            throw new Exception("incorrect word length");

        // Iterating HashMap through for loop
        for (HashMap.Entry<Character, Integer> letter :
                mapForStringA.entrySet()) {
//            System.out.println(letter.getValue());
//            System.out.println(mapForStringB.get(letter.getKey()));
            if (letter.getValue() != mapForStringB.get(letter.getKey())) return false;

            // Printing all elements of a Map
//            System.out.println(letter.getKey() + " = " + letter.getValue());
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(isAnagram("anagramm", "marganaa")); // ❌
//        System.out.println(isAnagram("dion", "diony")); // ❌
//        System.out.println(isAnagram("ñoño", "ñoño")); // ❌
//        System.out.println(isAnagram("dionys", "synoid")); // ✔
        System.out.println(isAnagram("dionys", "syntid")); // ❌
//        System.out.println(isAnagram("anagram", "margana")); // ✔
    }
}
