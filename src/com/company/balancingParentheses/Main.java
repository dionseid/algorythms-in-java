package com.company.balancingParentheses;

public class Main {
    public static int getMin(String s) {
        int parenthesesNeeded = 0;

        if (1 <= s.length() && s.length() <= 100000) {
            /* Un iterador para encontrar el índice en donde el valor cambia,
            y comparar ese índice + 1 contra la longitud de la cadena dividida por ese punto */ // ❗ En caso de recibir un cadena desordenada, puedo sorteala
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i - 1)) return Math.abs(s.substring(0, i - 1).length() - s.substring(i).length() + 1);
            }
        }

        return parenthesesNeeded;
    }

    public static void main(String[] args) {
        System.out.println(getMin("(()))")); // 1
        System.out.println(getMin("((()))")); // 0
        System.out.println(getMin("()))")); // 2
        System.out.println(getMin("(())))))")); // 4
        System.out.println(getMin("((((((((((((((((((())))))")); // 13
    }
}
