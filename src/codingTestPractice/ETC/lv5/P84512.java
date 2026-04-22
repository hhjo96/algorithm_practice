package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/84512
// 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는,
// 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며,
// 마지막 단어는 "UUUUU"입니다.
//
//단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지
// return 하도록 solution 함수를 완성해주세요.
// word의 길이는 1 이상 5 이하입니다.
// word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
public class P84512 {

    static String[] arr = {"A", "E", "I", "O", "U"};
    static int count = 0;
    static int answer = 0;
    static boolean found = false;


    public static void main(String[] args) {

        String word = "AAAAE";
        System.out.println("solution(word) = " + solution(word));
    }

    public static int solution(String word) {
        dfs("", word);
        return answer;
    }

    // 단어사전 만들기: a -> a에다가 a붙이기 -> 5개될때까지 a붙이기 -> 5개가 됐으면 마지막 a를 eiou 순으로 바꿈
    // -> 4개짜리로 개수를 줄여서 마지막 a를 eiou 순으로 바꾸기 ....
    // -> 2개짜리가 되면 ae ai ao au 후 e부터 반복
    public static void dfs(String current, String word) {
        if (found) return;

        // 빈 문자열 제외하고 카운트
        if (!current.equals("")) {
            count++;
            if (current.equals(word)) {
                answer = count;
                found = true;
                return;
            }
        }

        // 길이 5까지만
        if (current.length() == 5) return;

        for (int i = 0; i < 5; i++) {
            dfs(current + arr[i], word);
        }
    }
}
