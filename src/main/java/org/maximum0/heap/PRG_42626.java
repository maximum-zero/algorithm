package org.maximum0.heap;

import java.util.PriorityQueue;

/*
[유형]
- 우선순위 큐 (Heap)

[핵심]
- 가장 작은 값 2개를 반복적으로 꺼내 섞는 문제
- 섞은 값 = 첫번째 + (두번째 * 2)
- 매번 최소값을 빠르게 꺼내기 위해 PriorityQueue 사용
- 최소값(pq.peek())이 K 이상이 될 때까지 반복

[주의]
- pq.size() < 2인데 조건을 만족 못하면 -1 반환
- 정렬로는 해결 불가 (매 반복마다 최소값 필요)
- pq.peek() 기준으로 반복 조건 설정

*/
public class PRG_42626 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{ 1, 2, 3, 9, 10, 12 }, 7));
    }

    private static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }

        int count = 0;
        while (!pq.isEmpty() && pq.peek() < K) {
            if (pq.size() < 2) return -1;

            int least = pq.poll();
            int secondLeast = pq.poll();

            int mixed = least + (secondLeast * 2);
            pq.offer(mixed);

            count++;
        }

        return count;
    }

}