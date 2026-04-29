package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/77885
// 양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.
//x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
// 정수들이 담긴 배열 numbers가 매개변수로 주어집니다. numbers의 모든 수들에 대하여
// 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.

import java.util.Arrays;

public class P77885 {
    public static void main(String[] args) {
        long[] numbers = {2, 7};
        System.out.println("solution1(numbers) = " + Arrays.toString(solution1(numbers)));
        System.out.println("solution2(numbers) = " + Arrays.toString(solution2(numbers)));

    }

    public static long[] solution1(long[] numbers) {

        // 오른쪽부터 처음 등장하는 0을 찾고
        // 맨뒤수가 0인경우(짝수) 그냥 걔만 바꾸면 끝
        // 맨뒤수가 0이 아닌경우 가장 오른쪽 0을 1로 바꾸고 그 오른쪽을 0으로 바꾸기
        long[] answers = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            if (n % 2 == 0) {
                answers[i] = numbers[i] + 1;
            } else {
                // bit: 가장 오른쪽에 있는 0 위치
                // n+1 로 오른쪽 연속된 1들을 0으로 싹 밀고
                // ~n으로 0과 1을 뒤집으면 맨처음 0자리만 살아남음
                // n  = 1011
                // n  = 1011
                // ~n = 0100
                // AND= 0100
                long bit = (~n) & (n + 1);
                // 0이 나오는 자리의 0을 1로 바꾸기(n + bit) 후
                // 바꿨던 자리 바로 오른쪽(0100 >> 1 == 0010)을 0으로 바꿈
                answers[i] = n + bit - (bit >> 1);

            }
        }
        return answers;
    }

    public static long[] solution2(long[] numbers) {

        // 오른쪽부터 처음 등장하는 0을 찾고
        // 맨뒤수가 0인경우(짝수) 그냥 걔만 바꾸면 끝
        // 맨뒤수가 0이 아닌경우 가장 오른쪽 0을 1로 바꾸고 그 오른쪽을 0으로 바꾸기
        long[] answers = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            if (n % 2 == 0) {
                answers[i] = numbers[i] + 1;
            } else {
                long temp = n;
                int idx = 0;

                while ((temp & 1) == 1) { // 둘다 1일 때만 1이므로 1과 & 연산하면 1이 나옴. 마지막 비트가 1인지 확인할 수 있게 됨
                    temp >>= 1; // 1이 나오면 temp를 오른쪽으로 밀기
                    idx++;
                }
                // 여기서 idx가 처음 0이 나온 위치이므로 idx에 있는 0을 1 로 바꾸고 그오른쪽숫자의1을 0으로 바꾸기

                // 인덱스 위치 idx 0 → 1
                // | 는 1만들기
                n = n | (1L << idx);

                // 1 → 0 인덱스-1위치 idx -1
                // & 는 0만들기
                n = n & ~(1L << (idx - 1));
                answers[i] = n;
            }
        }
        return answers;
    }
}
