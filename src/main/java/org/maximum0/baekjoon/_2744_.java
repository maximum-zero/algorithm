package org.maximum0.baekjoon;

import java.util.Scanner;

public class _2744_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        String result = solve(input);
        System.out.println(result);
    }

    public static String solve(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                sb.append((char)(ch + 'a' - 'A'));
            else
                sb.append((char)(ch + 'A' - 'a'));
        }
        return sb.toString();
    }
}
