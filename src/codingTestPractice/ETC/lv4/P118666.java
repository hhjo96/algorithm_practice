package codingTestPractice.ETC.lv4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/118666
//카카오 성격 유형 검사지
// 질문마다 판단하는 지표를 담은 1차원 문자열 배열 survey와 검사자가 각 질문마다 선택한 선택지를 담은
// 1차원 정수 배열 choices가 매개변수로 주어집니다.
// 이때, 검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return 하도록 solution 함수를 완성해주세요.
public class P118666 {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println("solution1(survey, choices) = " + solution1(survey, choices));
        System.out.println("solution2(survey, choices) = " + solution2(survey, choices));
        System.out.println("solution3(survey, choices) = " + solution3(survey, choices));

    }

    public static String solution1(String[] survey, int[] choices) {

        int[] score = new int[8];
        Arrays.fill(score, 0);

        for(int i = 0; i < choices.length; i++) {

            int userAnswer = choices[i];
            int index = -1;

            if(survey[i].equals("RT")) {
                index = 0;
            } else if(survey[i].equals("FC")) {
                index = 2;
            } else if(survey[i].equals("MJ")) {
                index = 4;
            } else if(survey[i].equals("AN")) {
                index = 6;
            } else if(survey[i].equals("TR")) {
                index = 1;
            } else if(survey[i].equals("CF")) {
                index = 3;
            } else if(survey[i].equals("JM")) {
                index = 5;
            } else if(survey[i].equals("NA")) {
                index = 7;
            }

            int point = getScore(userAnswer);

            if(userAnswer >= 5) {
                if(index % 2 == 0) {
                    index++;
                } else {
                    index--;
                }
            }

            score[index] += point;
        }

        return getType(score);
    }

    public static int getScore(int userAnswer) {
        switch(userAnswer) {
            case 1, 7: return 3;
            case 2, 6: return 2;
            case 3, 5: return 1;
            case 4: return 0;
        }
        return 0;
    }

    public static String getType(int[] score) {
        StringBuilder sb = new StringBuilder();

        if(score[0] >= score[1]) sb.append("R");
        else sb.append("T");

        if(score[2] > score[3]) sb.append("F");
        else sb.append("C");

        if(score[4] > score[5]) sb.append("M");
        else sb.append("J");

        if(score[6] >= score[7]) sb.append("A");
        else sb.append("N");

        return sb.toString();
    }


    public static String solution2(String[] survey, int[] choices) {

        Map<Character, Integer> map = new HashMap<>();

        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int choice = choices[i];

            if (choice < 4) {
                map.put(first, map.get(first) + (4 - choice));
            } else if (choice > 4) {
                map.put(second, map.get(second) + (choice - 4));
            }
        }

        String answer = "";

        answer += map.get('R') >= map.get('T') ? "R" : "T";
        answer += map.get('C') >= map.get('F') ? "C" : "F";
        answer += map.get('J') >= map.get('M') ? "J" : "M";
        answer += map.get('A') >= map.get('N') ? "A" : "N";

        return answer;
    }


    public static String solution3(String[] survey, int[] choices) {

        int[] score = new int[26];  // 알파벳 점수 저장

        for (int i = 0; i < survey.length; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            int choice = choices[i];

            if (choice < 4) {
                score[a - 'A'] += 4 - choice;
            } else if (choice > 4) {
                score[b - 'A'] += choice - 4;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(score['R'-'A'] >= score['T'-'A'] ? 'R' : 'T');
        sb.append(score['C'-'A'] >= score['F'-'A'] ? 'C' : 'F');
        sb.append(score['J'-'A'] >= score['M'-'A'] ? 'J' : 'M');
        sb.append(score['A'-'A'] >= score['N'-'A'] ? 'A' : 'N');

        return sb.toString();
    }
}
