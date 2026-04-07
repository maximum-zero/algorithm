package org.maximum0.solve;

/*
[문제 분석]
- 입력 크기: N <= 500_000
- 자료 구조: 문자
- 순서 중요: X
- 연속 구간: X
- 합 관련: X
- 경우의 수: X
- 음수 포함: X
- 기타 특징:

[알고리즘 선택]
- 후보
  1. Map
  2. Set
  3.

- 제거
  - Map : Key Value까지 필요 없어 보임. 중복이 없다고는 하지만, Set을 통해 조금 더 강화

- 최종
  - Set -> TreeSet (순번)

[사용 근거]
- 듣도 못한 사람과 보도 못한 사람의 중복의 개수와 목록 출력 (최초 듣도 못한 사람을 등록 후에 보도 못한 사람에서 있는지 확인)
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
import java.util.TreeSet;

/*
[유형]
-

[핵심]
-

[주의]
-
*/
public class BOJ_1764 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수

        Set<String> unheard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        Set<String> result = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                result.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size());

        for (String name : result) {
            sb.append("\n").append(name);
        }
        System.out.print(sb);
    }

}
