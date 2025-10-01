package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3085_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    swap(map, i, j, i, j + 1);
                    maxCount = Math.max(maxCount, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swap(map, i, j, i, j + 1);
                }

                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    swap(map, i, j, i + 1, j);
                    maxCount = Math.max(maxCount, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swap(map, i, j, i + 1, j);
                }
            }
        }

        bw.write(maxCount + "");
        bw.flush();
    }

    public static void swap(char[][] map, int r1, int c1, int r2, int c2) {
        char temp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = temp;
    }

    public static int findMaxRow(char[][] map) {
        int N = map.length;
        int maxRow = 0;
        for (int r = 0; r < N; r++) {
            int count = 1;
            for (int c = 1; c < N; c++) {
                if (map[r][c] == map[r][c - 1]) {
                    count++;
                } else {
                    maxRow = Math.max(maxRow, count);
                    count = 1;
                }
            }
            maxRow = Math.max(maxRow, count);
        }
        return maxRow;
    }


    public static int findMaxColumn(char[][] map) {
        int N = map.length;
        int maxColumn = 0;
        for (int c = 0; c < N; c++) {
            int count = 1;
            for (int r = 1; r < N; r++) {
                if (map[r][c] == map[r - 1][c]) {
                    count++;
                } else {
                    maxColumn = Math.max(maxColumn, count);
                    count = 1;
                }
            }
            maxColumn = Math.max(maxColumn, count);
        }
        return maxColumn;
    }
}
