package org.maximum0.baekjoon;

import java.io.*;

public class _10989_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int MAX_NUMBER = 10000;
        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[MAX_NUMBER + 1];
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            cnt[value]++;
        }

        for (int i = 1; i <= MAX_NUMBER; i++) {
            while(cnt[i]-- > 0) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
    }
}
