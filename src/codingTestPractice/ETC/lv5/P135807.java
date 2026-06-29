package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/135807
// 철수와 영희는 선생님으로부터 숫자가 하나씩 적힌 카드들을 절반씩 나눠서 가진 후, 다음 두 조건 중
// 하나를 만족하는 가장 큰 양의 정수 a의 값을 구하려고 합니다.
//철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고 영희가 가진 카드들에 적힌 모든 숫자들 중 하나도
// 나눌 수 없는 양의 정수 a
//영희가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, 철수가 가진 카드들에 적힌 모든 숫자들 중
// 하나도 나눌 수 없는 양의 정수 a
//예를 들어, 카드들에 10, 5, 20, 17이 적혀 있는 경우에 대해 생각해 봅시다. 만약, 철수가 [10, 17]이
// 적힌 카드를 갖고, 영희가 [5, 20]이 적힌 카드를 갖는다면 두 조건 중 하나를 만족하는 양의 정수 a는 존재하지 않습니다.
// 하지만, 철수가 [10, 20]이 적힌 카드를 갖고, 영희가 [5, 17]이 적힌 카드를 갖는다면,
// 철수가 가진 카드들의 숫자는 모두 10으로 나눌 수 있고, 영희가 가진 카드들의 숫자는 모두 10으로 나눌 수 없습니다.
// 따라서 철수와 영희는 각각 [10, 20]이 적힌 카드, [5, 17]이 적힌 카드로 나눠 가졌다면
// 조건에 해당하는 양의 정수 a는 10이 됩니다.
//철수가 가진 카드에 적힌 숫자들을 나타내는 정수 배열 arrayA와 영희가 가진 카드에 적힌 숫자들을
// 나타내는 정수 배열 arrayB가 주어졌을 때, 주어진 조건을 만족하는 가장 큰 양의 정수 a를 return하도록
// solution 함수를 완성해 주세요. 만약, 조건을 만족하는 a가 없다면, 0을 return 해 주세요.

public class P135807 {
    public static void main(String[] args) {

        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};
        System.out.println(solution(arrayA, arrayB));
    }
    public static int solution(int[] arrayA, int[] arrayB) {

        //배열A의 최대공약수 k1를 찾고, k1가 배열B의 수를 전부 나눌 수 없거나
        //배열B의 최대공약수 k2를 찾고, k2가 배열A의 수를 전부 나눌 수 없으면 됨

        int k1 = arrayA[0];
        int k2 = arrayB[0];
        int answer = 0;

        for(int i = 0; i< arrayA.length; i++) {
            k1 = gcd(arrayA[i], k1);
        }

        for(int i = 0; i< arrayB.length; i++) {
            k2 = gcd(arrayB[i], k2);
        }

        if (canUse(k1, arrayB)) {
            answer = Math.max(answer, k1);
        }

        if (canUse(k2, arrayA)) {
            answer = Math.max(answer, k2);
        }

        return answer;
    }


    public static int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static boolean canUse(int k, int[] otherArray) {

        for (int i = 0; i < otherArray.length; i++) {
            if (otherArray[i] % k == 0) {
                return false;
            }
        }

        return true;
    }
}
