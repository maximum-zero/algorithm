package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 구간합 (문자 카운팅)

[핵심]
- 알파벳별 prefix sum 배열 생성
- prefix[c][i] = 0 ~ i-1까지 c의 개수
- 구간 [l, r] = prefix[c][r+1] - prefix[c][l]

[주의]
- 쿼리 전에 prefix 배열을 미리 생성 (O(N + Q))
- 문자열 index → prefix index 변환 시 +1 주의
- 알파벳 → index 변환 (c - 'a')
- 매 쿼리마다 반복문 돌면 시간초과

*/
public class BOJ_16139 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); // 입력 받은 문자열
        int[][] prefix = new int[26][input.length() + 1];
        for (int i = 0; i < input.length(); i++) {
            int cur = input.charAt(i) - 'a';

            for (int a = 0; a < 26; a++) {
                prefix[a][i + 1] = prefix[a][i];
            }

            // 해당하는 문자 증가
            prefix[cur][i + 1]++;
        }

        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());    // 질문

        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);          // 비교 알파벳
            int l = Integer.parseInt(st.nextToken());   // 시작 index
            int r = Integer.parseInt(st.nextToken());   // 종료 index

            int cur = a - 'a';
            int count = prefix[cur][r + 1] - prefix[cur][l];
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

}
