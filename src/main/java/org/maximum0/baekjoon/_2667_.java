package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _2667_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = new int[]{ 1, -1, 0, 0 };
        int[] dy = new int[]{ 0, 0, 1, -1 };

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 1) continue;

                queue.offer(new int[]{ i, j });
                map[i][j] = 0;

                int count = 1;
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (map[nx][ny] != 1) continue;

                        map[nx][ny] = 0;
                        count++;
                        queue.offer(new int[] { nx, ny });
                    }
                }

                result.add(count);
            }
        }

        result.sort(Integer::compareTo);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size());
        for (int r : result) {
            sb.append('\n').append(r);
        }

        System.out.print(sb);
    }

}
