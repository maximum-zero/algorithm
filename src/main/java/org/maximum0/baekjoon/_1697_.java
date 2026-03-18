package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[100_001];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) break;

            int[] next = new int[] { cur - 1, cur + 1, cur * 2 };
            for (int n : next) {
                if (n < 0 || n > 100_000 || dist[n] != - 1) continue;

                dist[n] = dist[cur] + 1;
                queue.offer(n);
            }
        }

        System.out.print(dist[K]);
    }

}
