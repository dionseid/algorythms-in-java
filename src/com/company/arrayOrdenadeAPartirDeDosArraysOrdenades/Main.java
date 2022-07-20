package com.company.arrayOrdenadeAPartirDeDosArraysOrdenades;

public class Main {

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] merge = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0, x;

        System.out.print("array 1: ");
        for (x = 0; x < arr1.length; x++)
            System.out.print(arr1[x] + " ");

        System.out.print("\narray 2: ");
        for (x = 0; x < arr2.length; x++)
            System.out.print(arr2[x] + " ");

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                merge[k++] = arr1[i++]; // Store first array element and increment first array index
            else
                merge[k++] = arr2[j++];
        }

        while (i < arr1.length)
            merge[k++] = arr1[i++];
        while (j < arr2.length)
            merge[k++] = arr2[j++];

        System.out.print("\nArray after merging: ");
        for (x = 0; x < arr1.length + arr2.length; x++)
            System.out.print(merge[x] + " ");

    }
}
