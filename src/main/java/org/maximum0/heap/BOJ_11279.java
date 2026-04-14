package org.maximum0.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
[유형]
- PriorityQueue (최대 힙)

[핵심]
- 값 삽입 → pq.offer()
- 최대값 추출 → pq.poll()
- 비어있을 경우 0 출력
- 최대 힙 → reverseOrder()

[주의]
- 비어있을 때 poll() → 예외 → isEmpty 체크

*/
public class BOJ_11279 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            else pq.offer(number);
        }

        System.out.print(sb);
    }

}
