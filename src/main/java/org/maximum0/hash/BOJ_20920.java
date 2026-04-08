package org.maximum0.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/*
[유형]
- HashMap (빈도수 카운팅)
- 정렬 (Comparator)

[핵심]
- 단어 → 등장 횟수 (Map: 상태 관리)
- 조건(빈도수, 길이, 사전순) → 정렬 기준으로 변환
- 필터링(길이 < M) → 입력 단계에서 처리
- 사전순 비교는 compareTo 사용 (문자열 전체 비교)

[주의]
- 문자열 정렬에서 char 단위 비교 X
- 정렬 기준 여러 개일 때 "순서" 틀리면 바로 오답
- Map 문제는 "왜 Map 인지" 항상 설명 가능해야 함

*/
public class BOJ_20920 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;    // M자 이하는 생략

            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        List<Entry<String, Integer>> list = new ArrayList<>(countMap.entrySet());
        list.sort((w1, w2) -> {
            // 빈도수
            int compare = w2.getValue() - w1.getValue();
            if (compare != 0) return compare;

            // 길이
            compare = w2.getKey().length() - w1.getKey().length();
            if (compare != 0) return compare;

            // 사전순
            return w1.getKey().compareTo(w2.getKey());
        });

        // 출력
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append("\n");
        }

        System.out.println(sb);
    }

}
