package codingTestPractice.ETC.lv5;

import java.util.Arrays;
import java.util.Stack;

public class P154539 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {9, 1, 5, 3, 6, 2};
        System.out.println("solution = " + Arrays.toString(solution.solution(numbers)));
    }
}

class Solution {
    public int[] solution(int[] numbers) {

        Stack<Integer> stack = new Stack<>(); // 인덱스 저장
        int[] answer = new int[numbers.length];

        // 왼쪽 -> 오른쪽 순회하면서 뒷큰수 못찾은 애를 스택에 넣음
        // 스택 맨위에 있는 값이 현재값보다 작으면 걔는 현재값이 뒷큰수다
        for(int i = 0; i< numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}