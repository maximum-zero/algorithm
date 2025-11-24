package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1730_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String command = br.readLine();

        boolean[][] isVertical = new boolean[N][N];
        boolean[][] isHorizontal = new boolean[N][N];

        int r = 0;
        int c = 0;

        for (char cmd : command.toCharArray()) {
            int nextR = r;
            int nextC = c;

            if (cmd == 'U') nextR--;
            else if (cmd == 'D') nextR++;
            else if (cmd == 'L') nextC--;
            else if (cmd == 'R') nextC++;

            if (nextR < 0 || nextR > N - 1 || nextC < 0 || nextC > N - 1) {
                continue;
            }

            if (cmd == 'U' || cmd == 'D') {
                isVertical[r][c] = true;
                isVertical[nextR][nextC] = true;
            } else if (cmd == 'L' || cmd == 'R') {
                isHorizontal[r][c] = true;
                isHorizontal[nextR][nextC] = true;
            }

            r = nextR;
            c = nextC;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isHorizontal[i][j] && isVertical[i][j]) bw.write("+");
                else if (isHorizontal[i][j]) bw.write("-");
                else if (isVertical[i][j]) bw.write("|");
                else bw.write(".");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
