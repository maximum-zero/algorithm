package org.maximum0.string;

import java.util.Scanner;

public class _1157_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char result = solve(input);
        System.out.println(result);
    }

    public static int[] getAlphabetCount(String input) {
        int[] count = new int[26];
        for (char i : input.toUpperCase().toCharArray()) {
            count[i - 'A']++;
        }
        return count;
    }

    public static char solve(String input) {
        int[] count = getAlphabetCount(input);

        int maxCount = 0;
        char answer = '?';
        for (int i = 0; i < count.length; i++) {
            if (maxCount < count[i]) {
                maxCount = count[i];
                answer = (char)(i + 'A');
            } else if (maxCount == count[i]) {
                answer = '?';
            }
        }

        return answer;
    }
}
