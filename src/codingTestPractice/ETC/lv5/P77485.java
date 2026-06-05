package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/77485
// x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을
// 한 칸씩 시계방향으로 회전합니다.
// 행렬의 세로 길이(행 개수) rows, 가로 길이(열 개수) columns, 그리고 회전들의 목록 queries가
// 주어질 때, 각 회전들을 배열에 적용한 뒤, 그 회전에 의해 위치가 바뀐 숫자들 중 가장
// 작은 숫자들을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

import java.util.Arrays;

public class P77485 {
    public static void main(String[] args) {

        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(solution(6, 6, queries)));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        // 정답용 배열 answer를 queries.length 크기로 만들기
        int[] answer = new int[queries.length];

        // rows * columns 만큼 숫자로 채우기
        int[][] arr = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = num++;
            }
        }

        // 회전할 때 아직 덮어쓰기 안한 칸에서 값을 가져와야 편함(왼쪽 세로, 아래 가로)
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int temp = arr[x1][y1];
            int min = temp;

            // 왼쪽 세로: 아래 값을 위로 당김
            for (int x = x1; x < x2; x++) {
                arr[x][y1] = arr[x + 1][y1];
                min = Math.min(min, arr[x][y1]);
            }

            // 아래 가로: 오른쪽 값을 왼쪽으로 당김
            for (int y = y1; y < y2; y++) {
                arr[x2][y] = arr[x2][y + 1];
                min = Math.min(min, arr[x2][y]);
            }

            // 오른쪽 세로: 위 값을 아래로 당김
            for (int x = x2; x > x1; x--) {
                arr[x][y2] = arr[x - 1][y2];
                min = Math.min(min, arr[x][y2]);
            }

            // 위 가로: 왼쪽 값을 오른쪽으로 당김
            for (int y = y2; y > y1 + 1; y--) {
                arr[x1][y] = arr[x1][y - 1];
                min = Math.min(min, arr[x1][y]);
            }

            arr[x1][y1 + 1] = temp;
            answer[i] = min;
        }

        return answer;
    }
}
