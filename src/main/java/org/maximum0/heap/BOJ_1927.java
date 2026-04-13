package org.maximum0.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
[유형]
- PriorityQueue (최소 힙)

[핵심]
- offer() → 값 추가
- poll() → 최소값 제거 및 반환
- 자동 정렬 상태 유지

[주의]
- 비어있을 때 poll() → 예외 → isEmpty 체크

*/
public class BOJ_1927 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.offer(number);
            }
        }

        System.out.print(sb);
    }

}
