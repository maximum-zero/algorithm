package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10808_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] text = br.readLine().toCharArray();

        int[] count = new int[26];
        for (char value : text) {
            count[value - 'a']++;
        }

        for (int c : count) {
            System.out.print(c + " ");
        }
    }

}
