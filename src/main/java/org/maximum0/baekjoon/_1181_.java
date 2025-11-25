package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1181_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(br.readLine());

        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        words.sort((w1, w2) -> {
            if (w1.length() == w2.length()) return w1.compareTo(w2);
            return w1.length() - w2.length();
        });

        StringBuilder sb = new StringBuilder();
        sb.append(words.get(0)).append("\n");
        for (int i = 1; i < N; i++) {
            if (!words.get(i).equals(words.get(i - 1))) {
                sb.append(words.get(i)).append("\n");
            }
        }

        System.out.println(sb);
    }

}
