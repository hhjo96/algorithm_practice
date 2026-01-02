package codingTestPractice.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7579
public class BJ7579 {
    public static void main(String[] args) throws Exception {

        //n: 앱 개수, m: 필요한 메모리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //메모리
        st = new StringTokenizer(br.readLine());
        int []memory = new int[n];
        for(int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        //비용
        st = new StringTokenizer(br.readLine());
        int []cost = new int[n];
        for(int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        //dp 배열 초기화
        int []dp = new int[10000 + 1]; // dp[i]: 비용을 i만큼 썼을 때 확보할 수 있는 최대 메모리. 앱개수 * 비용
        dp[0] = 0;

        //dp 배열 계산
        for (int i = 0; i < n; i++) {           // 앱 하나씩 처리
            int mem = memory[i];
            int cst = cost[i];

            for (int c = 10000; c >= cst; c--) { // 비용은 뒤에서부터. c: 지금사용한총비용. dp[c]: 이비용으로 확보가능한 최대메모리
                dp[c] = Math.max(dp[c], dp[c - cst] + mem); // dp[c]: i번째앱을 안끈다. 메모리 변화없음. dp[c-cs] + mem: i번째앱을끈다.
            }
        }
        //출력
        for (int c = 0; c <= 10000; c++) {
            if (dp[c] >= m) {
                System.out.println(c);
                break;
            }
        }
    }
}
