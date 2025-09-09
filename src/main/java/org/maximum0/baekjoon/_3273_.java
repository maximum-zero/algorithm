package org.maximum0.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class _3273_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int MAX_NUMBER = 1000000;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(br.readLine());

        boolean[] exist = new boolean[MAX_NUMBER + 1];
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken(" "));
            exist[number] = true;
        }

        int count = 0;
        for (int i = 0; i <= (X - 1) / 2; i++) {
            if (i <= MAX_NUMBER && X - 1 <= MAX_NUMBER) {
                count += (exist[i] && exist[X - i]) ? 1 : 0;
            }
        }

        bw.write(count + "");
        bw.flush();
    }
}
