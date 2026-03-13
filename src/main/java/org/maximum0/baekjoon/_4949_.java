package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _4949_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if (input.equals(".")) break;

            Deque<Character> stack = new ArrayDeque<>();
            boolean valid = true;

            for (char c : input.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        valid = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        valid = false;
                        break;
                    }
                }
            }

            sb.append(valid && stack.isEmpty() ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }

}
