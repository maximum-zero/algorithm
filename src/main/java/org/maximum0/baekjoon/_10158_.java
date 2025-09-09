package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10158_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        String result = solve(w, h, p, q, t);
        System.out.println(result);
    }

    public static String solve(int w, int h, int p, int q, int t) {
        int currentX = (t + p) % (2 * w);
        int currentY = (t + q) % (2 * h);

        if (currentX > w) currentX = 2 * w - currentX;
        if (currentY > h) currentY = 2 * h - currentY;

        return currentX + " " + currentY;
    }
}
