package codingTestPractice.ETC.lv5;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/42883
// 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
//예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
// 이 중 가장 큰 숫자는 94 입니다.
//문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
// number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록
// solution 함수를 완성하세요.

public class P42883 {
    public static void main(String[] args) {

        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {

        // 앞자리 숫자가 커야 전체 수가 커지므로 현재 숫자보다 작은 이전숫자 제거
        Stack<Character> stack = new Stack<>();

        for(char c : number.toCharArray()) {

            // 작을 경우 제거
            while(!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        // k가 남아있는 경우 뒷 숫자 빼기
        while(k > 0) {
            stack.pop();
            k--;
        }

        // 남아있는 숫자 리턴
        StringBuilder sb = new StringBuilder();

        for(char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
