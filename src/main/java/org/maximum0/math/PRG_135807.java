package org.maximum0.math;

/*
[유형]
- 수학 (GCD)

[핵심]
- 배열 전체를 나누는 값 → GCD
- GCD가 상대 배열을 나누면 탈락
- 두 방향 모두 확인 후 최대값 선택

[주의]
- GCD 하나만 보면 됨 (약수 전체 X)
- 하나라도 나눠지면 실패
- 두 경우 모두 확인해야 함

*/
public class PRG_135807 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 17}, new int[]{5, 20}));
        System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
        System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
    }

    private static int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getGcd(arrayA);
        int gcdB = getGcd(arrayB);

        int answer = 0;

        if (isValid(gcdA, arrayB)) {
            answer = gcdA;
        }

        if (isValid(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    private static boolean isValid(int gcd, int[] arr) {
        for (int v : arr) {
            if (v % gcd == 0) return false;
        }
        return true;
    }

    private static int getGcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}