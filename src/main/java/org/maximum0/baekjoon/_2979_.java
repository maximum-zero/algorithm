package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2979_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int BEE_COUNT = 3;
        final int CAR_COUNT = 3;
        final int MAX_PARK_TIME = 100;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] bee = new int[BEE_COUNT];
        for (int i = 0; i < BEE_COUNT; i++) {
            bee[i] = Integer.parseInt(st.nextToken());
        }

        int[] parking = new int[MAX_PARK_TIME];
        for (int i = 0; i < CAR_COUNT; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j < end; j++) {
                parking[j]++;
            }
        }

        int sum = Arrays.stream(parking).map(count -> calcBee(bee, count)).sum();
        System.out.println(sum);
    }

    private static int calcBee(int[] bee, int count) {
        int result = 0;
        if (count > 0) {
            result = bee[count - 1] * count;
        }
        return result;
    }
}
