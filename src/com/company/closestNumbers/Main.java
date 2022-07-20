package com.company.closestNumbers;

public class Main {
    public static int[] sortArrayWPosInts(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j : arr)
            if (j > max)
                max = j;

        int[] counterArray = new int[max + 1];
        for (int j : arr)
            counterArray[j]++;

        int[] sortedArray = new int[arr.length];
        int index = 0;
        for (int i = 0; i < counterArray.length; i++)
            if (counterArray[i] != 0)
                sortedArray[index++] = i;

        return sortedArray;
    }

    public static int[] sortArrayWRealNums(int[] arr) { // {6, 339, 12, 0, 13, -5}
        int[] arrayToSort = arr.clone();
        int[] sortedArr = new int[arr.length];

        for (int j = 0; j < sortedArr.length; j++) {
            int min = Integer.MAX_VALUE;
            int temp = 0;
            for (int i = 0; i < arrayToSort.length; i++) {
                if (arrayToSort[i] < min) {
                    min = arrayToSort[i];
                    sortedArr[j] = min;
                    temp = i;
                }
            }
            arrayToSort[temp] = Integer.MAX_VALUE;
        }

        return sortedArr;
    }

    public static int[] makeNumsAbsolute(int[] arrWRealNums) {
        for (int i = 0; i < arrWRealNums.length; i++) {
            if (arrWRealNums[i] < 0)
                arrWRealNums[i] = -arrWRealNums[i];
        }
        return arrWRealNums;
    }

    public static void showArray(int[] arr) {
        for (int i : arr)
            System.out.print(" "+i);
        System.out.println("\n");
    }

    public static int getMinDiff(int[] sortedArr) {
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < sortedArr.length; i += 2) {
            if (sortedArr[i] - sortedArr[i - 1] < minDiff)
                minDiff = sortedArr[i] - sortedArr[i - 1];
        }

        return minDiff;
    }

    public static int[] getNumsSeparatedByMinDiff(int[] sortedArr) {
        int[] numsSeparatedByMinDiff = new int[sortedArr.length];

        int counter = 0;
        for (int i = 1; i < sortedArr.length; i++) {
            if (sortedArr[i] - sortedArr[i - 1] == getMinDiff(sortedArr)) {
                numsSeparatedByMinDiff[i - 1] = sortedArr[i - 1];
                numsSeparatedByMinDiff[i] = sortedArr[i];
                counter++;
            }
        }

        int[] parsedArray = new int[counter * 2];
        int k = 0;
        int counterForRemovingTrailing0s = 0;
        for (int j : numsSeparatedByMinDiff) {
            if (j != 0) {
                parsedArray[k] = j;
                k++;
                counterForRemovingTrailing0s++;
            }
        }
        int[] arrayWithoutTrailing0s = new int[counterForRemovingTrailing0s];
        if (parsedArray[counter * 2 - 1] == 0) {
            for (int i = 0; i < counterForRemovingTrailing0s; i++)
                arrayWithoutTrailing0s[i] = parsedArray[i];
            return arrayWithoutTrailing0s;
        }

        return parsedArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 8, 2, 10, 5, 15, 20, 21, 30, 31};
        int[] arr2 = {3, 8, 30, 2, 20, 10, 5, 15, 21, 31};
        int[] arr3 = {6, 2, 4, 10};
        int[] arr4 = {6, 339, 12, 0, 13, -5};

//        showArray(sortArrayWPosInts(arr1));
//        showArray(sortArrayWPosInts(arr2));
//        showArray(sortArrayWPosInts(arr3));
//        System.out.println(getMinDiff(sortArrayWPosInts(arr1)));
//        System.out.println(getMinDiff(sortArrayWPosInts(arr3)));
//        showArray(sortArrayWRealNums(arr4));
//        showArray(makeNumsAbsolute(arr4));
//        System.out.println(getMinDiff(sortArrayWRealNums(arr4)));
        showArray(getNumsSeparatedByMinDiff(sortArrayWPosInts(arr1)));
//        showArray(getNumsSeparatedByMinDiff(sortArrayWPosInts(arr2)));
//        showArray(getNumsSeparatedByMinDiff(sortArrayWPosInts(arr3)));
//        showArray(getNumsSeparatedByMinDiff(sortArrayWRealNums(arr4)));
    }
}
