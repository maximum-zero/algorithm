package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _2817_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        List<Score> staffScore = new ArrayList<>();
        Map<Character, Integer> staffChips = new HashMap<>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char name = st.nextToken().charAt(0);
            int score = Integer.parseInt(st.nextToken());
            if (score < X * 0.05) {
                continue;
            }

            staffChips.put(name, 0);
            for (int i = 0; i < 14; i++) {
                double alpsScore = (double) score / (i + 1);
                staffScore.add(new Score(name, alpsScore));
            }
        }

        staffScore.sort((s1, s2) -> Double.compare(s2.getAlpsScore(), s1.getAlpsScore()));

        for (int i = 0; i < 14; i++) {
            char staffName = staffScore.get(i).getStaff();
            staffChips.put(staffName, staffChips.get(staffName) + 1);
        }

        List<Character> staff = new ArrayList<>(staffChips.keySet());
        staff.sort(Character::compareTo);

        for (char s : staff) {
            bw.write(s + " " + staffChips.get(s) + "\n");
        }

        bw.flush();
    }

    static class Score {
        private char staff;
        private double alpsScore;

        Score(char staff, double alpsScore) {
            this.staff = staff;
            this.alpsScore = alpsScore;
        }

        char getStaff() {
            return this.staff;
        }

        double getAlpsScore() {
            return this.alpsScore;
        }
    }

}
