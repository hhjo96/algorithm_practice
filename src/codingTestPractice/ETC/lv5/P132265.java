package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265

// 철수는 롤케이크를 두 조각으로 잘라서 동생과 한 조각씩 나눠 먹으려고 합니다.
// 이 롤케이크에는 여러가지 토핑들이 일렬로 올려져 있습니다. 철수와 동생은 롤케이크를 공평하게
// 나눠먹으려 하는데, 그들은 롤케이크의 크기보다 롤케이크 위에 올려진 토핑들의 종류에 더 관심이 많습니다.
// 그래서 잘린 조각들의 크기와 올려진 토핑의 개수에 상관없이 각 조각에 동일한 가짓수의 토핑이
// 올라가면 공평하게 롤케이크가 나누어진 것으로 생각합니다.
// 롤케이크에 올려진 토핑들의 번호를 저장한 정수 배열 topping이 매개변수로 주어질 때,
// 롤케이크를 공평하게 자르는 방법의 수를 return 하도록 solution 함수를 완성해주세요.

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
