package codingTestPractice.ETC.lv5;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/68936
// 0과 1로 이루어진 2n x 2n 크기의 2차원 정수 배열 arr이 있습니다.
// 당신은 이 arr을 쿼드 트리와 같은 방식으로 압축하고자 합니다. 구체적인 방식은 다음과 같습니다.
//
//당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
//만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킵니다.
//그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역(입출력 예를 참고해주시기 바랍니다.)
// 으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.
//arr이 매개변수로 주어집니다. 위와 같은 방식으로 arr을 압축했을 때, 배열에 최종적으로
// 남는 0의 개수와 1의 개수를 배열에 담아서 return 하도록 solution 함수를 완성해주세요.

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
