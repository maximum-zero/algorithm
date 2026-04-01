package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 슬라이딩 윈도우

[핵심]
- 길이 K의 고정 구간 합
- 초기 K개 합을 먼저 계산 -> 한 칸씩 이동하면서 최대값 갱신

[주의]
- 순차 입력 + 고정 크기 배열 사용 시 i % K 인덱스 관리

*/
public class BOJ_2559 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int sum = 0;

        st = new StringTokenizer(br.readLine());

        // 초기 슬라이딩 윈도우 설정
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int max = sum;

        for (int i = K; i < N; i++) {
            int index = i % K;

            // 제거
            sum -= arr[index];

            // 추가
            arr[index] = Integer.parseInt(st.nextToken());
            sum += arr[index];

            max = Math.max(max, sum);
        }

        System.out.print(max);
    }

}
