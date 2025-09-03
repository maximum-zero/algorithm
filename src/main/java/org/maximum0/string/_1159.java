package org.maximum0.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1159 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final String EMPTY_TEXT = "PREDAJA";
        final int MIN_COUNT = 5;

        int count = Integer.parseInt(br.readLine());

        int[] firstNameCount = new int[26];
        for (int i = 0; i < count; i++) {
            String name = br.readLine();
            firstNameCount[name.charAt(0) - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (firstNameCount[i] >= MIN_COUNT) {
                result.append((char)(i + 'a'));
            }
        }

        System.out.println(result.length() < 1 ? EMPTY_TEXT : result);
    }
}
