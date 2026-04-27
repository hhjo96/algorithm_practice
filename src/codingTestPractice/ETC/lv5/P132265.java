package codingTestPractice.ETC.lv5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P132265 {
    public static void main(String[] args) {

        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println("solution1(topping) = " + solution(topping));
    }

    //
    public static int solution(int[] topping) {
        // 오른쪽 map 에서 원소를 왼쪽 set으로 하나씩 이동
        // rightCount: 각 토핑이 몇개있는지 저장 1,1/2,2 이런식으로
        Map<Integer, Integer> rightCount = new HashMap<>();
        Set<Integer> leftSet = new HashSet<>();
        int count = 0;

        // 오른쪽에 전체 원소 세팅
        for (int t : topping) {
            // key, value, remapping function 순서
            // key 가 없으면 value를 넣고, key가 있으면 기존값과 value를 합침
            // 즉 key가 있으면 +1 하고 없으면 그냥 1을 넣는 것
            // rightCount.put(t, rightCount.getOrDefault(t, 0) + 1); 와 같은 표현임
            rightCount.merge(t, 1, Integer::sum);
        }

        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];
            leftSet.add(t);
            rightCount.merge(t, -1, Integer::sum);
            if (rightCount.get(t) == 0) rightCount.remove(t);

            if (leftSet.size() == rightCount.size()) count++;
        }

        return count;

    }
}
