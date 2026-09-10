package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/181187
// x축과 y축으로 이루어진 2차원 직교 좌표계에 중심이 원점인 서로 다른 크기의 원이 두 개 주어집니다.
// 반지름을 나타내는 두 정수 r1, r2가 매개변수로 주어질 때, 두 원 사이의 공간에 x좌표와 y좌표가 모두 정수인
// 점의 개수를 return하도록 solution 함수를 완성해주세요.
public class P181187 {
    public static void main(String[] args) {
        System.out.println(solution(2, 3));
    }

    public static long solution(int r1, int r2) {
        long answer = 0;

        for (long x = 1; x <= r2; x++) {
            // 내림
            long maxY = (long) Math.floor(
                    Math.sqrt((long) r2 * r2 - x * x)
            );

            long minY;

            if (x >= r1) {
                minY = 0;
            } else {
                // 올림
                minY = (long) Math.ceil(
                        Math.sqrt((long) r1 * r1 - x * x)
                );
            }

            answer += maxY - minY + 1;
        }

        return answer * 4;
    }
}
