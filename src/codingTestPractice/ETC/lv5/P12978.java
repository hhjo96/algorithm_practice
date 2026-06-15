package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/12978
// N개의 마을로 이루어진 나라가 있습니다. 이 나라의 각 마을에는 1부터 N까지의 번호가 각각 하나씩 부여되어 있습니다.
// 각 마을은 양방향으로 통행할 수 있는 도로로 연결되어 있는데, 서로 다른 마을 간에 이동할 때는 이 도로를 지나야 합니다.
// 도로를 지날 때 걸리는 시간은 도로별로 다릅니다. 현재 1번 마을에 있는 음식점에서 각 마을로 음식 배달을 하려고 합니다.
// 각 마을로부터 음식 주문을 받으려고 하는데, N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 합니다.
// 마을의 개수 N, 각 마을을 연결하는 도로의 정보 road, 음식 배달이 가능한 시간 K가 매개변수로 주어질 때,
// 음식 주문을 받을 수 있는 마을의 개수를 return 하도록 solution 함수를 완성해주세요.

import java.util.Arrays;
import java.util.PriorityQueue;

public class P12978 {
    public static void main(String[] args) {

        int[][] road = {{1,2,1}, {1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        System.out.println(solution(6, road, 4));

    }

    public static int solution(int N, int[][] road, int K) {

        // n: 마을의개수, k: 배달제한시간
        // 각 마을까지의 최소 배달 시간 저장
        int[] dist = new int[N + 1];

        // 처음에는 무한대로 설정
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 1번 마을에서 시작하므로 0
        dist[1] = 0;

        // [현재까지 걸린 시간, 마을 번호]
        // 비용이 작은 것부터 꺼내라는 뜻
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 1});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int cost = current[0];
            int village = current[1];

            // 이미 더 짧은 경로가 있으면 스킵
            if (cost > dist[village]) {
                continue;
            }

            // 모든 도로 확인
            for (int[] r : road) {

                int nextVillage = 0;
                int nextCost = r[2];

                // 현재 마을과 연결된 도로인지 확인
                if (r[0] == village) {
                    nextVillage = r[1];
                } else if (r[1] == village) {
                    nextVillage = r[0];
                } else {
                    continue;
                }

                // 현재 마을까지 온 비용 + 다음 도로 비용
                int newCost = cost + nextCost;

                // 더 짧은 경로를 찾았다면 갱신
                if (newCost < dist[nextVillage]) {

                    dist[nextVillage] = newCost;

                    pq.offer(new int[]{
                            newCost,
                            nextVillage
                    });
                }
            }
        }

        // K 시간 이하로 배달 가능한 마을 수 세기
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}
