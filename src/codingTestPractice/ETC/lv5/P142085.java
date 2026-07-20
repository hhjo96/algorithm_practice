package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/142085

// (규칙 생략)
// 준호가 처음 가지고 있는 병사의 수 n, 사용 가능한 무적권의 횟수 k, 매 라운드마다 공격해오는
// 적의 수가 순서대로 담긴 정수 배열 enemy가 매개변수로 주어집니다.
// 준호가 몇 라운드까지 막을 수 있는지 return 하도록 solution 함수를 완성해주세요.

import java.util.PriorityQueue;

public class P142085 {
    public static void main(String[] args) {

        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        System.out.println("solution(7, 3, enemy) = " + solution(7, 3, enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
        // n: 처음 병사
        // enemy[i] 만큼의 적 등장. 병사랑 1:1 소모
        // 무적권: 병사소모 X, k번 사용 가능

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 무적권으로 막은 값들 저장

        for (int i = 0; i < enemy.length; i++) {
            if (pq.size() < k) {
                // 아직 무적권 여유가 있으면, 병사 소모 없이 바로 무적권 사용
                pq.offer(enemy[i]);
            } else if (!pq.isEmpty() && pq.peek() < enemy[i]) {
                // 무적권은 큰 수에 써야 이득이므로,
                // 기존에 무적권 썼던 것 중 가장 작은 수는 병사 수로 복구(소모)하고
                // 지금 온 더 큰 적한테 무적권을 넘겨줌
                n -= pq.poll();
                pq.offer(enemy[i]);

                // 병사 수가 음수가 되면 더 이상 진행 불가
                if (n < 0) return i; // 여기까지 진행한 라운드 수
            } else {
                // 무적권 교체할 가치가 없으면 그냥 병사로 막음
                n -= enemy[i];

                // 병사 수가 음수가 되면 더 이상 진행 불가
                if (n < 0) return i; // 여기까지 진행한 라운드 수
            }
        }

        return enemy.length; // 모든 라운드 통과
    }
}
