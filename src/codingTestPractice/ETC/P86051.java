package codingTestPractice.ETC;

import java.util.Arrays;
import java.util.Random;

//https://school.programmers.co.kr/learn/courses/30/lessons/86051
//0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
// numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
public class P86051 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[random.nextInt(10)]; //0~9까지
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);

        int i = 0;
        for(int j = 0; j<= 9; j++) {
            //i: 012346780
            //j: 0123456789
            if(i< numbers.length && numbers[i] == j) {
                i++;
            } else {
                answer+=j;
            }
        }

        return answer;
    }
}
