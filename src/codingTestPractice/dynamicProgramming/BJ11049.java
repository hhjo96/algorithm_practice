package codingTestPractice.dynamicProgramming;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11049
public class BJ11049 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        // dims[i] : 차원 정보
        // i번째 행렬의 크기 = dims[i-1] x dims[i]
        int[] dims = new int[n + 1];

        // 첫 행렬
        dims[0] = scanner.nextInt(); // r1
        dims[1] = scanner.nextInt(); // c1

        // 나머지 행렬
        for (int i = 2; i <= n; i++) {
            scanner.nextInt();      // ri (이전 ci와 같음 → 버려도 됨)
            dims[i] = scanner.nextInt(); // ci
        }

        // dp[i][j] = i번째부터 j번째 행렬까지 곱하는 최소 연산 횟수
        long[][] dp = new long[n + 1][n + 1];

        // 구간 길이
        for (int len = 2; len <= n; len++) {
            // 시작점
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Long.MAX_VALUE;

                // 분할점
                for (int k = i; k < j; k++) {
                    long cost =
                            dp[i][k]
                                    + dp[k + 1][j]
                                    + (long) dims[i - 1] * dims[k] * dims[j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
