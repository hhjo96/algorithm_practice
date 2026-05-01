package codingTestPractice.ETC.lv5;

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
