package codingTestPractice.ETC;

//https://school.programmers.co.kr/learn/courses/30/lessons/12918
//문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
// 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
public class P12918 {
    public static void main(String[] args) {
        String s = "a234";
        System.out.println(solution1(s));
        System.out.println(solution2(s));
        System.out.println(solution3(s));

    }
    private static boolean solution1(String s) {
        return s.matches("\\d{4}|\\d{6}");
    }
    private static boolean solution2(String s) {
        if (s.length() != 4 && s.length() != 6) return false;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private static boolean solution3(String s) {

        boolean answer = true;
        char[] arr = s.toCharArray();

        int i = 0;

        if (s.length() != 4 && s.length() != 6) answer = false;

        if (s.length() == 4 || s.length() == 6) {
            while (true) {
                if (i == s.length()) break;
                if (arr[i] >= '0' && arr[i] <= '9') {
                    i++;
                    continue;
                } else {
                    answer = false;
                    break;
                }
            }

        }

        return answer;
    }
}
