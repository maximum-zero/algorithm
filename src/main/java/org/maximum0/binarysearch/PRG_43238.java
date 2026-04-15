package org.maximum0.binarysearch;

/*
[유형]
- 이분탐색 (Parametric Search)

[핵심]
- mid(시간)를 기준으로 처리 가능한 인원 계산
- total >= n → 가능
- 가능하면 범위를 줄여 최소값 탐색
- 단조성: 시간 ↑ → 처리량 ↑

[주의]
- mid: 정답이 아니라 검증 값
- right: 최악의 경우로 설정 (maxTime * n)

*/
public class PRG_43238 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    private static long solution(int n, int[] times) {

        long left = 1;
        long right = getMax(times) * (long) n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canProcess(n, times, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private static boolean canProcess(int n, int[] times, long timeLimit) {
        long total = 0;

        for (int t : times) {
            total += timeLimit / t;

            if (total >= n) return true;
        }

        return false;
    }

    private static long getMax(int[] arr) {
        long max = 0;
        for (int v : arr) max = Math.max(max, v);
        return max;
    }

}
