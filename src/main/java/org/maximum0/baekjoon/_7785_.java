package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _7785_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        TreeSet<String> members = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) {
                members.add(name);
            } else {
                members.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String name : members.descendingSet()) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
