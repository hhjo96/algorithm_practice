package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/148653
// 마법의 세계에 사는 민수는 아주 높은 탑에 살고 있습니다. 탑이 너무 높아서 걸어 다니기 힘든 민수는
// 마법의 엘리베이터를 만들었습니다. 마법의 엘리베이터의 버튼은 특별합니다. 마법의 엘리베이터에는
// -1, +1, -10, +10, -100, +100 등과 같이 절댓값이 10c (c ≥ 0 인 정수) 형태인 정수들이 적힌
// 버튼이 있습니다. 마법의 엘리베이터의 버튼을 누르면 현재 층 수에 버튼에 적혀 있는 값을 더한 층으로
// 이동하게 됩니다. 단, 엘리베이터가 위치해 있는 층과 버튼의 값을 더한 결과가 0보다 작으면 엘리베이터는
// 움직이지 않습니다. 민수의 세계에서는 0층이 가장 아래층이며 엘리베이터는 현재 민수가 있는 층에 있습니다.
//마법의 엘리베이터를 움직이기 위해서 버튼 한 번당 마법의 돌 한 개를 사용하게 됩니다.예를 들어,
// 16층에 있는 민수가 0층으로 가려면 -1이 적힌 버튼을 6번, -10이 적힌 버튼을 1번 눌러 마법의 돌
// 7개를 소모하여 0층으로 갈 수 있습니다. 하지만, +1이 적힌 버튼을 4번, -10이 적힌 버튼 2번을 누르면
// 마법의 돌 6개를 소모하여 0층으로 갈 수 있습니다.
//마법의 돌을 아끼기 위해 민수는 항상 최소한의 버튼을 눌러서 이동하려고 합니다. 민수가 어떤 층에서
// 엘리베이터를 타고 0층으로 내려가는데 필요한 마법의 돌의 최소 개수를 알고 싶습니다.
// 민수와 마법의 엘리베이터가 있는 층을 나타내는 정수 storey 가 주어졌을 때, 0층으로 가기 위해
// 필요한 마법의 돌의 최소값을 return 하도록 solution 함수를 완성하세요.

public class P148653 {
    public static void main(String[] args) {

        System.out.println(solution(2554));
    }

    public static int solution(int storey) {
        // 5일때는 앞자리 숫자 보고 결정, 1~4는 빼기 6~9는 더하기
        int answer = 0;

        while (storey > 0) {
            int digit = storey % 10;          // 현재 일의 자리
            int nextDigit = (storey / 10) % 10; // 다음 자리

            if (digit < 5) {
                // 그냥 내려가는 게 이득
                answer += digit;
                storey -= digit;
            } else if (digit > 5) {
                // 올라가서 다음 자리로 올림하는 게 이득
                answer += 10 - digit;
                storey += 10 - digit;
            } else {
                // digit == 5일 때는 다음 자리 보고 결정
                if (nextDigit >= 5) {
                    // 다음 자리가 크면 올림
                    answer += 5;
                    storey += 5;
                } else {
                    // 다음 자리가 작으면 내림
                    answer += 5;
                    storey -= 5;
                }
            }

            // 현재 일의 자리는 0이 되었으니 다음 자리로 이동
            storey /= 10;
        }

        return answer;
    }

}
