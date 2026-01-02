package codingTestPractice.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10942
public class BJ10942 {
    public static void main(String[] args) throws Exception{
        //읽어오기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //수열의 크기 N 읽어옴
        int N = Integer.parseInt(st.nextToken());
        //System.out.println("N = " + N);

        // 둘째줄 N개를 읽음
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        for (int i = 0; i < N; i++) {
//            System.out.print(arr[i] + " ");
//        }

        //질문의 개수 M 읽어옴
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        //System.out.println(M);

        //s랑 e를 읽어옴
        int[] s = new int[M];
        int[] e = new int[M];
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            s[j] = Integer.parseInt(st.nextToken());
            e[j] = Integer.parseInt(st.nextToken());
        }
        //System.out.println("s = " + Arrays.toString(s) + ", e = " + Arrays.toString(e));

        //dp 배열 채우기: dp배열은 i번째부터 j번째까지가 팰린드롬인지를 저장함
        int [][] dp = new int[N][N];
        //길이가 1. 즉 (k번째수, k번째수) 라면 무조건 팰린드롬이다
        for(int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }
        //길이가 2. (k번째수, k+1 번째 수) 라면 둘이 같으면 팰린드롬이다
        for(int i = 0;i<N-1;i++) {
            if(arr[i] == arr[i+1]) {
                dp[i][i+1] = 1;
            } else {
                dp[i][i+1] = 0;
            }
        }
        //길이가 3 이상인경우
        for (int len = 3; len <= N; len++) {
            for (int i = 0; i + len - 1 < N; i++) {
                int j = i + len - 1;

                if ((arr[i] == arr[j]) && (dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                }
            }
        }

        //정답 출력
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(dp[s[i] - 1][e[i] - 1]).append('\n');
        }

        System.out.print(sb.toString());

    }
}
