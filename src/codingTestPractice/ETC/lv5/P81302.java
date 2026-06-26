package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/81302
// 로나 바이러스 감염 예방을 위해 응시자들은 거리를 둬서 대기를 해야하는데 개발 직군 면접인 만큼
//아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.
//
//대기실은 5개이며, 각 대기실은 5x5 크기입니다.
//거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
//단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
// 5개의 대기실을 본 죠르디는 각 대기실에서 응시자들이 거리두기를 잘 기키고 있는지 알고 싶어졌습니다.
// 자리에 앉아있는 응시자들의 정보와 대기실 구조를 대기실별로 담은 2차원 문자열 배열
// places가 매개변수로 주어집니다. 각 대기실별로 거리두기를 지키고 있으면 1을,
// 한 명이라도 지키지 않고 있으면 0을 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P81302 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        // P: 사람, X: 파티션
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution(places)));
        System.out.println(Arrays.toString(solution2(places)));
    }

    // 1번 방법
    public static int[] solution(String[][] places) {

        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {

            char[][] map = new char[5][5];

            for (int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
            }

            answer[i] = check(map);
        }

        return answer;
    }

    public static int check(char[][] map) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (map[i][j] == 'P') {

                    if (!bfs(i, j, map)) {
                        return 0;
                    }

                }
            }
        }

        // 모든 p를 검사했을 때 문제가 없으면 1
        return 1;
    }

    public static boolean bfs(int x, int y, char[][] map) {

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if (dist >= 2) {
                continue;
            }

            for (int i = 0; i < 4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 'X') {
                    continue;
                }

                if (map[nx][ny] == 'P') {
                    return false;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return true;
    }


    // 2번 방법
    public static int[] solution2(String[][] places) {

        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {

            char[][] map = new char[5][5];

            for (int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
            }

            answer[i] = check2(map);
        }

        return answer;
    }

    public static int check2(char[][] map) {

        for (int x1 = 0; x1 < 5; x1++) {
            for (int y1 = 0; y1 < 5; y1++) {

                if (map[x1][y1] != 'P') continue;

                for (int x2 = 0; x2 < 5; x2++) {
                    for (int y2 = 0; y2 < 5; y2++) {

                        if (x1 == x2 && y1 == y2) continue;
                        if (map[x2][y2] != 'P') continue;

                        int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                        if (dist > 2) continue;

                        // 거리 1이면 무조건 실패
                        if (dist == 1) {
                            return 0;
                        }

                        // 같은 행
                        if (x1 == x2) {

                            int mid = (y1 + y2) / 2;

                            if (map[x1][mid] != 'X') {
                                return 0;
                            }
                        }

                        // 같은 열
                        else if (y1 == y2) {

                            int mid = (x1 + x2) / 2;

                            if (map[mid][y1] != 'X') {
                                return 0;
                            }
                        }

                        // 대각선
                        else {

                            if (map[x1][y2] != 'X' || map[x2][y1] != 'X') {
                                return 0;
                            }
                        }
                    }
                }
            }
        }

        return 1;
    }
}
