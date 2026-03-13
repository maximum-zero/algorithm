package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _10773_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();

        int sum = 0;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0 && !stack.isEmpty()) {
                sum -= stack.pop();
            } else {
                sum += number;
                stack.push(number);
            }
        }
        System.out.print(sum);
    }

}
