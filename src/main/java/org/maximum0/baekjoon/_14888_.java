package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _14888_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, max, min;
    private static int[] numbers, operators, selectedOperators;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operators = new int[5];
        selectedOperators = new int[N];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());;
        }

        tracking(0, numbers[0]);

        bw.write(max + "\n");
        bw.write(min + "");
        bw.flush();
    }

    private static int calculator(int operand1, int operator, int operand2) {
        if (operator == 1) {
            return operand1 + operand2;
        } else if (operator == 2) {
            return operand1 - operand2;
        } else if (operator == 3) {
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }

    private static void tracking(int k, int total) {
        if (k == N - 1) {
            max = Math.max(max, total);
            min = Math.min(min, total);
        }

        for (int operator = 1; operator <= 4; operator++) {
            if (operators[operator] > 0) {
                operators[operator]--;
                selectedOperators[k] = operator;

                tracking(k + 1, calculator(total, operator, numbers[k + 1]));

                operators[operator]++;
                selectedOperators[k] = 0;
            }
        }
    }
}
