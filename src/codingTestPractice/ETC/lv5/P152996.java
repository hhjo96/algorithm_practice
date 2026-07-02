package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/152996
// 어느 공원 놀이터에는 시소가 하나 설치되어 있습니다. 이 시소는 중심으로부터 2(m), 3(m), 4(m) 거리의 지점에
// 좌석이 하나씩 있습니다.
//이 시소를 두 명이 마주 보고 탄다고 할 때, 시소가 평형인 상태에서 각각에 의해 시소에 걸리는 토크의 크기가
// 서로 상쇄되어 완전한 균형을 이룰 수 있다면 그 두 사람을 시소 짝꿍이라고 합니다. 즉, 탑승한 사람의 무게와
// 시소 축과 좌석 간의 거리의 곱이 양쪽 다 같다면 시소 짝꿍이라고 할 수 있습니다.
//사람들의 몸무게 목록 weights이 주어질 때, 시소 짝꿍이 몇 쌍 존재하는지 구하여 return 하도록
// solution 함수를 완성해주세요.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P152996 {
    public static void main(String[] args) {

        int[] weights = {100, 180, 360, 100, 270};
        System.out.println("solution1() = " + solution1(weights));
        System.out.println("solution2() = " + solution2(weights));

    }

    public static long solution1(int[] weights) {
        // 쌍 개수
        long answer = 0;

        Arrays.sort(weights);

        // 몸무게, 그 몸무게인 사람 수
        Map<Integer, Long> map = new HashMap<>();

        for (int weight : weights) {

            // 같은 무게
            // 있으면 가져오고 없으면 0
            answer += map.getOrDefault(weight, 0L);

            // 현재 weight가 더 무거운 쪽이라고 생각
            if (weight % 2 == 0) {
                answer += map.getOrDefault(weight / 2, 0L);      // 2:4
            }

            if (weight * 2 % 3 == 0) {
                answer += map.getOrDefault(weight * 2 / 3, 0L);  // 2:3
            }

            if (weight * 3 % 4 == 0) {
                answer += map.getOrDefault(weight * 3 / 4, 0L);  // 3:4
            }

            // 기존에 있던 사람이랑 짝이 되는지를 먼저 확인하고 맵에 넣어야 함
            // 안그러면 자기자신이랑 짝을 이루는 경우를 세게 됨
            map.put(weight, map.getOrDefault(weight, 0L) + 1);
        }

        return answer;
    }

    public static long solution2(int[] weights) {

        Arrays.sort(weights);

        long answer = 0;

        // 무게가 100부터 1000까지이므로
        // 인덱스: 무게, 값: 사람 수
        int[] cnt = new int[1001];

        for (int weight : weights) {

            // 같은 무게
            answer += cnt[weight];

            // 2:4
            if (weight % 2 == 0) {
                answer += cnt[weight / 2];
            }

            // 2:3
            if (weight * 2 % 3 == 0) {
                answer += cnt[weight * 2 / 3];
            }

            // 3:4
            if (weight * 3 % 4 == 0) {
                answer += cnt[weight * 3 / 4];
            }

            cnt[weight]++;
        }

        return answer;
    }
}
