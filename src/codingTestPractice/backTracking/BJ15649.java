package codingTestPractice.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15649
public class BJ15649 {

    static int N;
    static int M;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //1부터 n까지 중복없이 m개를 고른 수열 전부 출력하기

        result = new int[M];
        visited = new boolean[N+1];

        dfs(0);

        System.out.println(sb);
    }

    //depth 번째 자리 채우는 함수
    static void dfs(int depth) {
        // M개를 다 고른 경우
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 N까지 하나씩 시도
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;        // 선택
                result[depth] = i;        // 현재 자리에 i 저장
                dfs(depth + 1);           // 다음 단계
                visited[i] = false;       // 되돌리기 (백트래킹 핵심)
            }
        }
    }
}
