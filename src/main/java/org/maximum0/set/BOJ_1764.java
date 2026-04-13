package org.maximum0.set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
[유형]
- Set (교집합)
- 정렬 (TreeSet)

[핵심]
- HashSet으로 빠르게 contains
- 공통 요소만 TreeSet에 저장
- 자동 정렬

[주의]
- TreeSet을 조회용으로 쓰면 비효율

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
