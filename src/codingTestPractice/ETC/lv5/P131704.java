package codingTestPractice.ETC.lv5;


import java.util.Stack;

public class P131704 {

    public static void main(String[] args) {

        int[] order = {4, 3, 1, 2, 5};
        System.out.println(solution(order));
    }

    public static int solution(int[] order) {
        // 벨트는 큐, 보조벨트는 스택
        // 벨트는 12345 순으로 놓여있고 1부터 꺼낼 수 있다
        Stack<Integer> stack = new Stack<>();

        // 박스번호
        int box = 1;
        int answer = 0;

        for (int target : order) {
            // 원하는 상자가 나올 때까지 컨베이어에서 꺼내서 보조벨트에 넣기(원하는 상자도 보조벨트에 갔다가 실음)
            while (box <= order.length && box <= target) {
                stack.push(box);
                box++;
            }

            // 보조벨트 맨 위가 원하는 상자면 실을 수 있음
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}
