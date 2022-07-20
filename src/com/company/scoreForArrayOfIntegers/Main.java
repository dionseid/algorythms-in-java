package com.company.scoreForArrayOfIntegers;

public class Main {
    public static int getScore(int[] arr) {
        int score = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) score += 1;
            else if (arr[i] == 5) score += 5;
            else score += 3;
        }

        return score;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {17, 19, 21};

        System.out.println(getScore(arr1));
        System.out.println(getScore(arr2));
    }
}
