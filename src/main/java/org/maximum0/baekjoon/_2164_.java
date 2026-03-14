package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _2164_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Deque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.print(queue.poll());
    }

}
