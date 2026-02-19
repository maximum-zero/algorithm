package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17232_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        char[][] map = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1);
            }
        }

        while(T-- > 0) {
            // 현재 Map을 기준으로 2차원 누적합 배열 생성
            int[][] prefixSum = getPrefixSum(N, M, map);
            char[][] nextMap = new char[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    // (i, j) 기준 거리 K 이내 생존자 수 계산
                    int x1 = Math.max(1, i - K);
                    int y1 = Math.max(1, j - K);
                    int x2 = Math.min(N, i + K);
                    int y2 = Math.min(M, j + K);

                    // 전체 범위 합 - 자기 자신 = 순수 이웃 수
                    int totalInRange = getRangeSum(prefixSum, x1, y1, x2, y2);
                    int neighbors = totalInRange - (map[i][j] == '*' ? 1 : 0);

                    if (map[i][j] == '*') {
                        // 생존 (a <= neighbors <= b)
                        nextMap[i][j] = (neighbors >= A && neighbors <= B) ? '*' : '.';
                    } else {
                        // 탄생 (a < neighbors <= b)
                        nextMap[i][j] = (neighbors > A && neighbors <= B) ? '*' : '.';
                    }
                }
            }
            map = nextMap;
        }

        printMap(N, M, map);
    }

    // 2차원 누적합 배열 생성
    private static int[][] getPrefixSum(int N, int M, char[][] map) {
        int[][] acc = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int val = (map[i][j] == '*') ? 1 : 0;
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + val;
            }
        }
        return acc;
    }

    // 특정 구간의 합 (O(1))
    private static int getRangeSum(int[][] acc, int x1, int y1, int x2, int y2) {
        return acc[x2][y2] - acc[x1 - 1][y2] - acc[x2][y1 - 1] + acc[x1 - 1][y1 - 1];
    }

    // Map 출력
    private static void printMap(int N, int M, char[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}
