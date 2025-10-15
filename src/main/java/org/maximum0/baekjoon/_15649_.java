package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _15649_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M;
    private static int[] selected;
    private static boolean[] used;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        used = new boolean[N + 1];

        tracking(0);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void tracking(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i]) continue;

            selected[k] = i;
            used[i] = true;

            tracking(k + 1);

            selected[k] = 0;
            used[i] = false;
        }
    }
}
