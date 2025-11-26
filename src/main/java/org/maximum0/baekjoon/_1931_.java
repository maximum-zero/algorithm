package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1931_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(br.readLine());

        int[][] rooms = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rooms[i][0] = Integer.parseInt(st.nextToken());
            rooms[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(rooms, (int[] room1, int[] room2) -> {
            if (room1[1] != room2[1]) {
                return Integer.compare(room1[1], room2[1]);
            } else {
                return Integer.compare(room1[0], room2[0]);
            }
        });

        int endHour = 0;
        int count = 0;
        for (int[] room : rooms) {
            if (room[0] >= endHour) {
                endHour = room[1];
                count++;
            }
        }
        System.out.println(count);
    }

}
