package codingTestPractice.ETC.lv4;

// https://school.programmers.co.kr/learn/courses/30/lessons/138476
// 경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다.
// 그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때
// 서로 다른 종류의 수를 최소화하고 싶습니다.
//예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다.
// 경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면,
// 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.
//경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다.
// 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.

import java.util.*;

public class P138476 {
    public static void main(String[] args) {

        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println("solution1(4, tangerine) = " + solution1(4, tangerine));
        System.out.println("solution2(4, tangerine) = " + solution2(4, tangerine));

    }
    public static int solution1(int k, int[] tangerine) {
        // k: 한 상자에 담으려는 귤의 개수

        // 갯수를 세는 배열 만들기
        int max = tangerine[0];
        for(int i = 1; i< tangerine.length; i++) {
            if(max < tangerine[i]) {
                max = tangerine[i];
            }
        }
        int[] arr = new int[max+1];
        Arrays.fill(arr, 0);
        // 개수 세기
        for(int i = 0; i< tangerine.length; i++) {
            arr[tangerine[i]]++;
        }

        // 오름차순으로 정렬하고 k개만 상자에 담기
        Arrays.sort(arr);
        int i = arr.length -1 ;
        int kind = 0;
        while(true) {
            // 상자에 담을 귤이 제일 갯수가 많은 귤보다 작을 경우 그냥 그 종류의 귤만 담으면 됨
            if(k <= arr[i]) {
                kind++;
                break;
            } else {
                // 상자에 담을 귤이 제일 갯수가 많은 귤보다 클 경우 그 귤부터 담음
                k = k-arr[i];
                kind++;
                if(k <= 0) {
                    break;
                }
            }
            i--;
        }
        return kind;
    }

    public static int solution2(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        int kind = 0;

        for (int count : list) {
            k -= count;
            kind++;
            if (k <= 0) break;
        }

        return kind;
    }

}
