package codingTestPractice.ETC.lv4;

import java.util.Stack;
public class P76502 {
    public static void main(String[] args) {

        System.out.println("solution(\"}]()[{\") = " + solution("}]()[{"));
    }

    // 괄호 문자열: 최근에 열린 괄호부터 닫혀야 함
    public static int solution(String s) {
        int length = s.length();
        int answer = 0;

        // 최초상태일때 올바른 괄호문자열인지 확인
        answer+=count(s);

        // 매 칸마다 회전하면서 올바른 괄호문자열인지 확인
        for(int i = 1; i<length; i++) {
            String newString = s.substring(i) + s.substring(0, i);
            answer+=count(newString);
        }
        return answer;
    }

    public static int count(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // ( { [ 없이  ) } ] 가 먼저 나온 경우
                if(stack.isEmpty()) return 0;

                // 새로 들어온 c가 닫는괄호이고 스택의 가장최근값이 여는괄호인지 확인
                char tmp = stack.pop();
                if((c == ')' && tmp != '(' ) || ( c == '}' && tmp != '{') || ( c == ']' && tmp != '[')) {
                    return 0;
                }

            }
        }
        return stack.isEmpty() ? 1 : 0;

    }
}
