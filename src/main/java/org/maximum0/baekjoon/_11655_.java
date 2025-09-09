package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11655_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] text = br.readLine().toCharArray();

        StringBuilder encText = new StringBuilder();
        for (char c : text) {
            encText.append(encRot13(c));
        }

        System.out.println(encText);
    }

    private static char encRot13(char value) {
        final int KEY = 13;

        if (value >= 'A' && value <= 'Z') {
            return (char) ((value - 'A' + KEY) % 26 + 'A');
        } else if (value >= 'a' && value <= 'z') {
            return (char) ((value - 'a' + KEY) % 26 + 'a');
        }
        return value;
    }
}
