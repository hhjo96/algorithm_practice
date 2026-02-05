package codingTestPractice.ETC.lv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/12915

// 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
// 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
// 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면
// 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.

import java.util.Arrays;

// strings는 길이 1 이상, 50이하인 배열입니다.
// strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
// strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
// 모든 strings의 원소의 길이는 n보다 큽니다.
// 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
// "sun", "bed", "car"의 1번째 인덱스 값은 각각 "u", "e", "a" 입니다.
// 이를 기준으로 strings를 정렬하면 ["car", "bed", "sun"] 입니다.
public class P12915 {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        System.out.println("solution(strings) = " + Arrays.toString(solution(strings, n)));
    }

    public static String[] solution(String[] strings, int n) {

        Arrays.sort(strings, (a1, a2) -> {
            char c1 = a1.charAt(n);
            char c2 = a2.charAt(n);
            if(c1 == c2) {
                return a1.compareTo(a2);
            } else {
                return c1-c2;
            }
        });

        return strings;


    }

}
