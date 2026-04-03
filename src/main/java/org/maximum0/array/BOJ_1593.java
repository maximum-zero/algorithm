package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 슬라이딩 윈도우 + 문자열 카운팅 + diff 방식

[핵심]
- diff: 두 배열이 다른 문자 개수
- diff == 0 → 완전히 동일 (아나그램)

[주의]
- 대소문자 구분 → 52개 문자 처리 필요

*/
public class BOJ_1593 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());   // W의 길이
        int s = Integer.parseInt(st.nextToken());   // S의 길이

        String W = br.readLine();   // 찾고자하는 단어
        String S = br.readLine();   // 벽화에서 추출한 문자열

        int[] countW = new int[52];
        int[] countS = new int[52];

        // W 카운팅
        for (int i = 0; i < g; i++) {
            countW[getIndex(W.charAt(i))]++;
        }

        // 초기 슬라이딩 윈도우 설정
        for (int i = 0; i < g; i++) {
            countS[getIndex(S.charAt(i))]++;
        }

        // 다른 문자 개수 계산
        int diff = 0;
        for (int i = 0; i < 52; i++) {
            if (countW[i] != countS[i]) diff++;
        }

        int result = (diff == 0) ? 1 : 0;

        for (int i = g; i < s; i++) {
            // 제거
            int removeIndex = getIndex(S.charAt(i - g));
            if (countW[removeIndex] == countS[removeIndex]) diff++;
            countS[removeIndex]--;
            if (countW[removeIndex] == countS[removeIndex]) diff--;

            // 추가
            int addIndex = getIndex(S.charAt(i));
            if (countW[addIndex] == countS[addIndex]) diff++;
            countS[addIndex]++;
            if (countW[addIndex] == countS[addIndex]) diff--;

            if (diff == 0) result++;
        }

        System.out.print(result);
    }

    // (A-Z: 0 ~ 25, a-z: 26~51)
    static int getIndex(char c) {
        if (c >= 'a') return c - 'a' + 26;
        return c - 'A';
    }
}