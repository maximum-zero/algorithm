package org.maximum0.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
[유형]
- HashMap (문자열 → 숫자)
- 배열 (숫자 → 문자열)

[핵심]
- 양방향 조회 구조
- 문자열 → Map
- 숫자 → 배열 (Index 접근)
- O(1) 조회

[주의]
- 숫자/문자 구분은 Character.isDigit 사용
- 숫번으로 문자열 조회는 배열이 Map 보다 효율적

*/
public class BOJ_1620 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 포켓몬 개수
        int M = Integer.parseInt(st.nextToken()); // 질문 개수

        String[] numberToPokemon = new String[N + 1];
        Map<String, Integer> pokemonToNumber = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String pocketMon = br.readLine();
            numberToPokemon[i + 1] = pocketMon;
            pokemonToNumber.put(pocketMon, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (i != 0) sb.append("\n");

            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) {
                // 순번 (포켓몬 출력)
                sb.append(numberToPokemon[Integer.parseInt(question)]);
            } else {
                // 포켓몬 (순번 출력)
                sb.append(pokemonToNumber.get(question));
            }
        }

        System.out.print(sb);
    }

}
