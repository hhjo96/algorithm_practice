package codingTestPractice.ETC.lv4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P42587 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution1(priorities, 2));
    }

    public static int solution1(int[] priorities, int location) {

        // location에 주어진 프로세스가 몇번째로 실행되는지 저장
        int count = 0;

        // priorities: 우선순위숫자, location: 그 중 location번째 수
        // 큐에다가 (우선순위, 인덱스) 순으로 넣는다
        Queue<int[]> q = new LinkedList<>();

        // 우선순위, 인덱스
        for(int i = 0; i< priorities.length; i++) {
            int[] arr = {priorities[i], i};
            q.offer(arr);
        }

        // peek 보기만 poll 꺼내고삭제

        // 모든 수를 꺼내서 우선순위가 더 큰 게 없다면 꺼내고, 있다면 다시 넣는다
        // 꺼낼 때 인덱스가 location과 같다면 리턴
        while (!q.isEmpty()) {
            int[] current = q.poll();

            boolean hasHigher = false;

            // 우선순위가 더 큰게 있나 큐 전체 확인
            for (int[] item : q) {
                if (item[0] > current[0]) {
                    hasHigher = true;
                    break;
                }
            }

            // 더 큰게 있다면 도로 넣기
            if (hasHigher) {
                q.offer(current);
            } else { // 큰게 없다면 실행하고, 몇번째로 실행되는지 카운트
                count++;
                if (current[1] == location) {
                    return count;
                }
            }
        }

        // 실행되지 않는 리턴문
        return count;
    }

    public int solution(int[] priorities, int location) {

        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        // 기본 작은순으로 나오므로 큰순으로 나오게 reverseOrder
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 큐 + pq 둘 다 채우기
        // pq에는 우선순위만 넣음
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
            pq.offer(priorities[i]);
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();

            //  현재 최대값이랑 비교
            if (current[0] < pq.peek()) {
                q.offer(current);
            } else {
                count++;
                pq.poll(); //  최대값 제거

                if (current[1] == location) {
                    return count;
                }
            }
        }

        return count;
    }
}
