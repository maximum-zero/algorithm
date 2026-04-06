package org.maximum0.array;

import java.util.Arrays;

/*
[유형]
- 슬라이딩 윈도우 (변형)

[핵심]
- 두 개의 Queue → 하나의 배열로 확장
- queue1 구간 → 현재 window
- sum < target → right++ (값 추가)
- sum > target → left++ (값 제거)

[주의]
- 초기 sum → queue1 전체 합 (window)
- right 시작 → queue1.length
- 최대 이동 횟수 제한 필요

*/
public class PRG_118667 {

    public static void main(String[] args) throws Exception {
        int result1 = solution(new int[]{ 3, 2, 7, 2 }, new int[]{ 4, 6, 5, 1 });
        System.out.println(result1);

        int result2 = solution(new int[]{ 1, 2, 1, 2 }, new int[]{ 1, 10, 1, 2 });
        System.out.println(result2);

        int result3 = solution(new int[]{ 1, 1 }, new int[]{ 1, 5 });
        System.out.println(result3);
    }

    public static int solution(int[] queue1, int[] queue2) {
        long sum = 0;
        for (int n : queue1) sum += n;

        long total = sum;
        for (int n : queue2) total += n;

        // 전체 합이 홀수면 불가능
        if (total % 2 != 0) {
            return -1;
        }

        // 배열 확장 (queue1 + queue2)
        int n = queue1.length;
        int[] arr = new int[n * 2];
        System.arraycopy(queue1, 0, arr, 0, n);
        System.arraycopy(queue2, 0, arr, n, n);

        long target = total / 2;
        int left = 0;
        int right = n;
        int count = 0;

        // 최대 이동 횟수 제한
        while (left <= right && right < n * 2) {
            if (sum == target) return count;

            if (sum > target) {
                sum -= arr[left];
                left++;
            } else {
                sum += arr[right];
                right++;
            }
            count++;
        }

        return -1;
    }

}
