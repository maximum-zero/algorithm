package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 슬라이딩 윈도우 + 상태 유지 + 링 버퍼

[핵심]
- 전체 배열 없이 k 크기 윈도우만 유지
- count: 배열로 초밥 개수 관리
- kindCount: 서로 다른 종류 개수 유지
- 원형 처리는 처음 k개를 따로 저장해서 해결

[주의]
- i >= k → 제거 시작
- i >= k - 1 → 결과 계산 시작
- N + k - 1 까지 순회 (원형 처리)

*/
public class BOJ_15961 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 접시 수
        int d = Integer.parseInt(st.nextToken());   // 초밥 종류
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        int[] window = new int[k];
        int[] init = new int[k];
        int[] count = new int[d + 1];
        int kindCount = 0;
        int max = 0;

        for (int i = 0; i < N + k - 1; i++) {
            int cur;

            if (i < N) {
                cur = Integer.parseInt(br.readLine());
                if (i < k) init[i] = cur; // 처음 k개 저장
            } else {
                cur = init[i - N]; // 원형 배열
            }

            int idx = i % k;

            // 제거
            if (i >= k) {
                int prev = window[idx];
                count[prev]--;
                if (count[prev] == 0) kindCount--;
            }

            // 추가
            window[idx] = cur;
            if (count[cur] == 0) kindCount++;
            count[cur]++;

            // 결과 계산
            if (i >= k - 1) {
                int current = (count[c] == 0) ? kindCount + 1 : kindCount;
                max = Math.max(max, current);
            }
        }
        System.out.print(max);
    }
}