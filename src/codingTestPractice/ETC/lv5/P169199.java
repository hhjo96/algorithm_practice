package codingTestPractice.ETC.lv5;

import java.util.LinkedList;
import java.util.Queue;

public class P169199 {
    public static void main(String[] args) {

        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println("solution(board) = " + solution(board));
    }

    static int[] dx = {-1, 1, 0, 0}; // 상, 하
    static int[] dy = {0, 0, -1, 1}; // 좌, 우

    public static int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        // 좌표
        char[][] grid = new char[n][m];
        int startX = 0, startY = 0;

        // 시작 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = board[i].charAt(j);
                if (grid[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }

        // 같은 위치를 중복으로 큐에 넣지 않으려면 필요함(처음 도달했을 때가 최단거리임)
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0}); // x, y, 이동횟수
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            // 위치 정보를 꺼냄
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], count = cur[2];

            // 그 위치가 목표지점인 경우
            if (grid[x][y] == 'G') {
                return count;
            }

            // 4방향으로 미끄러뜨려서 최종 도착 지점 계산
            for (int dir = 0; dir < 4; dir++) {
                int nx = x, ny = y;
                while (true) {
                    int tx = nx + dx[dir];
                    int ty = ny + dy[dir];
                    // 벽 or 장애물이면 멈춤
                    if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 'D') {
                        break;
                    }
                    nx = tx;
                    ny = ty;
                }
                // 제자리면 이동한 게 아니므로 스킵
                if ((nx == x && ny == y) || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, count + 1});
            }
        }

        return -1; // G에 도달 못함
    }
}
