package codingTestPractice.ETC.lv3;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/77484
//민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다.
// 이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
//순위	당첨 내용
//1	6개 번호가 모두 일치
//2	5개 번호가 일치
//3	4개 번호가 일치
//4	3개 번호가 일치
//5	2개 번호가 일치
//6(낙첨)	그 외
public class P77484 {
    public static void main(String[] args) {
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        System.out.println("Arrays.toString(solution(lottos, win_nums)) = " + Arrays.toString(solution(lottos, win_nums)));

        lottos = new int[]{44, 1, 0, 0, 31, 25};
        win_nums = new int[]{31, 10, 45, 1, 6, 19};
        System.out.println("Arrays.toString(solution(lottos, win_nums)) = " + Arrays.toString(solution(lottos, win_nums)));


    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        //lottos: 구매한것. 0포함
        //win_nums: 당첨번호


        int[] answer = new int[2];
        int zeros = 0;
        int lCount = 0;

        for(int num: lottos) {
            if(num == 0) {
                zeros++;
                continue;
            }
            for(int win: win_nums) {
                if(num == win) {
                    lCount++;
                }
            }
        }

        int max = lCount + zeros;
        int min = lCount;

        answer[0] = (max >= 2) ? 7 - max : 6;
        answer[1] = (min >= 2) ? 7 - min : 6;

        return answer;
    }
}
