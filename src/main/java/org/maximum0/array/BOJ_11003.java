package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
[유형]
- 슬라이딩 윈도우 + 덱(Deque)

[핵심]
- 덱의 맨 앞은 항상 현재 구간의 최솟값을 유지함.
- 뒤에서 제거
  - 현재 값보다 큰 값을 제거 (앞으로 최솟값 될 가능성이 없음)
- 앞에서 제거
  - 윈도우 범위를 벗어난 값 제거

[주의]
- 값이 아닌 인덱스를 덱에 저장
- 작은 값이 들어오면 큰 값은 제거 (핵심 로직)

*/
public class BOJ_11003 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            // 뒤에서부터 제거 (현재 값보다 큰 값은 최솟값이 될 수 없음)
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                deque.pollLast();
            }

            // 현재 index 추가
            deque.offerLast(i);

            // 범위를 벗어난 값 제거 (맨 앞)
            if (deque.peekFirst() <= i - L) {
                deque.pollFirst();
            }

            // 최솟값 출력
            sb.append(arr[deque.peekFirst()]).append(" ");
        }

        System.out.print(sb);
    }

}
