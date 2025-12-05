package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16713_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] acc = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());
            acc[i] = acc[i - 1] ^ input;
        }

        int result = 0;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            result ^= acc[end] ^ acc[start - 1];
        }

        System.out.println(result);
    }

}
