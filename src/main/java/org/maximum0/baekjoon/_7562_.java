package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        int[] dx = new int[]{ -2, -1, -2, -1,  2,  1, 2, 1 };
        int[] dy = new int[]{ -1, -2,  1,  2, -1, -2, 1, 2 };

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int I = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{ startX, startY });

            int[][] map = new int[I][I];
            boolean[][] visited = new boolean[I][I];
            map[startX][startY] = 0;
            visited[startX][startY] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                if (x == endX && y == endY) break;

                for (int d = 0; d < 8; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
                    if (visited[nx][ny]) continue;

                    map[nx][ny] = map[x][y] + 1;
                    visited[nx][ny] = true;

                    queue.offer(new int[] { nx, ny });
                }
            }

            sb.append(map[endX][endY]).append("\n");
        }

        System.out.print(sb);
    }

}
