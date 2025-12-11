package codingTestPractice.dynamicProgramming;

import java.util.Scanner;

public class BJ11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input= new int[n];

        for(int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        //dp[i]: i번째 원소를 마지막 원소로 하는 가장 긴 증가하는 부분수열의 길이
        int[] dp = new int[n];
        dp[0] = 1;
        if(n >= 2) {
            for(int i = 1; i < n; i++) {
                dp[i] = 1;
                for(int j = 0; j < i; j++) {
                    if(input[j] < input[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

        }
        int max = dp[0];
        for(int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
