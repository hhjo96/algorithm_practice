package codingTestPractice.ETC.lv4;

//https://school.programmers.co.kr/learn/courses/30/lessons/12939
//문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
// str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의
// 문자열을 반환하는 함수, solution을 완성하세요.
//예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class P12939 {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        System.out.println(solution1(s));
        System.out.println(solution2(s));

    }

    public static String solution1(String s) {


        String[] splits = s.split(" ");
        int min = Integer.parseInt(splits[0]);
        int max = Integer.parseInt(splits[0]);
        String answer = "";

        for(int i = 1; i<splits.length; i++) {
            if(min > Integer.parseInt(splits[i])) {
                min = Integer.parseInt(splits[i]);
            }
            if(max < Integer.parseInt(splits[i])) {
                max = Integer.parseInt(splits[i]);
            }
        }
        answer+=min+ " "+max;

        return answer;
    }

    public static String solution2(String s) {
        IntSummaryStatistics stats = Arrays.stream(s.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .summaryStatistics();

        return stats.getMin() + " " + stats.getMax();
    }
}
