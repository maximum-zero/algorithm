package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 구간합

[핵심]
- 연속 구간의 합 문제, 음수 x -> 투 포인터
- 특정 조건(count, size)가 없는 단순 합 조회 -> 투 포인터 x / 구간합 o

[주의]
- 구간합 배열은 1 - indexed
- start/end 처리 시 -1 고려 불필요

*/
public class BOJ_11659 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        prefixSum[0] = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            prefixSum[i + 1] = prefixSum[i] + number;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(prefixSum[end] - prefixSum[start - 1]).append("\n");
        }

        System.out.print(sb);
    }

}
