package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class _10448_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int MAX_NUMBER = 1000;

    public static void main(String[] args) throws IOException {
        List<Integer> triangleNumbers = getTriangleNumbers();
        int T = Integer.parseInt(br.readLine());

        boolean[] sumOfTriangle = new boolean[MAX_NUMBER + 1];
        for (int i = 0; i < triangleNumbers.size(); i++) {
            for (int j = 0; j < triangleNumbers.size(); j++) {
                int sum = triangleNumbers.get(i) + triangleNumbers.get(j);
                if (sum < MAX_NUMBER) {
                    sumOfTriangle[sum] = true;
                }
            }
        }

        while (T-- > 0) {
            int number = Integer.parseInt(br.readLine());

            boolean isEureka = false;
            for (int i = 0; i < triangleNumbers.size(); i++) {
                int diff = number - triangleNumbers.get(i);
                if (diff > 0 && diff < MAX_NUMBER && sumOfTriangle[diff]) {
                    isEureka = true;
                    break;
                }
            }

            bw.write((isEureka ? "1" : "0") + "\n");
        }
        bw.flush();

    }

    private static List<Integer> getTriangleNumbers() {
        List<Integer> triangleNumbers = new ArrayList<>();

        int n = 1;
        while(true) {
            int result = n * (n + 1) / 2;
            if (result > MAX_NUMBER) {
                break;
            }

            triangleNumbers.add(result);
            n++;
        }
        return triangleNumbers;
    }

}
