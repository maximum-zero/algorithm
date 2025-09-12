package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11068_ {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int MIN = 2;
        final int MAX = 64;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int number = Integer.parseInt(br.readLine());

            boolean isFind = false;
            for (int base = MIN; base <= MAX; base++) {
                if (isPalindrome(number, base)) {
                    isFind = true;
                    break;
                }
            }
            bw.write((isFind ? "1" : "0") + "\n");
        }
        bw.flush();
    }

    private static boolean isPalindrome(int number, int base) {
        final StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int remainder = number % base;
            number = number / base;

            if (remainder < 10) {
                sb.append(remainder);
            } else {
                sb.append((char)(remainder - 10 + 'A'));
            }
        }

        int start = 0;
        int end = sb.length() - 1;
        while (start < end) {
            if (sb.charAt(start) != sb.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
