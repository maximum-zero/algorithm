package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 슬라이딩 윈도우

[핵심]
- 초기 X 구간 합 먼저 계산 후 한 칸씩 이동
- total += arr[i], total -= arr[i - X]
- 최대값 갱신 + 동일 최대값 카운트

[주의]
- 초기 윈도우 먼저 계산 후 슬라이딩 시작
- count = 1은 “초기 구간 포함” 의미 → 초기 max 설정과 맞춰야 함
- max == 0이면 "SAD" 출력 (count 출력 X)
- 입력을 순차 처리할 경우 제거 대상 인덱스 관리 주의 (i % X)

*/
public class BOJ_21921 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[X];
        int total = 0;

        // 초기 슬라이딩 윈도우 설정
        for (int i = 0; i < X; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        // 초기값 설정
        int max = total;
        int count = 1;

        // 슬라이딩 윈도우
        for (int i = X; i < N; i++) {
            int index = i % X;

            total -= arr[index];

            int visit = Integer.parseInt(st.nextToken());
            arr[index] = visit;
            total += visit;

            if (total > max) {
                max = total;
                count = 1;
            } else if (total == max) {
                count++;
            }
        }

        if (max > 0) {
            System.out.println(max);
            System.out.print(count);
        } else {
            System.out.print("SAD");
        }
    }
}