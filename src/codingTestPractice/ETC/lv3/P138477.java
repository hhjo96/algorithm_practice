package codingTestPractice.ETC.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/138477
// "명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 시청자들의 문자 투표수로 가수에게 점수를 부여합니다.
// 매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념합니다.
// 즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다.
// k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면,
// 출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.
//이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다.
// 예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면,
// 명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.
//명예의 전당 목록의 점수의 개수 k, 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때,
// 매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.
public class P138477 {
    public static void main(String[] args) {
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        System.out.println("solution(score) = " + Arrays.toString(solution(4, score)));
    }
    public static int[] solution(int k, int[] score) {
        List<Integer> temp = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        //k가 score의 길이보다 길 경우 대비
        int limit = Math.min(k, score.length);


        //초기값 세팅
        for(int i = 0; i<limit; i++) {
            temp.add(score[i]);
            temp.sort(Comparator.naturalOrder());
            answer.add(temp.get(0));
        }

        for(int i = limit; i<score.length; i++) {
            //개수가 k개 이상인 경우 넣어 보고 순서대로 정렬한 다음 제일 앞의 수를 제거, 그다음 수가 최하위 점수임
            temp.add(score[i]);
            temp.sort(Comparator.naturalOrder());
            temp.remove(0);
            answer.add(temp.get(0));
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
