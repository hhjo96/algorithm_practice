package codingTestPractice.ETC.lv4;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/131127
// XYZ 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여합니다.
// XYZ 마트에서는 회원을 대상으로 매일 한 가지 제품을 할인하는 행사를 합니다.
// 할인하는 제품은 하루에 하나씩만 구매할 수 있습니다. 알뜰한 정현이는 자신이 원하는 제품과 수량이
// 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려 합니다.
//예를 들어, 정현이가 원하는 제품이 바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개이며,
// XYZ 마트에서 14일간 회원을 대상으로 할인하는 제품이 날짜 순서대로 치킨, 사과, 사과, 바나나,
// 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나인 경우에 대해 알아봅시다.
// 첫째 날부터 열흘 간에는 냄비가 할인하지 않기 때문에 첫째 날에는 회원가입을 하지 않습니다.
// 둘째 날부터 열흘 간에는 바나나를 원하는 만큼 할인구매할 수 없기 때문에 둘째 날에도 회원가입을 하지 않습니다.
// 셋째 날, 넷째 날, 다섯째 날부터 각각 열흘은 원하는 제품과 수량이 일치하기 때문에 셋 중 하루에 회원가입을 하려 합니다.
//정현이가 원하는 제품을 나타내는 문자열 배열 want와 정현이가 원하는 제품의 수량을 나타내는 정수 배열 number,
// XYZ 마트에서 할인하는 제품을 나타내는 문자열 배열 discount가 주어졌을 때, 회원등록시 정현이가 원하는
// 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return 하는 solution 함수를 완성하시오.
// 가능한 날이 없으면 0을 return 합니다.
public class P131127 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));
    }
    public static int solution(String[] want, int[] number, String[] discount) {

        // want: 원하는 제품, number: 수량, discount: 할인하느 제품

        int answer = 0;
        int index = 0; // 현재 시작 위치 저장

        // 원하는 제품과 수량을 맵에 저장
        Map<String ,Integer> wantMap = new HashMap<>();
        for(int i = 0; i< number.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 현재 맨앞 10개를 맵으로 만들기
        Map<String ,Integer> currentMap = new HashMap<>();
        for(int i = 0; i< 10; i++) {
            currentMap.put(discount[i], currentMap.getOrDefault(discount[i], 0) + 1);
        }

        // 두 맵을 비교하기(서로 같을경우 카운트++)
        while(index <= discount.length - 10) {
            boolean isValid = true;

            for (String key : wantMap.keySet()) {
                // 현재10개 중 개수랑 내가 원하는 물건 리스트의 개수
                if (currentMap.getOrDefault(key, 0) != wantMap.get(key)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                answer++;

            }

            // 맨마지막이라면 더 넣을 값이 없으니 끝
            if (index == discount.length - 10) {
                break;
            }

            // 서로 같지 않을 경우 맨앞의 값을 빼고, 맨뒤에 1개 추가
            String removeItem = discount[index];
            currentMap.put(removeItem, currentMap.get(removeItem) - 1);

            if (currentMap.get(removeItem) == 0) {
                currentMap.remove(removeItem);
            }

            String addItem = discount[index+10];
            currentMap.put(addItem, currentMap.getOrDefault(addItem, 0) + 1);
            index++;
        }

        return answer;
    }

}
