package com.company.balancingParentheses;

public class SimplifiedVersion {
    static int getMin(String s) {
        int counter = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') counter++;
            else if (ch == ')') counter--;
        }

        return Math.abs(counter);
    }

    public static void main(String[] args) {
        System.out.println(getMin("(()))")); // 1
        System.out.println(getMin("((()))")); // 0
        System.out.println(getMin("()))")); // 2
        System.out.println(getMin("(())))))")); // 4
        System.out.println(getMin("((((((((((((((((((())))))")); // 13
    }
}
