package codingTestPractice.ETC.lv3;

// https://school.programmers.co.kr/learn/courses/30/lessons/132267
// 콜라 빈 병 2개를 가져다주면 콜라 1병을 주는 마트가 있다. 빈 병 20개를 가져다주면 몇 병을 받을 수 있는가?
// 단, 보유 중인 빈 병이 2개 미만이면, 콜라를 받을 수 없다.
// 문제를 열심히 풀던 상빈이는 일반화된 콜라 문제를 생각했습니다.
// 이 문제는 빈 병 a개를 가져다주면 콜라 b병을 주는 마트가 있을 때,
// 빈 병 n개를 가져다주면 몇 병을 받을 수 있는지 계산하는 문제입니다.
// 기존 콜라 문제와 마찬가지로, 보유 중인 빈 병이 a개 미만이면, 추가적으로 빈 병을 받을 순 없습니다.
// 상빈이는 열심히 고심했지만, 일반화된 콜라 문제의 답을 찾을 수 없었습니다.
// 상빈이를 도와, 일반화된 콜라 문제를 해결하는 프로그램을 만들어 주세요.
//
//콜라를 받기 위해 마트에 주어야 하는 병 수 a, 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b,
// 상빈이가 가지고 있는 빈 병의 개수 n이 매개변수로 주어집니다.
// 상빈이가 받을 수 있는 콜라의 병 수를 return 하도록 solution 함수를 작성해주세요.
public class P132267 {
    public static void main(String[] args) {
        System.out.println("solution(3, 1, 20) = " + solution(3, 1, 20));
    }
    public static int solution(int a, int b, int n) {

        // n을 a로 나누어떨어지게 빼서 나머지를 구하고, n/a의 몫 * b만큼을 새로 받아온다
        // 위의 나머지랑 몫을 더한 다음 다시 a로 나누어떨어지게 빼서 나머지를 구하고, 몫*b 만큼 새로 받아온다.
        // 반복하여 n/a ==0 이 될때까지 반복한다. 

        int newA = a;
        int newB = b;
        int newN = n;
        int answer = 0;

        while(true) {
            int left = newN%newA;
            int newBottle = (newN/newA) * newB;
            answer+=newBottle;
            newN = newBottle + left;
            if(newN < a) break;
        }

        return answer;
    }
}
