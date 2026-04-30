package codingTestPractice.ETC.lv5;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42583

// 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
// 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대
// bridge_length대 올라갈 수 있으며,다리는 weight 이하까지의 무게를 견딜 수 있습니다.
// 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
// solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length,
// 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
// 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

public class P42583 {
    public static void main(String[] args) {

        System.out.println("solution(2, 10, ) = " + solution(2, 10,
                new int[]{7, 4, 5, 6}
                ));


    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // 각 칸마다 무게를 넣음
        Queue<Integer> bridges = new LinkedList<>();

        // 다리 길이만큼 빈칸으로 채우기
        for(int i = 0; i< bridge_length; i++) {
            // add는 못넣으면 예외터짐. offer는 false 반환
            bridges.offer(0);
        }

        int time = 0;
        int currentWeight = 0;
        int idx = 0;
        while(idx < truck_weights.length) {
            time++;
            // 맨앞트럭 빼기

            currentWeight -= bridges.poll();

            // 다음트럭 올릴수있나보고 올리기
            if(currentWeight + truck_weights[idx] <= weight) {
                currentWeight += truck_weights[idx];
                bridges.offer(truck_weights[idx]);
                idx++;
            } else { // 다음거 못올리면
                bridges.offer(0);
            }
        }

        return time + bridge_length;
    }
}
