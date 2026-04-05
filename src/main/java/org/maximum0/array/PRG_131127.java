package org.maximum0.array;

import java.util.HashMap;
import java.util.Map;

/*
[유형]
- 슬라이딩 윈도우 (고정 길이)
- HashMap (문자열 카운팅)

[핵심]
- 10일 동안의 상품 구성(window)과 원하는 상품(wantMap)을 비교
- window.equals(wantMap)로 개수까지 완전히 일치하는지 확인

[주의]
- 초기 10일 윈도우 먼저 구성 후 비교
- 제거 시 개수가 0이면 map에서 삭제 필요
- 단순 포함 여부가 아니라 "개수까지 정확히 일치"해야 함

*/
public class PRG_131127 {

    public static void main(String[] args) throws Exception {
        System.out.println(solution(new String[]{ "banana", "apple", "rice", "pork", "pot" }, new int[]{ 3, 2, 2, 2, 1 }, new String[]{ "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana" }));
        System.out.println(solution(new String[]{ "apple" }, new int[]{ 10 }, new String[]{ "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana" }));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> window = new HashMap<>();
        int result = 0;

        // 슬라이딩 윈도우 설정
        for (int i = 0; i < 10; i++) {
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }

        if (window.equals(wantMap)) result++;

        // 슬라이딩 윈도우
        for (int i = 10; i < discount.length; i++) {
            // 제거
            String remove = discount[i - 10];
            window.put(remove, window.get(remove) - 1);
            if (window.get(remove) == 0) {
                window.remove(remove);
            }

            // 추가
            String add = discount[i];
            window.put(add, window.getOrDefault(add, 0) + 1);

            if (window.equals(wantMap)) result++;
        }

        return result;
    }
}