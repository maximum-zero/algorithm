package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10431_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int p = Integer.parseInt(br.readLine());
        solve(p);
    }

    public static void solve(int p) throws IOException {
        final int SIZE = 20;

        while (p-- > 0) {
            int[] height = new int[SIZE];

            // 0. 입력을 받는다 -> O(P)
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for (int i = 0; i < SIZE; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            // 1. 앞에 자기보다 키가 큰 학생이 얼마나 존재하는지 계산한다. -> O(N^2)
            int count = 0;
            for (int i = 1; i < SIZE; i++) {
                for (int j = 0; j < i; j++) {
                    if (height[j] > height[i]) {
                        count++;
                    }
                }
            }

            // SIZE 가 20이라는 고정 값이기에 O(P) * O(1) = O(P)가 되었지만
            // 사이즈가 N 개라면, 시간 복잡도는 O(P) * O(N^2)이 된다.

            System.out.println(t + " " + count);
        }
    }
}
