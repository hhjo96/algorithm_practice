package codingTestPractice.ETC.lv5;

//https://school.programmers.co.kr/learn/courses/30/lessons/42746
//0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
//예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
// 이중 가장 큰 수는 6210입니다.
//0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는
// 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

import java.util.Arrays;

public class P42746 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }

    public static String solution(int[] numbers) {

        // string으로 바꾸기
        String[] str = new String[numbers.length];

        for(int i = 0; i< numbers.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }

        // 앞글자가 큰 순서대로 정렬
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder answer = new StringBuilder();

        for(int i = 0; i< str.length; i++) {
            answer.append(str[i]);
        }

        // 앞글자가 큰 순서대로 정렬했는데 맨앞이 0이라면
        if(answer.toString().startsWith("0")) {
            return "0";
        } else {
            return answer.toString();
        }
    }
}
