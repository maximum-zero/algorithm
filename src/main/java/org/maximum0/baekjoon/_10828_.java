package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _10828_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                Integer X = Integer.parseInt(command.substring(5));
                stack.push(X);
            } else if (command.startsWith("pop")) {
                sb.append(!stack.isEmpty() ? stack.pop() : "-1").append("\n");
            } else if (command.startsWith("size")) {
                sb.append(stack.size() + "\n");
            } else if (command.startsWith("empty")) {
                sb.append(stack.isEmpty() ? "1" : "0").append("\n");
            } else if (command.startsWith("top")) {
                sb.append(!stack.isEmpty() ? stack.getFirst() : "-1").append("\n");
            }
        }
        System.out.println(sb);
    }

}
