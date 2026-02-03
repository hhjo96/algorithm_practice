package codingTestPractice.ETC.lv3;

import java.util.Random;

//숫자로 이루어진 문자열 t와 p가 주어질 때, t에서 p와 길이가 같은 부분문자열 중에서,
// 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성하세요.
//예를 들어, t="3141592"이고 p="271" 인 경우, t의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592입니다.
// 이 문자열이 나타내는 수 중 271보다 작거나 같은 수는 141, 159 2개 입니다.

//1 ≤ p의 길이 ≤ 18
//p의 길이 ≤ t의 길이 ≤ 10,000
//t와 p는 숫자로만 이루어진 문자열이며, 0으로 시작하지 않습니다.

public class P147355 {
    public static void main(String[] args) {
        Random random = new Random();

        // 1 ~ 18
        int pLength = random.nextInt(18) + 1;

        // pLength ~ 10000
        int tLength = random.nextInt(10000 - pLength + 1) + pLength;

        String p = generateNumberString(pLength, random);
        String t = generateNumberString(tLength, random);

        System.out.println("p (" + p.length() + "): " + p);
        System.out.println("t (" + t.length() + "): " + t);
        System.out.println("solution(t, p) = " + solution(t, p));
    }

    private static String generateNumberString(int length, Random random) {
        StringBuilder sb = new StringBuilder(length);

        // 첫 자리는 1~9
        sb.append(random.nextInt(9) + 1);

        // 나머지는 0~9
        for (int i = 1; i < length; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
    
    public static int solution(String t,String p) {
        int count = 0;
        //부분문자열 만들기
        String[] tArray = new String[t.length()-p.length()+1];
        for(int i = 0; i< tArray.length; i++) {
            tArray[i] = t.substring(i, i+p.length());
        }

        for (int i = 0; i< tArray.length; i++) {
            if (tArray[i].compareTo(p) <= 0) {
                count++;

            }
        }
        return count;
    }
}
