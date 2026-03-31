package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 구간합 + 나머지 카운트 (prefixSum % M)

[핵심]
- prefixSum[i] % M 값이 이전에 나온 동일한 나머지와 같으면
  그 구간은 M으로 나누어 떨어짐
- 나머지 배열을 활용해 O(N) 처리 가능

[주의]
- prefixSum 합이 커질 수 있으므로 long 사용
- 나머지 계산 시 음수 값 발생 가능, 음수 포함 문제면 처리 필요
- 나머지 배열 초기값 remainCount[0] = 1 필수

*/
public class BOJ_10986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] prefixSum = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            long number = Long.parseLong(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + number;
        }

        int[] remainCount = new int[M];
        remainCount[0] = 1; // 0~i 구간 합이 M으로 나누어떨어지는 경우 포함

        long totalCount = 0;
        for (int i = 1; i <= N; i++) {
            int remain = (int)(prefixSum[i] % M);
            totalCount += remainCount[remain];
            remainCount[remain]++;
        }

        System.out.print(totalCount);
    }

}
