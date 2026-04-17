package org.maximum0.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
[유형]
- 우선순위 큐 (Greedy + Scheduling)

[핵심]
- 요청시간 기준 정렬 후 순차 접근
- 현재 시간(time)까지 도착한 작업만 PQ에 추가
- PQ에서는 작업시간이 가장 짧은 작업 선택 (SJF)
- 처리 후 대기시간 = (현재시간 - 요청시간)

[주의]
- 전체 작업을 한 번에 PQ에 넣으면 안됨
- PQ가 비었으면 시간 점프 필요
- 한 번에 하나의 작업만 처리해야 함
- “현재 시점 기준 선택”이라는 개념이 핵심

*/
public class PRG_42627 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{ { 0, 3 }, { 1, 9 }, { 3, 5 } }));
    }

    private static int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int time = 0;
        int idx = 0;
        int total = 0;

        while (idx < jobs.length || !pq.isEmpty()) {
            // 현재 시간까지 들어온 작업 넣기
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }

            int[] job = pq.poll();
            time += job[1];
            total += (time - job[0]);
        }

        return total / jobs.length;
    }

}