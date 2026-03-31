package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 슬라이딩 윈도우 + 상태 유지

[핵심]
- 길이 P의 고정 윈도우
- A, C, G, T 각각의 최소 개수 조건을 만족하는지 확인
- 매번 전체 검사(isValid) 대신 "조건 만족 개수(needCount)"로 관리

[주의]
- needs[i] == 0 인 경우, 초기부터 만족 상태로 처리해야 함
- remove 시: 감소 전에 조건 만족 여부 확인
- add 시: 증가 후 조건 만족 여부 확인

*/
public class BOJ_12891 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        int[] needs = new int[4];   // A, C, G, T
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            needs[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[4];
        int needCount = 0;

        // needs[i] == 0이면 이미 만족 상태
        for (int i = 0; i < 4; i++) {
            if (needs[i] == 0) needCount++;
        }

        // 초기 슬라이딩 윈도우 설정 (P만큼)
        for (int i = 0; i < P; i++) {
            int index = getIndex(arr[i]);
            count[index]++;
            if (count[index] == needs[index]) needCount++;
        }

        int result = (needCount == 4) ? 1 : 0;

        // 슬라이딩 윈도우
        for (int i = 1; i <= S - P; i++) {
            int removeIndex = getIndex(arr[i - 1]);
            if (count[removeIndex] == needs[removeIndex]) needCount--;
            count[removeIndex]--;

            int addIndex = getIndex(arr[i + P - 1]);
            count[addIndex]++;
            if (count[addIndex] == needs[addIndex]) needCount++;

            if (needCount == 4) result++;
        }
        System.out.print(result);
    }

    static int getIndex(char c) {
        if (c == 'A') return 0;
        else if (c == 'C') return 1;
        else if (c == 'G') return 2;
        return 3;
    }

}
