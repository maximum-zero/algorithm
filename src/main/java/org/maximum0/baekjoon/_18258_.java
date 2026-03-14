package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _18258_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String command = br.readLine();
            if (command.startsWith("push")) {
                int X = Integer.parseInt(command.substring(5));
                queue.offer(X);
            } else if (command.equals("pop")) {
                sb.append(!queue.isEmpty() ? queue.poll() : -1).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                sb.append(!queue.isEmpty() ? queue.peekFirst() : -1).append("\n");
            } else if (command.equals("back")) {
                sb.append(!queue.isEmpty() ? queue.peekLast() : -1).append("\n");
            }
        }
        System.out.println(sb);
    }

}
