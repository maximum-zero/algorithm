package org.maximum0.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[유형]
- 투포인터

[핵심]
- 정렬 후 양쪽 끝에서 시작 (left, right)
- 매 순간 현재 합을 기준으로 판단
- sum > 0 → right--
- sum < 0 → left++
- 최솟값 갱신 → Math.abs(sum)

[주의]
- 반드시 현재 상태를 먼저 평가하고 이동해야 함
- 초기 (left, right) 조합 포함해야 함

*/
public class BOJ_2470 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        int min = Math.min(arr[left], arr[right]);
        int max = Math.max(arr[left], arr[right]);
        int result = max + min;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(result) > Math.abs(sum)) {
                min = arr[left];
                max = arr[right];

                result = max + min;
            }

            if (sum == 0) break;
            else if (sum > 0) right--;
            else left++;
        }

        System.out.print(min + " " + max);

    }

}
