package codingTestPractice.ETC.lv4;

// https://school.programmers.co.kr/learn/courses/30/lessons/12945
// 피보나치 수는 F(0) = 0, F(1) = 1일 때,
// 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
// 2 이상의 n이 입력되었을 때,
// n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

public class P12945 {
    public static void main(String[] args) {
        System.out.println("solution1(100000) = " + solution1(100000));
        System.out.println("solution2(100000) = " + solution2(100000));

    }

    // 배열 쓰고 풀기
    public static int solution1(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }

    //배열 안쓰고 풀기
    public static int solution2(int n) {

        int a = 0;
        int b = 1;
        int c;

        if(n == 1) return 1;
        else if(n == 0) return 0;
        else {
            for(int i = 2; i<=n; i++) {
                c = (a+b)%1234567;
                a = b;
                b = c;
            }
        }
        return b;
    }
}
