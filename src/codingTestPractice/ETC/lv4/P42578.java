package codingTestPractice.ETC.lv4;

import java.util.HashMap;
import java.util.Map;

public class P42578 {
    public static void main(String[] args) {

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));

    }
    public static int solution(String[][] clothes) {

        // 옷을 종류별로 저장할 맵
        Map<String, Integer> cMap = new HashMap<>();

        // 정답 초기화: 옷의 개수만큼 일단 초기화(1벌 입은경우)
        int answer = 1;

        for(int i = 0; i< clothes.length; i++) {
            cMap.put(clothes[i][1], cMap.getOrDefault(clothes[i][1], 0) +1);
        }

        // 안입는경우까지 포함하여 sum(각파츠옷의개수 + 1) -1(아무것도안입는경우) 하면 됨
        for(int count : cMap.values()) {
            answer *= (count+1);
        }

        return answer-1;
    }
}
