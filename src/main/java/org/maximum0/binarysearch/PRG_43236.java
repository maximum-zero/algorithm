package org.maximum0.binarysearch;

import java.util.Arrays;

/*
[유형]
- 이분탐색 (Parametric Search)

[핵심]
- mid(최소 거리)를 기준으로 가능한지 검사
- 거리 부족한 바위 제거 → 최소 제거 개수 계산
- remove <= n → 가능
- 가능하면 더 큰 거리 탐색 (left 증가)

[주의]
- prev → “마지막으로 선택된 위치”
- 마지막 (distance - prev) 체크 필수
- 정답은 right → "마지막 가능한 값"

*/
public class PRG_43236 {

    public static void main(String[] args) {
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    private static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canProcess(distance, rocks, n, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private static boolean canProcess(int distance, int[] rocks, int n, int mid) {
        int prev = 0;
        int remove = 0;

        for (int rock : rocks) {
            if ((rock - prev) < mid) remove++;
            else prev = rock;

            if (remove > n) return false;
        }

        if ((distance - prev) < mid) remove++;

        return remove <= n;
    }

}
