package codingTestPractice.ETC.lv5;

import java.util.Arrays;

public class P68936 {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},
    {0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr)));
    }


    static int zero = 0; // 압축완료된 0 덩어리 개수
    static int one = 0;  // 압축완료된 1 덩어리 개수

    public static int[] solution(int[][] arr) {

        // 0, 0에서 시작하는 length 크기의 정사각형 검사
        compress(arr, 0, 0, arr.length);

        return new int[]{zero, one};
    }

    public static void compress(int[][] arr, int x, int y, int size) {

        // x, y: 시작 행열
        // 첫번째 숫자 저장
        int first = arr[x][y];

        // 현재 영역이 전부 같은 숫자인지 확인
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {

                // 다른 숫자 발견 -> 4등분
                if (arr[i][j] != first) {

                    int half = size / 2;

                    compress(arr, x, y, half); // 왼쪽 위
                    compress(arr, x, y + half, half); // 오른쪽 위
                    compress(arr, x + half, y, half); // 왼쪽 아래
                    compress(arr, x + half, y + half, half); // 오른쪽 아래

                    return;
                }
            }
        }

        // 전부 같은 숫자였던 경우
        if (first == 0) {
            zero++;
        } else {
            one++;
        }
    }
}
