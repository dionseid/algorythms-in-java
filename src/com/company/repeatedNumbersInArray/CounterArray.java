package com.company.repeatedNumbersInArray;

public class CounterArray {
    public static void main(String[] args) {
        int A[] = { 1, 6, 4, 6, 4, 8, 2, 4, 1, 1 };

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
        }
        System.out.println("max --» " + max);

        int B[] = new int[max + 1];
        for (int i = 0; i < A.length; i++) {
            // increment in array B for every integer
            // in A.
            B[A[i]]++; /* [0,3,1,0,3,0,2,0,1] // Valor del elemento de A se corresponde con un número de índice en B.
            // Si un elemento de A aparece repetido, entonces B suma valor al elemento 0 que originalmente ocupa su índice */
        }

        for (int i = 0; i <= max; i++) {
            // output only if element is more than
            // 1 time in array A.
            if (B[i] > 1)
                System.out.println(i + "-" + B[i]);
        }
    }
}
