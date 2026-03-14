package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _1021_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());

        while(M > 0) {
            int number = Integer.parseInt(st.nextToken());

            int index = 0;
            for (int i : deque) {
                if (number == i) break;
                index++;
            }

            boolean moveRight = index > deque.size() / 2;

            while (deque.peek() != number) {
                if (!moveRight) {
                    deque.offerLast(deque.pollFirst());
                } else {
                    deque.offerFirst(deque.pollLast());
                }
                count++;
            }


            deque.poll();
            M--;
        }

        System.out.print(count);
    }

}
