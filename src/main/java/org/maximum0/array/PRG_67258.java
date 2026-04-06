package org.maximum0.array;

import java.util.HashMap;
import java.util.Map;

/*
[유형]
- 슬라이딩 윈도우 (가변 길이)
- HashMap (문자열 카운팅)

[핵심]
- 모든 종류 포함 → map.size() == 전체 종류 수
- right 확장 → 상태 유지
- 조건 만족 시 left-- → 최소 구간 탐색
- “조건 만족 → 끝까지 줄이기”가 핵심

[주의]
- 길이 계산 → right - left + 1
- 조건 만족 시 break 금지 (끝까지 줄여야 함)
- count == 0 → map.remove()
- 정답은 1-based index

*/
public class PRG_67258 {

    public static void main(String[] args) throws Exception {
        // TODO
        int[] result1 = solution(new String[]{ "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" });
        System.out.println(result1[0] + ", " + result1[1]);

        int[] result2 = solution(new String[]{ "AA", "AB", "AC", "AA", "AC" });
        System.out.println(result2[0] + ", " + result2[1]);

        int[] result3 = solution(new String[]{ "XYZ", "XYZ", "XYZ" });
        System.out.println(result3[0] + ", " + result3[1]);

        int[] result4 = solution(new String[]{ "ZZZ", "YYY", "NNNN", "YYY", "BBB" });
        System.out.println(result4[0] + ", " + result4[1]);
    }

    public static int[] solution(String[] gems) {
        // 현재 보석 종류 및 개수
        Map<String, Integer> gemMap = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            gemMap.put(gems[i], gemMap.getOrDefault(gems[i], 0) + 1);
        }

        Map<String, Integer> shopping = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;

        int left = 0;
        for (int right = 0; right < gems.length; right++) {
            shopping.put(gems[right], shopping.getOrDefault(gems[right], 0) + 1);

            // 모든 종류 포함 시
            while (gemMap.size() == shopping.size()) {
                // 최소 구간 갱신
                int length = right - left + 1;
                if (min > length) {
                    start = left + 1;
                    end = right + 1;
                    min = length;
                }

                // left 감소
                shopping.put(gems[left], shopping.get(gems[left]) - 1);
                if (shopping.get(gems[left]) == 0) {
                    shopping.remove(gems[left]);
                }

                left++;
            }

        }

        return new int[] { start, end };
    }

}
