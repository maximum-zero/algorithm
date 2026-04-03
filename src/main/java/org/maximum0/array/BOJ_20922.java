package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 슬라이딩 윈도우 (투포인터 기반)

[핵심]
- left / right 포인터로 구간 유지
- count 배열로 각 숫자의 개수 관리
- 특정 숫자가 K개 초과하면 left 이동으로 상태 복구

[주의]
- remove → move 순서 중요 (count 감소 후 left 증가)
- 조건은 “현재 추가한 값(arr[right]) 기준으로만 체크”
- 배열 범위 고려하여 count 배열 크기 설정

*/
public class BOJ_20922 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 입력 처리
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[200_001];
        int max = 0;

        int left = 0;
        for (int right = 0; right < N; right++) {
            count[arr[right]]++;

            while (count[arr[right]] > K) {
                count[arr[left]]--;

                left++;
            }

            max = Math.max(max, (right - left + 1));
        }

        System.out.print(max);
    }

}
