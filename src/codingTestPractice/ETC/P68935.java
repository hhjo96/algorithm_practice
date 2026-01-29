package codingTestPractice.ETC;

import java.util.Random;

//https://school.programmers.co.kr/learn/courses/30/lessons/68935
//자연수 n이 매개변수로 주어집니다.
// n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
public class P68935 {
    public static void main(String[] args) {

        Random random = new Random();
        int n = random.nextInt(100000000) + 1;

        System.out.println("solution(n) = " + solution(n));
    }

    public static int solution(int n) {

        StringBuilder sb = new StringBuilder();

        // 1. 3진법으로 변환 + 뒤집기
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        //이렇게만 하면 뒤집힌 상태로 나옴

        // 2. 뒤집힌 3진수를 10진수로 변환
        // 3 쓰면 이 문자열이 3진수라고 알려줄 수 있음. 그럼 자바가 알아서 10진수 변환
        return Integer.parseInt(sb.toString(), 3);

    }

}
