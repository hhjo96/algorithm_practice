package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/118667
// 길이가 같은 두 개의 큐를 나타내는 정수 배열 queue1, queue2가 매개변수로 주어집니다.
// 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수를 return 하도록 solution 함수를 완성해주세요.
// 단, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1을 return 해주세요.

import java.util.ArrayDeque;
import java.util.Queue;

public class P118667 {
    public static void main(String[] args) {

        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};
        System.out.println("solution(queue1, queue2) = " + solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {

        // 큐를 배열처럼 사용가능
        // 참고: Queue 하면 큐, Deque 하면 스택
        Queue<Integer> queue11 = new ArrayDeque<>();
        Queue<Integer> queue22 = new ArrayDeque<>();

        for(int i = 0; i< queue1.length; i++) {
            queue11.offer(queue1[i]);
        }

        for(int i = 0; i< queue2.length; i++) {
            queue22.offer(queue2[i]);
        }

        // 두 큐의 원소의 총합의 절반 = 각 큐의 합 이므로
        // 각 큐의 합 goal 계산(두 큐의 원소의 총합이 홀수면 바로 -1 리턴)
        long sum1 = 0;
        long sum2 = 0;
        long goal;

        for(int i = 0; i< queue1.length; i++) {
            sum1 += queue1[i];
        }
        for(int i = 0; i< queue2.length; i++) {
            sum2 += queue2[i];
        }

        if((sum1 + sum2) % 2 != 0) {
            return -1;
        } else {
            goal = (sum1 + sum2) / 2;
        }

        // goal 보다 큰 쪽에서 pop 하여 작은 쪽에 넣기를 반복
        // 횟수를 카운트하여 배열의 길이 * 3 만큼 값을 넣고빼고 했으면 -1 리턴
        // 갔다가 -> 한바퀴둘아서 -> 돌아온다 이므로 3배수
        for(int i = 0; i< queue1.length * 3; i++) {
            // i는 횟수
            int tmp;

            if(sum1 > goal) {
                tmp = queue11.poll();
                queue22.offer(tmp);
                sum1 -= tmp;
                sum2 += tmp;

            } else if(sum1 < goal) {
                tmp = queue22.poll();
                queue11.offer(tmp);
                sum1 += tmp;
                sum2 -= tmp;

            } else { // sum1 == goal 이라면
                return i;
            }
        }

        return -1;

    }
}
