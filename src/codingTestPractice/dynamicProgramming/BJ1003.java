package codingTestPractice.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];

        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        //[0]: 0이출력되는횟수, [1]: 1이출력되는횟수
        int[][] dp = new int[sortedArr[t-1]+1][2];

        dp[0][0] = 1;
        dp[0][1] = 0;

        if(sortedArr[t-1] >=1) {
            dp[1][0] = 0;
            dp[1][1] = 1;

            for (int i = 2; i <= sortedArr[t - 1]; i++) {

                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1];

            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(dp[arr[i]][0] + " " + dp[arr[i]][1]);
        }
    }
}
