package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        Queue<int[]> queue = new ArrayDeque<>();

        int[] dx = new int[]{ 1, -1, 0, 0 };
        int[] dy = new int[]{ 0, 0, 1, -1 };

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int status = Integer.parseInt(st.nextToken());
                map[i][j] = status;
                if (status == 1) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                else if (map[nx][ny] == -1) continue;
                else if (map[nx][ny] > 0) continue;

                map[nx][ny] = map[x][y] + 1;
                queue.add(new int[] { nx, ny });
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
                result = Math.max(result, map[i][j]);
            }
        }

        System.out.print(result - 1);
    }

}
