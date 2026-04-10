package org.maximum0.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
[유형]
- Set (대칭 차집합)

[핵심]
- A - B + B - A
- removeAll() 또는 contains()로 구현 가능
- 최종 개수 = diffA.size() + diffB.size()

[주의]
- 교집합과 혼동하지 않기
- Set 복사 없이 removeAll 쓰면 원본 훼손됨

*/
public class BOJ_1269 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> diffA = new HashSet<>(setA);
        Set<Integer> diffB = new HashSet<>(setB);

        diffA.removeAll(setB); // A - B
        diffB.removeAll(setA); // B - A

        System.out.print(diffA.size() + diffB.size());
    }

}
