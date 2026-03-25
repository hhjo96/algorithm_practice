package codingTestPractice.ETC.lv4;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42842
// Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
// 그림 생략
// Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
// 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

public class P42842 {
    public static void main(String[] args) {

        int brown = 24;
        int yellow = 24;
        System.out.println("solution1(brown, yellow) = " + Arrays.toString(solution1(brown, yellow)));
        System.out.println("solution2(brown, yellow) = " + Arrays.toString(solution2(brown, yellow)));

    }

    public static int[] solution1(int brown, int yellow) {

        //전체 사이즈를 x * y 라고 하면
        //노란색: (x-2) (y-2)
        //갈색은 나머지
        //노란색의 약수 쌍을 가지고 계산
        int[] answer = new int[2];

        for(int i = 1; i<= Math.sqrt(yellow); i++) {
            int x;
            int y;
            if(yellow % i == 0) {
                x = (yellow/i)+2;
                y = i+2;
                if(x*y - brown - yellow == 0){
                    answer[0] = x;
                    answer[1] = y;
                }
            }
        }
        return answer;
    }

    public static int[] solution2(int brown, int yellow) {
        int total = brown + yellow;

        for (int h = 3; h <= Math.sqrt(total); h++) {
            if (total % h == 0) {
                int w = total / h;

                if ((w - 2) * (h - 2) == yellow) {
                    return new int[]{w, h};
                }
            }
        }
        return new int[0];
    }
}
