package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1213_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String name = br.readLine();

        int[] alphabetCounts = new int[26];
        for (char c : name.toCharArray()) {
            alphabetCounts[c - 'A']++;
        }

        int oddCount = 0;
        char middleWord = ' ';
        for (int i = 0; i < 26; i++) {
            if (alphabetCounts[i] % 2 == 1) {
                oddCount++;
                middleWord = (char)(i + 'A');
            }
        }

        if (oddCount > 1) {
            bw.write("I'm Sorry Hansoo");
        } else {
            StringBuilder result = new StringBuilder();
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alphabetCounts[i] / 2; j++) {
                    prefix.append((char) ('A' + i));
                }
            }

            result.append(prefix);
            if (oddCount > 0) {
                result.append(middleWord + "");
            }
            result.append(prefix.reverse());

            bw.write(result.toString());
        }
        bw.flush();
    }

}
