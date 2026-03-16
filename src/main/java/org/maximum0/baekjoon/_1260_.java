package org.maximum0.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            graph[i].sort(Integer::compareTo);
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.print(sb);
    }

    static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(' ');

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(' ');

            for (int next: graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

}
