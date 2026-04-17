package codingTestPractice.ETC.lv5;

//https://school.programmers.co.kr/learn/courses/30/lessons/92335
// 양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는
// 소수(Prime number)가 몇 개인지 알아보려 합니다.
//
//0P0처럼 소수 양쪽에 0이 있는 경우
//P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
//0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
//P처럼 소수 양쪽에 아무것도 없는 경우
//단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
//예를 들어, 101은 P가 될 수 없습니다.
//예를 들어, 437674을 3진수로 바꾸면 211020101011입니다. 여기서 찾을 수 있는 조건에 맞는 소수는
// 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다. (211, 2, 11을 k진법으로 보았을 때가 아닌,
// 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.)
// 211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.
//
//정수 n과 k가 매개변수로 주어집니다. n을 k진수로 바꿨을 때, 변환된 수 안에서
// 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.

public class P92335 {
    public static void main(String[] args) {

        System.out.println("solution(437674, 3) = " + solution(437674, 3));
    }

    /*
    1. 숫자 n을 k진수 문자열로 바꾼다
    2. 0을 기준으로 잘라서 숫자 조각들을 만든다
    3. 그 조각들 중 소수인 것의 개수를 센다
    */
    public static int solution(int n, int k) {
        int answer = 0;

        // 1) n을 k진수 문자열로 변환
        String converted = Integer.toString(n, k);

        // 2) 0을 기준으로 분리
        String[] parts = converted.split("0");

        // 3) 각 조각이 소수인지 확인
        for (String part : parts) {
            if (part.isEmpty()) continue; // 빈 문자열 제외

            long num = Long.parseLong(part);

            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    // 소수 판별 함수
    private static boolean isPrime(long num) {
        if (num < 2) return false;

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
