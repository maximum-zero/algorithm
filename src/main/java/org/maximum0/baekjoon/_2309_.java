package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2309_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int COUNT = 9;
        final int TARGET_SUM = 100;

        List<Integer> height = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            height.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(height);

        int sum = height.stream().mapToInt(Integer::intValue).sum();
        findFakes(height, sum - TARGET_SUM);
        height.forEach(System.out::println);

        br.close();
    }

    private static void findFakes(List<Integer> height, int diff) {
        for (int i = 0; i < height.size() - 1; i++) {
            for (int j = i + 1; j < height.size(); j++) {
                if (height.get(i) + height.get(j) == diff) {
                    height.remove(j);
                    height.remove(i);
                    return;
                }
            }
        }
    }
}
