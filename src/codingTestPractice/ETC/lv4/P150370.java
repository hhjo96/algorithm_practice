package codingTestPractice.ETC.lv4;

// https://school.programmers.co.kr/learn/courses/30/lessons/150370

// 오늘 날짜를 의미하는 문자열 today, 약관의 유효기간을 담은 1차원 문자열 배열 terms와
// 수집된 개인정보의 정보를 담은 1차원 문자열 배열 privacies가 매개변수로 주어집니다.
// 이때 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return 하도록
// solution 함수를 완성해 주세요.

import java.util.*;

public class P150370 {
    public static void main(String[] args) {

        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println("solution() = " + Arrays.toString(solution(today, terms, privacies)));
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        //today: "2022.05.19"
        //terms: 약관의 유효기간(달 수) A 6
        //privacies: 개인정보 "2021.05.02 A"

        //한달이 28일이므로 날짜 배열을 숫자로 바꾼다

        int todays = Integer.parseInt(today.substring(0, 4)) * 12 * 28 +
                Integer.parseInt(today.substring(5, 7)) * 28 +
                Integer.parseInt(today.substring(8, 10));

        // a 6 으로 되어있는 terms를 처리하기 편하게 바꾼다
        Map<Character, Integer> newTerms = new HashMap<>();
        for(int i = 0; i<terms.length; i++) {
            String[] t = terms[i].split(" ");
            newTerms.put(t[0].charAt(0), Integer.parseInt(t[1]));
        }


        // 배열로 리턴할 때 쓸 arrayList
        List<Integer> answerT = new ArrayList<>();

        // 개인정보 배열을 돌면서 확인
        for(int i = 0; i< privacies.length; i++) {
            //termDays(유효기간) + 개인정보수집일자 <= today 인 경우 파기
            int termDays = newTerms.get(privacies[i].charAt(11)) * 28;
            int collectDays = Integer.parseInt(privacies[i].substring(0, 4)) * 12 * 28 +
                    Integer.parseInt(privacies[i].substring(5, 7)) * 28 +
                    Integer.parseInt(privacies[i].substring(8, 10));

            if((termDays + collectDays) <= todays) {
                answerT.add(i);
            }

        }

        return answerT.stream().mapToInt(i -> i+1).toArray();
    }
}
