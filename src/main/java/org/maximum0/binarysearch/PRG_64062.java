package org.maximum0.binarysearch;

/*
[유형]
- 이분탐색 (Parametric Search)

[핵심]
- mid = 건널 수 있는 사람 수
- stone < mid → 못 밟는 돌
- 연속 k개 못 밟으면 실패
- 가능하면 더 큰 값 탐색

[주의]
- while (left <= right)
- answer 따로 관리
- 연속 count 관리 중요

*/
public class PRG_64062 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{ 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 }, 3));
    }

    private static int solution(int[] stones, int k) {
        int left = 1;
        int right = getMax(stones);
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isCheck(stones, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static boolean isCheck(int[] stones, int k, int mid) {
        int count = 0;

        for (int stone : stones) {
            if (stone < mid) count++;
            else count = 0;

            if (count >= k) return false;
        }

        return true;
    }

    private static int getMax(int[] stones) {
        int max = 0;
        for (int stone : stones) {
            max = Math.max(max, stone);
        }
        return max;
    }

}