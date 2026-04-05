package org.maximum0.array;

/*
[유형]
- 투포인터

[핵심]
- left / right 포인터로 구간 유지
- 최소 길이 갱신

[주의]
- 길이 계산 실수 → (right - left + 1)
- 최소 길이 문제인지 확인

*/
public class PRG_178870 {

    public static void main(String[] args) throws Exception {
        int[] result = solution(new int[] { 1, 2, 3, 4, 5 }, 7);
        System.out.println(result[0] + " " + result[1]);

        int[] result2 = solution(new int[] { 1, 1, 1, 2, 3, 4, 5 }, 5);
        System.out.println(result2[0] + " " + result2[1]);

        int[] result3 = solution(new int[] { 2, 2, 2, 2, 2 }, 6);
        System.out.println(result3[0] + " " + result3[1]);
    }

    public static int[] solution(int[] sequence, int k) {
        int left = 0;
        int sum = 0;

        int min = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            // 합이 k보다 크면 감소
            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            // 합이 k인 경우
            if (sum == k) {
                int len = right - left + 1;

                if (len < min) {
                    min = len;
                    result[0] = left;
                    result[1] = right;
                }
            }
        }

        return result;
    }

}
