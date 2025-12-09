package codingTestPractice.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2565
public class BJ2565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] wire = new int[n][2];  // A, B 저장

        // 입력받기
        for (int i = 0; i < n; i++) {
            wire[i][0] = sc.nextInt(); // A
            wire[i][1] = sc.nextInt(); // B
        }

        // 1. A 기준으로 오름차순 정렬
        Arrays.sort(wire, (o1, o2) -> o1[0] - o2[0]);

        // 2. B값만 꺼내서 LIS 수행
        int[] dp = new int[n]; //dp[i]: i번째 원소에서 끝나는 가장 긴 증가 부분 수열의 길이
        Arrays.fill(dp, 1);  // 기본 LIS 길이 = 1

        int max = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (wire[j][1] < wire[i][1]) {   // 증가하는 경우
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 더 크다면 자기자신을 붙이므로 +1
                }
            }
            max = Math.max(max, dp[i]);
        }

        // 3. 정답 = 전체 전깃줄 - LIS 길이
        System.out.println(n - max);
    }
}
