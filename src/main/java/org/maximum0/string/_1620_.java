package org.maximum0.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1620_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] listByNumber = new String[n + 1];
        HashMap<String, Integer> listByName = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String pokemon = br.readLine();
            listByNumber[i] = pokemon;
            listByName.put(pokemon, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();

            if (input.charAt(0) >= 'A' || input.charAt(0) >= 'Z') {
                sb.append(listByName.get(input)).append("\n");
            } else {
                sb.append(listByNumber[Integer.parseInt(input) - 1]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
