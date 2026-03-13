package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _1874_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        boolean isValid = true;
        int N = Integer.parseInt(br.readLine());
        int pos = 1;
        while (N-- > 0) {
            int number = Integer.parseInt(br.readLine());

            while (pos <= number) {
                stack.push(pos);
                sb.append("+").append("\n");
                pos++;
            }

            if (!stack.isEmpty() && stack.peek() == number) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                isValid = false;
                break;
            }
        }

        System.out.print(isValid ? sb : "NO");
    }

}
