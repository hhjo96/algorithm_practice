package codingTestPractice.ETC.lv4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P178871 {
    public static void main(String[] args) {

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(solution(players, callings)));
    }


        public static String[] solution(String[] players, String[] callings) {

            //맵으로 관리
            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i< players.length; i++) {
                map.put(players[i], i);
            }

            //callings 를 돌면서
            for(int i = 0; i< callings.length; i++) {
                // 추월한 애를 callled 에 저장
                // 추월당한 애를 front 에 저장
                String called = callings[i];
                int idx = map.get(called);
                String front = players[idx-1];

                //추월한 애와 추월당한 애의 순서 변경
                map.put(called, idx -1);
                map.put(front, idx);

                //배열에서도 변경
                players[idx-1] = called;
                players[idx] = front;

            }

            return players;
        }
}
