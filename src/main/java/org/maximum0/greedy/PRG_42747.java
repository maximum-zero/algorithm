package org.maximum0.greedy;

import java.util.Arrays;

/*
[유형]
- 정렬 (Greedy)

[핵심]
- h-index = h번 이상 인용된 논문이 h편 이상 있는 최대 h
- 정렬 후 “논문 개수 vs 인용 수” 비교
- citations[i] ≥ (n - i) → 조건 만족
- 처음 만족하는 (n - i)가 정답

[주의]
- 값 자체가 아니라 “개수” 기준 문제
- index 기준으로 h 계산하면 틀리기 쉬움
- 내림차순(i+1) / 오름차순(n-i) 개념 혼동 주의

*/
public class PRG_42747 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{ 3, 0, 6, 1, 5 }));
    }

    private static int solution(int[] citations) {
        Arrays.sort(citations);

        int N = citations.length;
        for (int i = 0; i < N; i++) {
            int h = N - i;

            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }

}