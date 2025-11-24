package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2840_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];
        boolean[] isAlphabet = new boolean[26];

        boolean isPossible = true;
        int currentIndex = 0;
        Arrays.fill(wheel, '?');

        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());

            int step = Integer.parseInt(st.nextToken());
            char input = st.nextToken().charAt(0);
            int charIndex = input - 'A';

            int nextIndex = (currentIndex + step) % N;
            if (wheel[nextIndex] == '?') {
                if (isAlphabet[charIndex]) {
                    isPossible = false;
                    break;
                }

                isAlphabet[charIndex] = true;
                wheel[nextIndex] = input;
            } else if (wheel[nextIndex] != input) {
                isPossible = false;
                break;
            }

            currentIndex = nextIndex;
        }

        if (isPossible) {
            for (int i = 0; i < N; i++) {
                bw.write(wheel[(currentIndex - i + N) % N]);
            }
        } else {
            bw.write("!");
        }

        bw.flush();
    }
}
