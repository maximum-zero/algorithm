package org.maximum0.baekjoon;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _13223_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentAt = sc.nextLine();
        String actionAt = sc.nextLine();

        String result = solve(currentAt, actionAt);
        System.out.println(result);
    }

    public static int getSecondByTime(String time) {
        List<Integer> timeUnit = Arrays.stream(time.split(":"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return timeUnit.get(0) * 3600 + timeUnit.get(1) * 60 + timeUnit.get(2);
    }

    public static String solve(String currentAt, String actionAt) {
        int currentSecond = getSecondByTime(currentAt);
        int actionSecond = getSecondByTime(actionAt);

        int diff = actionSecond - currentSecond;
        if (diff <= 0) {
            diff += 24 * 3600;
        }

        int hour = diff / 3600;
        int minute = diff % 3600 / 60;
        int second = diff % 3600 % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
