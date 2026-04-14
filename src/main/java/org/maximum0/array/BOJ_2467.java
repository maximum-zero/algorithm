package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[유형]
- 투포인터

[핵심]
- 양 끝에서 시작 (left, right)
- 합이 0에 가까운 값 찾기
- sum > 0 → right--
- sum < 0 → left++
- 최솟값 갱신 → Math.abs()

[주의]
- 입력이 한 줄에 주어짐 (split 필요)
- 배열은 이미 오름차순 (정렬 불필요)
- 종료 조건: sum == 0

*/
public class BOJ_2467 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        int min = arr[left];
        int max = arr[right];
        int result = min + max;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(result)) {
                result = sum;

                min = arr[left];
                max = arr[right];
            }

            if (sum == 0) break;

            if (sum > 0) right--;
            else left++;
        }

        System.out.print(min + " " + max);
    }

}
