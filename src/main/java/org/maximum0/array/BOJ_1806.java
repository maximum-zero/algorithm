package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 투포인터

[핵심]
- 연속 구간 합 문제, 음수 x -> 투포인터
- left/right 인덱스로 범위 조정

[주의]
- sum >= S 체크, sum -= numbers[left++] 순서 중요
- 길이 계산 시 인덱스 차이에 +1 필요

*/
public class BOJ_1806 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, sum = 0, length = Integer.MAX_VALUE;
        for (int right = 0; right < N; right++) {
            sum += numbers[right];

            // 합이 S보다 크거나 같으면 최소 길이 갱신 및 구간 조정 (범위 축소)
            while (sum >= S) {
                length = Math.min(length, right - left + 1);
                sum -= numbers[left++];
            }
        }

        if (length == Integer.MAX_VALUE) length = 0;
        System.out.print(length);
    }

}
