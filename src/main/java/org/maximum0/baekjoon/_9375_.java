package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _9375_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            Map<String, Integer> fashion = new HashMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();

                if (!fashion.containsKey(kind)) {
                    fashion.put(kind, 1);
                } else {
                    int count = fashion.get(kind);
                    fashion.put(kind, count + 1);
                }
            }

            int total = 1;
            for (int count : fashion.values()) {
                total *= (count + 1);
            }
            bw.write(total - 1 + "\n");
        }
        bw.flush();
    }

}
