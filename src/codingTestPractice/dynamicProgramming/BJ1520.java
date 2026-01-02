package codingTestPractice.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1520 {

        static int M, N; //세로 m: x 가로 n: y
        static int[][] map; // 각 칸의 높이
        static int[][] dp; // 경로 수 저장 (메모이제이션)

        // 4방향 이동: 상, 하, 좌, 우
        //같은 인덱스끼리 상하좌우인거임.
        static final int[] dx = {-1, 1, 0, 0};
        static final int[] dy = {0, 0, -1, 1};

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            //여기까지 가로 세로 입력받았음

            map = new int[M][N];
            dp = new int[M][N];

            // 입력 받기 + dp 초기화(-1 = 미방문/미계산)
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = -1; // 아직 이 칸에서 도착점까지 경로 수를 계산하지 않음
                }
            }

            // (0,0)에서 출발해서 도착점까지 경로 수 출력
            System.out.println(dfs(0, 0));
        }

        /**
         * dfs(x, y) = (x,y)에서 (M-1,N-1)까지 내리막으로 갈 수 있는 경로 수
         */
        static int dfs(int x, int y) {
            // 1) 도착점에 도달하면 "경로 1개"로 센다.
            //    (여기까지 온 방법이 하나의 완성된 경로이므로 1을 반환)
            if (x == M - 1 && y == N - 1) {
                return 1;
            }

            // 2) 이미 계산한 적이 있으면 dp값 그대로 반환 (중복 계산 방지)
            if (dp[x][y] != -1) {
                return dp[x][y];
            }

            // 3) 이제 이 칸 dp를 계산할 차례
            //    우선 0으로 세팅해두고, 가능한 방향으로 DFS 결과를 누적한다.
            dp[x][y] = 0;

            // 4) 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 4-1) 범위 체크 (격자 밖이면 스킵)
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

                // 4-2) "내리막" 조건: 다음 칸 높이가 더 낮아야만 이동 가능
                if (map[nx][ny] < map[x][y]) {
                    // 4-3) 다음 칸에서 도착점까지 가는 경로 수를 더한다.
                    dp[x][y] += dfs(nx, ny);
                }
            }

            // 5) (x,y)의 경로 수 계산 완료 -> 반환
            return dp[x][y];
        }
    }