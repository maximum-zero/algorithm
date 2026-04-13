package org.maximum0.set;

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
