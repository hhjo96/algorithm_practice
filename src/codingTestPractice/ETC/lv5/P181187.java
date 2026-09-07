package codingTestPractice.ETC.lv5;

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
