package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/155651

// 호텔을 운영 중인 코니는 최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다.
// 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용할 수 있습니다.
//예약 시각이 문자열 형태로 담긴 2차원 배열 book_time이 매개변수로 주어질 때,
// 코니에게 필요한 최소 객실의 수를 return 하는 solution 함수를 완성해주세요.

import java.util.Arrays;
import java.util.PriorityQueue;

public class P155651 {
    public static void main(String[] args) {

        String[][] book_time = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
        System.out.println(solution(book_time));
    }

    public static int solution(String[][] book_time) {

        // 시간을 분 단위로 바꿔서 저장할 배열
        int[][] times = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {

            // 시작 시간
            String[] start = book_time[i][0].split(":");
            times[i][0] = Integer.parseInt(start[0]) * 60
                    + Integer.parseInt(start[1]);

            // 종료 시간 + 청소시간 10분
            String[] end = book_time[i][1].split(":");
            times[i][1] = Integer.parseInt(end[0]) * 60
                    + Integer.parseInt(end[1])
                    + 10;
        }

        // 시작 시간 기준 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        // 각 방이 언제 비는지 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] time : times) {

            int start = time[0];
            int end = time[1];

            // 가장 빨리 비는 방이 현재 예약 시작시간보다
            // 먼저(또는 같은 시각에) 비어있다면 재사용 가능
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            // 현재 예약을 방 하나에 배정
            pq.offer(end);
        }

        // 사용 중인 방 개수 = 필요한 최소 객실 수
        return pq.size();
    }
}
