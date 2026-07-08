package codingTestPractice.ETC.lv5;

import java.util.ArrayDeque;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/159993
// 1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 각 칸은 통로 또는 벽으로 구성되어 있으며,
// 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데,
// 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다. 따라서, 출발 지점에서 먼저 레버가 있는
// 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 이때 아직 레버를 당기지 않았더라도
// 출구가 있는 칸을 지나갈 수 있습니다. 미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때,
// 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.
//미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을
// return 하는 solution 함수를 완성해주세요. 만약, 탈출할 수 없다면 -1을 return 해주세요.
public class P159993 {
    public static void main(String[] args) {

    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int solution(String[] maps) {

        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        int exitX = 0, exitY = 0;

        // S, L, E 위치 찾기
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {

                char c = maps[i].charAt(j);

                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    leverX = i;
                    leverY = j;
                } else if (c == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }

        // S -> L
        int toLever = bfs(maps, startX, startY, leverX, leverY);

        if (toLever == -1) {
            return -1;
        }

        // L -> E
        int toExit = bfs(maps, leverX, leverY, exitX, exitY);

        if (toExit == -1) {
            return -1;
        }

        return toLever + toExit;
    }

    // startX, startY 위치에서 target까지 최단거리 구하기
    public static int bfs(String[] maps, int startX, int startY,
                   int targetX, int targetY) {

        // 미로 크기
        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new ArrayDeque<>();

        // offer: 뒤에넣기, poll: 앞에서꺼내기
        // 시작위치 넣기(시작좌표, 이동거리)
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        // 큐가 비었다면 더이상 갈곳이 없는것
        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            int x = now[0];
            int y = now[1];
            int dist = now[2];

            if (x == targetX && y == targetY) {
                return dist;
            }

            // 상하좌우
            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 밖
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 이미 방문
                if (visited[nx][ny]) {
                    continue;
                }

                // 벽
                if (maps[nx].charAt(ny) == 'X') {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return -1;
    }
}
