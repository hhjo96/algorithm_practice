package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165
// 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
// 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

public class P43165 {
    
    static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};

        System.out.println("solution() = " + solution(numbers, 4));
    }

    public static int solution(int[] numbers, int target) {

        int current = 0;
        int sum = 0;
        dfs(numbers, target, current, sum);
        return answer;
    }

    public static void dfs(int[] numbers, int target, int current, int sum) {
        // 끝났을 때
        if(numbers.length == current) {
            if(sum == target) {
                answer++;
            }
            return;
        }

        // 현재 숫자를 더하는 경우
        dfs(numbers, target, current + 1, sum + numbers[current]);

        // 현재 숫자를 빼는 경우
        dfs(numbers, target, current + 1, sum - numbers[current]);
    }
}
