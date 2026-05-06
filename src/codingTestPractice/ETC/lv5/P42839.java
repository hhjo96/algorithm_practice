package codingTestPractice.ETC.lv5;

import java.util.HashSet;
import java.util.Set;

public class P42839 {
    public static void main(String[] args) {

        System.out.println("solution(\"011\") = " + solution("011"));
    }
    public static int solution(String numbers) {

        Set<Integer> nums = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        dfs("", numbers, visited, nums);

        int answer = 0;

        // 만들어진 숫자들 중 소수 개수 세기
        for (int n : nums) {
            if (isPrime(n)) {
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(String current, String numbers,
                    boolean[] visited, Set<Integer> nums) {

        // current가 비어있지 않으면 숫자로 변환해서 저장
        // 예: "17" -> 17
        if (!current.equals("")) {
            nums.add(Integer.parseInt(current));
        }

        // 모든 숫자를 하나씩 붙여보기
        for (int i = 0; i < numbers.length(); i++) {

            // 아직 사용 안한 숫자라면
            if (!visited[i]) {

                // 사용 처리
                visited[i] = true;

                // 현재 숫자 뒤에 붙이기
                // 예: "1" -> "17"
                dfs(current + numbers.charAt(i),
                        numbers, visited, nums);

                // DFS 끝났으면 이 조합에서의 숫자는 다시 원상복구
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
