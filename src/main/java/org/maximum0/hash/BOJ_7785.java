package org.maximum0.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
[유형]
- Set (상태 관리)
- 정렬

[핵심]
- enter → add
- leave → remove
- 최종 상태만 유지
- 출력 시 정렬

[주의]
- TreeSet 사용 시 불필요한 정렬 비용 발생

*/
public class BOJ_7785 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) set.add(name);
            else set.remove(name);
        }


        String[] arr = set.toArray(new String[0]);
        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String name : arr) {
            sb.append(name).append("\n");
        }

        System.out.print(sb);
    }

}
