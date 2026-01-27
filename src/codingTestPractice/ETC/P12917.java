package codingTestPractice.ETC;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12917
//문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
public class P12917 {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(new Solution().solution(s));

    }
    public static class Solution {
        public String solution(String s) {
            if(s.length() == 1) return s;

            //기본 오름차순 정렬
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            return new StringBuilder(new String(arr)).reverse().toString();
        }
    }
}
