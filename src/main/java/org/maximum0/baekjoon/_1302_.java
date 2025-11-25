package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _1302_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(br.readLine());

        Map<String, Integer> books = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            books.put(title, books.getOrDefault(title, 0) + 1);
        }

        int maxCount = 0;
        String bestSeller = "";
        for (Map.Entry<String, Integer> entry : books.entrySet()) {
            String title = entry.getKey();
            Integer count = entry.getValue();

            if (count > maxCount || (count == maxCount && title.compareTo(bestSeller) < 0)) {
                maxCount = count;
                bestSeller = title;
            }

        }

        System.out.println(bestSeller);
    }

}
