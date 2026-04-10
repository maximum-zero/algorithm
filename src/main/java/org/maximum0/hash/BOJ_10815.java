package org.maximum0.hash;

/*
[문제 분석]
- 입력 크기: -10,000,000 <= N <= 10,000,000
- 자료 구조: 숫자
- 순서 중요: O
- 연속 구간: X
- 합 관련: X
- 경우의 수: O
- 음수 포함: X
- 기타 특징:

[알고리즘 선택]
- 후보
  1. Map
  2. Set
  3.

- 제거
  - Map

- 최종
  - Set

[사용 근거]
- 교집합 찾는 문제 -> set (key value 도 아님)
-

[결과]
성공 / 실패
원인
-
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
[유형]
- Set (존재 여부)

[핵심]
- contains() → O(1) 조회
- 반복 질의 처리

[주의]
- 교집합 문제와 혼동하지 않기 → 교집합(X) 존재 여부 확인(O)

*/
public class BOJ_10815 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> cards = new HashSet<>();
        for (int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (i != 0) sb.append(" ");
            sb.append(cards.contains(Integer.parseInt(st.nextToken())) ? "1" : "0");
        }

        System.out.print(sb);
    }

}
