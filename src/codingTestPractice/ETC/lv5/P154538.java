package codingTestPractice.ETC.lv5;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/154538
// 자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
//
//x에 n을 더합니다
//x에 2를 곱합니다.
//x에 3을 곱합니다.
//자연수 x, y, n이 매개변수로 주어질 때,
// x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요.
// 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
public class P154538 {

    public static void main(String[] args) {
        System.out.println(solution1(10, 40, 30));
        System.out.println(solution2(10, 40, 30));

    }
    public static int solution1(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(new int[]{x, 0});
        visited.add(x);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0]; // 값
            int count = cur[1]; // 그값을 만들기위한 연산횟수

            if (num == y) return count;

            int[] next = {num + n, num * 2, num * 3}; // 다음으로 갈 수 있는 숫자들 만들기

            for (int nx : next) {
                if (nx <= y && !visited.contains(nx)) {
                    visited.add(nx);
                    q.add(new int[]{nx, count + 1});
                }
            }
        }

        return -1;
    }

    public static int solution2(int x, int y, int n) {
        // dp[i]: x에서 i까지 가는 최소 연산횟수. 따라서 dp[x] 가 시작점임
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            if (i + n <= y) {
                // x에서 i+n까지 가는 최소횟수는
                // 이미 알고있는 값인 x에서 i+n까지 가는 최소횟수랑 dp[i]까지 간 최소횟수 +1(+n 연산)중
                //최소값
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }

            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }

            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}
