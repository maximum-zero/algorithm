package org.maximum0.string;

import java.util.Scanner;

public class _1543_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String document = sc.nextLine();
        String word = sc.nextLine();

        int result = solve(document, word);
        System.out.println(result);
    }

    public static int solve(String document, String word) {
        int startIndex = 0;
        int count = 0;
        while(true) {
            int findIndex = document.indexOf(word, startIndex);
            if (findIndex < 0)
                break;

            startIndex = findIndex + word.length();
            count++;
        }

        return count;
    }
}
