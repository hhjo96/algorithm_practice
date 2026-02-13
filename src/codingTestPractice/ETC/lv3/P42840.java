package codingTestPractice.ETC.lv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/42840
//수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
// 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//
//1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
// 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//제한 조건
//시험은 최대 10,000 문제로 구성되어있습니다.
//문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P42840 {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        System.out.println("solution() = " + Arrays.toString(solution(answers)));
    }
    public static int[] solution(int[] answers) {
        //각 사람 패턴을 배열로 만들고 정답 개수 저장할 변수 생성
        int[] first = {1, 2, 3, 4, 5};
        int[] second = { 2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = new int[3];
        List<Integer> list = new ArrayList<>();

        //문제 번호에 따라 각 사람이 맞췄는지 검사
        for(int i = 0; i<answers.length; i++) {
            if(answers[i] == first[i%first.length]) {
                answer[0]++;
            }
            if(answers[i] == second[i%second.length]) {
                answer[1]++;
            }
            if(answers[i] == third[i%third.length]) {
                answer[2]++;
            }
        }

        //최댓값 구하기
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));

        //최댓값이 여러개인지 확인
        for(int i = 0; i<answer.length; i++) {
            if(answer[i] == max) {
                list.add(i+1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}
