package codingTestPractice.ETC.lv5;

public class P62048 {
    public static void main(String[] args) {

        System.out.println("solution(8, 12) = " + solution(8, 12));
    }
    public static long solution(int w, int h) {

        // 기준: 최대공약수
        long total = (long) w * h;
        long broken = w + h - gcd(w, h);

        return total - broken;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
