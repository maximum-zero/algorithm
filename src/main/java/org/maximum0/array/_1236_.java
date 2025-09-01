package org.maximum0.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1236_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = solve(n, m);
        System.out.println(result);
    }

    public static int solve(int n, int m) throws IOException {
        // 0. 입력을 받는다. -> O(N * M)
        char[][] castle = new char[n][m];
        for (int i = 0; i < n; i++) {
            castle[i] = br.readLine().toCharArray();
        }

        // 1. 각 행/열에 대해 경비원이 있는지 확인한다. -> O(N * M)
        boolean[] existRow = new boolean[n];
        boolean[] existCol = new boolean[m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (castle[row][col] == 'X') {
                    existRow[row] = true;
                    existCol[col] = true;
                }
            }
        }

        // 2. 보호받지 못하는 행/열의 개수를 구한다. -> O(N) + O(M)
        int needRowCount = n;
        for (int i = 0; i < n; i++) {
            if (existRow[i]) needRowCount--;
        }

        int needColCount = m;
        for (int i = 0; i < m; i++) {
            if (existCol[i]) needColCount--;
        }

        // 시간 복잡도 : O(N * M) + O(N * M) + O(N) + O(M) -> O(NM)
        // N, M <= 50 , 즉, 2500

        // 3. 둘 중 큰 값을 출력한다.
        return Math.max(needRowCount, needColCount);
    }
}
