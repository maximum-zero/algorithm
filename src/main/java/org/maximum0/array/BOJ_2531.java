package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 슬라이딩 윈도우

[핵심]
- 고정 길이 k 윈도우
- count 배열로 초밥 개수 관리
- unique: 현재 서로 다른 종류 개수 유지
- 쿠폰 초밥 c가 없으면 +1

[주의]
- 원형 배열 → (index % N) 처리
- count[arr[left]] 감소 후 0이면 unique 감소

*/
public class BOJ_2531 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 접시의 수
        int d = Integer.parseInt(st.nextToken());   // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int kindCount = 0;
        // 초기 설정 (k 만큼)
        for (int i = 0; i < k; i++) {
            if (count[arr[i]] == 0) {
                kindCount++;
            }
            count[arr[i]]++;
        }
        int max = (count[c] == 0) ? kindCount + 1 : kindCount;

        // 슬라이딩 윈도우
        for (int i = 1; i < N; i++) {
            int remove = arr[i - 1];
            int add = arr[(i + k - 1) % N]; // 원형 배열 (N-k ... 0 ... N)

            count[remove]--;
            if (count[remove] == 0) kindCount--;

            if (count[add] == 0) kindCount++;
            count[add]++;

            int current = (count[c] == 0) ? kindCount + 1 : kindCount;
            max = Math.max(max, current);
        }
        System.out.print(max);
    }
}