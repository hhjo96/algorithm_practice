package codingTestPractice.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2293
public class BJ2293 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전의종류
        int sum = Integer.parseInt(st.nextToken()); // 목표로 하는 동전


        int [] coins = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken()); // 동전의 가치 저장
        }
        //dp[i][j] = 0번 ~ i번 동전까지 사용해서 합 j를 만드는 경우의 수
        int[][] dp = new int[n][sum+1];

        //초기화
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        //계산
        for(int i = 0; i < n; i++) {
            int coin = coins[i];
            for(int j = 1; j <= sum; j++) {//j: 합

                // i번째 동전을 안 쓰는 경우 -> i-1번째 동전까지만 써서 j를 만들었다. i==0일때는 이미 처리했고 인덱스 오류도 나니까
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }

                // i번째 동전을 쓰는 경우 -> 동전을 쓰려면 합 j 가 i번째동전의가치 coin보다 커야하고, 합-현재동전의가치 = j-coin 임.
                if (j >= coin) {
                    dp[i][j] += dp[i][j - coin];
                }
            }
        }
        System.out.println(dp[n-1][sum]);
    }
}
