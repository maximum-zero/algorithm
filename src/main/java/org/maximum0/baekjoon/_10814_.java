package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _10814_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            peoples.add(new People(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        peoples.sort((p1 , p2) -> p1.getAge() - p2.getAge());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(peoples.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    static class People {
        private int age;
        private String name;

        public People(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return this.age + " " + this.name;
        }
    }

}
