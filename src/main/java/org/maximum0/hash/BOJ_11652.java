package org.maximum0.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
[유형]
- Map (빈도수 카운팅)

[핵심]
- count 증가하면서 최대값 갱신
- 같은 경우 → 더 작은 값 선택

[주의]
- Long 범위 주의
- 2번 순회 대신 1번에 처리 가능

*/
public class BOJ_11652 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long result = Long.MAX_VALUE;
        int max = 0;

        Map<Long, Integer> countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(br.readLine());

            int count = countMap.getOrDefault(number, 0) + 1;
            countMap.put(number, count);

            if (count > max) {
                max = count;
                result = number;
            } else if (count == max) {
                result = Math.min(result, number);
            }
        }

        System.out.print(result);
    }
}