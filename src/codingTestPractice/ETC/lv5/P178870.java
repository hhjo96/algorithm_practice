package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/178870
// 비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.
//기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
//부분 수열의 합은 k입니다.
//합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
//길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
//수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때,
// 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는
// solution 함수를 완성해주세요. 이때 수열의 인덱스는 0부터 시작합니다.
// 5 ≤ k ≤ 1,000,000,000

import java.util.Arrays;

public class P178870 {
    public static void main(String[] args) {

        int[] sequence = {1, 2, 3, 4, 5};
        System.out.println("solution1(7) = " + Arrays.toString(solution1(sequence, 7)));
        System.out.println("solution2(7) = " + Arrays.toString(solution2(sequence, 7)));

    }
    // 투 포인터로 풀기
    public static int[] solution1(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0;
        int sum = 0;

        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                int length = right - left;

                if (length < minLength) {
                    minLength = length;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }

        return answer;
    }


    // 로직은 맞으나 수가 큰 경우 타임아웃
    public static int[] solution2(int[] sequence, int k) {

        int[] answer = new int[2];

        int i = 1;
        int j = 0;
        int l = j;
        int sum = 0;

        // 길이
        for(i = 1; i<= sequence.length; i++) {
            // 인덱스
            for(j = 0; j + i <= sequence.length; j++) {
                sum = 0;
                for(l = j; l < j + i; l++) {
                    sum+=sequence[l];
                }
                if(sum== k) {
                    answer[0] = j;
                    answer[1] = j+i -1;
                    return answer;
                }
            }
        }
        return answer;
    }
}
