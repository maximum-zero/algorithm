package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _9012_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean valid = true;

            for (char c : br.readLine().toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            sb.append(valid && stack.isEmpty() ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

}
