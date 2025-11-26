package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _2910_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> numberOfIndex = new ArrayList<>();
        Map<Integer, Integer> numberOfFrequency = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (!numberOfFrequency.containsKey(number)) {
                numberOfIndex.add(number);
                numberOfFrequency.put(number, 1);
            } else {
                numberOfFrequency.put(number, numberOfFrequency.get(number) + 1);
            }
        }

        numberOfIndex.sort((n1, n2) -> {
            Integer first = numberOfFrequency.get(n1);
            Integer second = numberOfFrequency.get(n2);
            return second.compareTo(first);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfIndex.size(); i++) {
            Integer number = numberOfIndex.get(i);
            for (int n = 0; n < numberOfFrequency.get(number); n++) {
                sb.append(number).append(" ");
            }
        }

        System.out.println(sb);
    }

}
