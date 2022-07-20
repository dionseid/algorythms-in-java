package com.company.repeatedNumbersInArray;

public class Main {
    public static int getAmountOfRepeatedNums(int[] arr) {
        int amount = 0;

        int temp = 0;
        int lastNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (temp != 0) {
                temp = 0;
                continue;
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j && arr[i] != lastNumber) {
                    amount++;
                    temp++;
                    lastNumber = arr[i];
                    break;
                }
            }
        }

        return amount;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 88, 54, 63, 4, 6, 7, 942, 36, 7, 1, 22, 7, 5, 62}; // 3
        int[] arr2 = {4, 4, 4, 4}; // 1
        int[] arr3 = {3, 2, 2, 1}; // 1
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // 10
        System.out.println("Amount of numbers that get repeated: " + getAmountOfRepeatedNums(arr));
        System.out.println("Amount of numbers that get repeated: " + getAmountOfRepeatedNums(arr2));
        System.out.println("Amount of numbers that get repeated: " + getAmountOfRepeatedNums(arr3));
        System.out.println("Amount of numbers that get repeated: " + getAmountOfRepeatedNums(arr4));
    }
}
