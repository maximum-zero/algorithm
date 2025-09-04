package org.maximum0.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int days = Integer.parseInt(st.nextToken());
        final int times = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sum = new int[days];

        sum[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < days; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int maxSum = sum[times - 1];
        for (int i = times; i < days; i++) {
            int currentSum = sum[i] - sum[i - times];
            if (maxSum < currentSum) maxSum = currentSum;
        }

        System.out.println(maxSum);
    }
}
