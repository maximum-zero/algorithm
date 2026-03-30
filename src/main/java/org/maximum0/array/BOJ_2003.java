package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 투포인터

[핵심]
- 연속 구간 합 문제, 음수 x -> 투포인터
- left/right 구간 조정 및 단순 카운트

[주의]
- 음수가 있으면 투포인터 불가

*/
public class BOJ_2003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < N; right++) {
            sum += numbers[right];

            // 합이 M보다 큰 경우 구간 조정 (범위 축소)
            while (sum > M) {
                sum -= numbers[left++];
            }

            if (sum == M) {
                count++;
            }
        }

        System.out.print(count);
    }

}
