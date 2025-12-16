package codingTestPractice.dynamicProgramming;

import java.util.Scanner;

//https://www.acmicpc.net/problem/11066 어렵다.

public class BJ11066 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();        // 테스트케이스 수
        int[] answer = new int[T];   // 결과 저장

        for (int tc = 0; tc < T; tc++) {
            int n = sc.nextInt();

            int[] input = new int[n + 1]; //
            int[] sum = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                input[i] = sc.nextInt();
                sum[i] = sum[i - 1] + input[i];
            }

            int[][] dp = new int[n + 1][n + 1];

            for (int len = 2; len <= n; len++) { // len: 장의 개수
                for (int start = 1; start + len - 1 <= n; start++) {
                    int end = start + len - 1;
                    dp[start][end] = Integer.MAX_VALUE;

                    for (int k = start; k < end; k++) {
                        //합쳐지는 데서 두번 더해짐.
                        //start 번 파일부터 end 번 파일까지를 합치는 최소 비용 = (기존값), start~k 까지 먼저합치고 k+1부터 end 까지 합치고 마지막으로 두덩어리를 합치는비용(전체 파일 크기의 합)
                        dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k + 1][end] + (sum[end] - sum[start - 1]));
                    }
                }
            }

            // ✅ 정답 저장만 하고 출력은 안 함
            answer[tc] = dp[1][n];
        }

        // ✅ 모든 입력이 끝난 뒤 한꺼번에 출력
        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
    }
}
