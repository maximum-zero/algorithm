package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _1764_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> unheard = new HashSet<>();
        Set<String> result = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                result.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String name : result) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }

}
