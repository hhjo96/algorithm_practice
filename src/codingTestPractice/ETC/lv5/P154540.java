package codingTestPractice.ETC.lv5;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/154540
// 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다.
// 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다.
// 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며, 격자의 각 칸에는 'X' 또는
// 1에서 9 사이의 자연수가 적혀있습니다. 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다.
// 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다.
// 지도의 각 칸에 적힌 숫자는 식량을 나타내는데, 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를
// 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다.
// 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후
// 놀러갈 섬을 결정하려 합니다.
//지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때, 각 섬에서 최대 며칠씩
// 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요.
// 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.

public class P154540 {
    public static void main(String[] args) {

        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println("solution1 = " + Arrays.toString(solution(maps)));
    }

    public static int[] solution(String[] maps) {

        // maps 배열을 숫자 배열로 교체, X 는 0 으로 치환
        int[][] mapArr = new int[maps.length][maps[0].length()];

        for(int i = 0; i< maps.length; i++) {
            for(int j = 0; j< maps[0].length(); j++) {
                mapArr[i][j] = maps[i].charAt(j) == 'X' ? 0 : maps[i].charAt(j) - '0';
            }
        }

        // 방문 여부 체크용
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 앞에서부터 for문 돌면서 0이 아닌 수를 발견하면 아래오른쪽 검사(배열 범위 내)
        // 위, 왼쪽은 이미 지나왔으므로 검사하지 않음
        // 거기서 0이 아닌 수를 또 발견하면 더하기
        for(int i = 0; i< maps.length; i++) {
            for(int j = 0; j< maps[0].length(); j++) {

                if((mapArr[i][j] != 0) && (!visited[i][j])) {
                    int count = 0;

                    //(2, 3) 이런식으로 좌표를 저장하는 큐
                    // X가 아니었던 좌표를 큐에 저장
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    // X가 아니었던 좌표를 꺼내서 그 주변 검사
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int x = now[0];
                        int y = now[1];

                        count += mapArr[x][y];

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length()) {
                                if (mapArr[nx][ny] != 0 && !visited[nx][ny]) {
                                    visited[nx][ny] = true;
                                    queue.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }

                    list.add(count);
                }
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }


}
