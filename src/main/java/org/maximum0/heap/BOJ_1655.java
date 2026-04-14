package org.maximum0.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
[유형]
- PriorityQueue (Max Heap + Min Heap)

[핵심]
- maxHeap (왼쪽): 중앙값 포함, 작은 값들
- minHeap (오른쪽): 큰 값들

- 삽입 규칙
  → maxHeap.peek() 기준으로 분기

- 균형 유지
  → maxHeap.size() == minHeap.size() 또는 +1

- 중앙값
  → 항상 maxHeap.peek()

[주의]
- 두 힙의 "크기 균형" + "값 순서" 둘 다 유지해야 함
- 한쪽으로 치우치면 재조정 필요

*/
public class BOJ_1655 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();                            // 큰 값들
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());  // 작은 값들 + 중앙값

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            // 삽입
            if (maxHeap.isEmpty() || input <= maxHeap.peek()) {
                maxHeap.offer(input);
            } else {
                minHeap.offer(input);
            }

            // 개수 균형 맞추기
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // 중앙값 출력
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb);
    }

}
