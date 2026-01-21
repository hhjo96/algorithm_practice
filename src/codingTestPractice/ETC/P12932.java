package codingTestPractice.ETC;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// https://school.programmers.co.kr/learn/courses/30/lessons/12932
// 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
// n은 10,000,000,000이하인 자연수입니다.
public class P12932 {
    public static void main(String[] args) {
        long n = ThreadLocalRandom.current().nextLong(1, 10_000_000_001L);
        //하한 포함, 상한 미포함
        long[] answer = solution(n);
        System.out.println("n = " + n);
        for(long num : answer) {
            System.out.print(num + " ");
        }
    }
    public static long[] solution(long n) {

        //n이 몇자리수인지 확인
        String nCount = Long.toString(n);
        int nCounts = nCount.length();

        long[] answer = new long[nCounts];

        //현재 마지막 자리의 숫자 얻기
        for(int i = 0; i< nCounts; i++) {
            long num = n%10;
            answer[i] = num;
            n = n/10;
        }


        return answer;
    }
}
