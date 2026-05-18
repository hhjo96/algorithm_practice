package codingTestPractice.ETC.lv5;

import java.util.Stack;

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
