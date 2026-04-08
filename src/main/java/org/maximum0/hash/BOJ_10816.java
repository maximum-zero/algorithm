package org.maximum0.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
[유형]
- HashMap (빈도수 카운팅)
- 이분탐색 (대안)

[핵심]
- 숫자 → 등장 횟수 저장 (Map)
- O(N + M) 해결

[주의]
- 동일 문제를 이분탐색으로도 풀 수 있음
- 상황에 따라 자료구조 선택 필요

*/
public class BOJ_10816 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (i > 0) sb.append(" ");
            sb.append(map.getOrDefault(input, 0));
        }

        System.out.print(sb);
    }

}
