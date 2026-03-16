package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[] dx = new int[]{ 1, -1, 0, 0 };
        int[] dy = new int[]{ 0, 0, 1, -1 };

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0 });

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                else if (map[nx][ny] == 0) continue;
                else if (map[nx][ny] != 1) continue;

                map[nx][ny] = map[x][y] + 1;
                queue.add(new int[] { nx, ny });
            }
        }
        System.out.print(map[N - 1][M - 1]);
    }

}
