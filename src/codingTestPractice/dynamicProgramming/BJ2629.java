package codingTestPractice.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2629 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 추의개수

        //추의무게들
        st = new StringTokenizer(br.readLine());
        int [] chu = new int[N];
        for(int i = 0; i < N; i++) {
            chu[i] = Integer.parseInt(st.nextToken());
        }

        //무게를 확인하고자 하는 구슬들의 개수
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        //구슬들의 무게
        int []beads = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
        }

        //dp[i][d] = i번째 추까지 계산해서 “차이 d”를 만들 수 있으면 true
        //최대차이 30개추 * 추하나500
        boolean [][]dp = new boolean[N+1][15001];
        dp[0][0] = true;

        //이전상태에서 차이 d, 현재 추의 무게 w 이면
        //다음단계에서 나올 수 있는 차이의 경우의 수 |d-w|, d, d+w 세개임.
        for (int i = 0; i < N; i++) {
            for (int d = 0; d <= 15000; d++) {
                if (!dp[i][d]) continue; // 이전상태에서 false 였다면 다음단계 논의할 수 없음

                dp[i + 1][d] = true;                 // 안 씀
                if (d + chu[i] <= 15000) {
                    dp[i + 1][d + chu[i]] = true;
                }
                dp[i + 1][Math.abs(d - chu[i])] = true; // 반대쪽
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            if (beads[i] <= 15000 && dp[N][beads[i]]) {
                sb.append("Y").append(" ");
            } else {
                sb.append("N").append(" ");
            }
        }
        System.out.println(sb);
    }
}
