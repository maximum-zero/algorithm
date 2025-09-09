package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9996_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        String[] splitPattern = pattern.split("\\*");
        int patternLength = splitPattern[0].length() + splitPattern[1].length();

        for (int i = 0; i < count; i++) {
            String text = br.readLine();
            boolean isCompare = false;

            if (patternLength <= text.length()) {
                if (text.startsWith(splitPattern[0]) && text.endsWith(splitPattern[1])) {
                    isCompare = true;
                }
            }

            System.out.println(isCompare ? "DA" : "NE");
        }
    }
}
