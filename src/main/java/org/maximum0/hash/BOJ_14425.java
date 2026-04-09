package org.maximum0.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
[유형]
- Set (존재 여부 / 포함 검사)

[핵심]
- 문자열 저장 → HashSet
- contains → O(1) 조회
- 카운트 증가

*/
public class BOJ_14425 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) count++;
        }

        System.out.print(count);
    }

}
