package codingTestPractice.ETC.lv3;

import java.util.Arrays;
import java.util.Random;

//두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
// 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
// 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
public class P12940 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(10) + 1;
        int m = random.nextInt(10) + 1;

        System.out.println(Arrays.toString(solution(n, m)));

    }
    public static int[]solution(int n, int m) {
        int[] answer = new int[2];

        int a = Math.max(n, m); // a가큰애
        int b = Math.min(n, m); // b가작은애

        //최대공약수 구하기
        int maxN = 1;
        for(int i = 1; i<=b; i++) {
            if(a%i == 0 && b % i == 0 && i> maxN) {
                maxN = i;
            }
        }

        //최소공배수 구하기: 공식이 있다고 함
        int minN = (a * b) / maxN;

        answer[0] = maxN;
        answer[1] = minN;

        return answer;
    }
}
