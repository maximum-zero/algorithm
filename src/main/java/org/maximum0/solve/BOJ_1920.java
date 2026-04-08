package org.maximum0.solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[유형]
- 이분탐색 (존재 여부)

[핵심]
- 정렬 후 탐색
- mid 기준으로 절반 제거
- left <= right 조건

[주의]
- 이분탐색 + 선형탐색 섞어서 사용하면 안 됨
- right 범위 설정 (length vs length - 1) 구분

*/
public class BOJ_1920 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            boolean result = search(arr, target);

            if (i != 0) sb.append("\n");
            sb.append(result ? "1" : "0");
        }
        System.out.print(sb);
    }

    private static boolean search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

}
