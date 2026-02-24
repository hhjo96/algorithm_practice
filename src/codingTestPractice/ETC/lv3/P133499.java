package codingTestPractice.ETC.lv3;

// https://school.programmers.co.kr/learn/courses/30/lessons/133499
// 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다.
// 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는
// 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다.
// 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를
// return하도록 solution 함수를 완성해주세요.

public class P133499 {
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(solution1(babbling));
        System.out.println(solution2(babbling));

    }

    public static int solution1(String[] babbling) {
        int answer = 0;
        String[] baby = { "aya", "ye", "woo", "ma"};

        for(String s: babbling) {
            //연속 발음 막기
            if (s.contains(baby[0]+baby[0]) ||s.contains(baby[1]+baby[1])
                    ||s.contains(baby[2]+baby[2]) ||s.contains(baby[3]+baby[3])) {
                continue;
            }
            s = s.replace(baby[0], " ");
            s = s.replace(baby[1], " ");
            s = s.replace(baby[2], " ");
            s = s.replace(baby[3], " ");

            if (s.trim().equals("")) {
                answer++;
            }
        }
        return answer;
    }

    public static int solution2(String[] babbling) {
        int answer = 0;
        String[] baby = { "aya", "ye", "woo", "ma"};

        for(String s: babbling) {
            int pointer = 0;
            //연속 발음 막기
            if (s.contains(baby[0]+baby[0]) ||s.contains(baby[1]+baby[1])
                    ||s.contains(baby[2]+baby[2]) ||s.contains(baby[3]+baby[3])) {
                continue;
            }
            //
            String[] arr = s.split(baby[0] + "|" + baby[1] + "|" + baby[2] + "|" + baby[3]);

            for(int i = 0; i<arr.length; i++) {
                if(!arr[i].equals("")){
                    pointer++;
                }
            }
            if(pointer == 0) {
                answer++;
            }
        }
        return answer;
    }

}
