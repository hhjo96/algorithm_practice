package codingTestPractice.ETC.lv4;

// https://school.programmers.co.kr/learn/courses/30/lessons/12953

// 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는
// 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다.
// 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
// n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수,
// solution을 완성해 주세요.

public class P12953 {
    public static void main(String[] args) {
        int[] arr = {6, 10, 15};
        System.out.println("solution(arr) = " + solution(arr));
    }

    public static int solution(int[] arr) {
        int answer = arr[0];


        // 여러 수의 최소공배수는 공통 최대공약수로 해결되지 않으므로 두개씩 짝지어서 계산해야 함
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    // 최소공배수
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // 최대공약수(유클리드 호제법)
    // 공식 이용 gcd(48, 18) = gcd(18, 12)
    // 48 = 18 * 2 + 12 이므로 나머지를 뒤에 붙이기
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
