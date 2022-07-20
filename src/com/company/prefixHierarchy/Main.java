package com.company.prefixHierarchy;

import java.util.*;

public class Main {
    public static List<Integer> findCompletePrefixes(List<String> names, List<String> query) {
        List<Integer> prefixCounterList = new ArrayList<>();

        int counter = 0;
        boolean isFound = false;
        for (int i = 0; i < query.size(); i++) {
            for (String name : names) {
                if (query.get(i).length() != name.length() &&
                        name.length() > query.get(i).length() &&
                        query.get(i).equals(name.substring(0, query.get(i).length()))) {
                    counter++;
                    if (prefixCounterList.size() == i + 1) {
                        prefixCounterList.set(i, counter);
                    } else {
                        prefixCounterList.add(counter);
                    }
                    isFound = true;
                }
            }
            if (!isFound) prefixCounterList.add(i, counter);
            counter = 0;
            isFound = false;
        }

        return prefixCounterList;
    }

    public static void main(String[] args) {
//        System.out.println(findCompletePrefixes(Arrays.asList("jackson", "jacques", "jack"), Arrays.asList("jack"))); // 1
//        System.out.println(findCompletePrefixes(Arrays.asList("jackson", "jacques", "jackovi", "jack"), Collections.singletonList("jack"))); // 2
//        System.out.println(findCompletePrefixes(Arrays.asList("jackson", "jacques", "alexia", "jackovi", "alezander", "jack", "ale", "alexander"), Arrays.asList("jack", "ale"))); // 2 3
        System.out.println(findCompletePrefixes(Arrays.asList("steve", "stevens", "danny", "steves", "dan", "john", "johnny", "joe", "alex", "alexander"), Arrays.asList("steve", "alex", "joe", "john", "dan"))); // 2 1 0 1 1
    }
}
