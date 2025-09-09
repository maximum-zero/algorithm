package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10988_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] text = br.readLine().toCharArray();

        boolean isCompare = true;
        for (int i = 0; i < text.length / 2; i++) {
            if (text[i] != text[text.length -1 - i]) {
                isCompare = false;
                break;
            }
        }

        System.out.println(isCompare ? 1 : 0);
    }
}
