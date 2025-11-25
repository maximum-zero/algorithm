package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _18870_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] originNumber = new int[N];
        int[] sortedNumber = new int[N];
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            originNumber[i] = number;
            sortedNumber[i] = number;
        }
        Arrays.sort(sortedNumber);

        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 0;
        for (int number : sortedNumber) {
            if (!ranks.containsKey(number)) {
                ranks.put(number, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int number : originNumber) {
            sb.append(ranks.get(number)).append(" ");
        }
        System.out.println(sb);
    }
}
