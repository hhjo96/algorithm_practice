package codingTestPractice.ETC.lv4;

// https://school.programmers.co.kr/learn/courses/30/lessons/12951
// JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
// 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
//문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

public class P12951 {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(solution(s));
    }

    public static String solution(String s) {

        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< s.length(); i++) {
            if(s.charAt(i) == ' '){
                flag = true;
                sb.append(Character.toLowerCase(s.charAt(i)));
                continue;
            }
            if(s.charAt(i) != ' ' && flag) {
                flag = false;
                sb.append(Character.toUpperCase(s.charAt(i)));
                continue;
            }
            sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }
}
