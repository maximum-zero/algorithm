package org.maximum0.baekjoon;

import java.util.Scanner;

public class _1919_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String input2 = sc.next();

        int result = solve(input, input2);
        System.out.println(result);
    }

    public static int[] getAlphabetCount(String input) {
        int[] count = new int[26];
        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i) - 'a']++;
        }
        return count;
    }

    public static int solve(String input, String input2) {
        int[] count = getAlphabetCount(input);
        int[] count2 = getAlphabetCount(input2);

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(count[i] - count2[i]);
        }

        return answer;
    }
}
