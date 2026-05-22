package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/68645
// 정수 n이 매개변수로 주어집니다. 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서
// 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 첫 행부터 마지막 행까지 모두
// 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.

import java.util.Arrays;

public class P68645 {
    public static void main(String[] args) {


        System.out.println(Arrays.toString(solution(5)));
    }

    public static int[] solution(int n) {

        int[][] arr = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1;

        // 아래: x증가, 오른쪽: y증가, 왼쪽위대각선: 둘다 감소
        // 반복 횟수는 1씩 줄어듬 n번부터

        for (int i = 0; i < n; i++) {

            // j: 방향별 이동 횟수
            // i = 0일때 j는 012.. n-1 이므로 n번 이동
            // i = n-1일때 j는 n-1로 1번 이동
            for (int j = i; j < n; j++) {

                // 3: 방향의 종류 개수
                // 아래
                if (i % 3 == 0) {
                    x++;
                }
                // 오른쪽
                else if (i % 3 == 1) {
                    y++;
                }
                // 왼쪽 위 대각선
                else {
                    x--;
                    y--;
                }

                arr[x][y] = num++;
            }
        }

        // 문제 리턴타입이 1차원배열이므로 변환해야 함
        int[] answer = new int[n * (n + 1) / 2];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }
}
