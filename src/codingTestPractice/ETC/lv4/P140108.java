package codingTestPractice.ETC.lv4;

//https://school.programmers.co.kr/learn/courses/30/lessons/140108
// 문자열 s가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.
//먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.
//이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서,
// x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다. 처음으로 두 횟수가 같아지는 순간 멈추고,
// 지금까지 읽은 문자열을 분리합니다.
//s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.
//만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
//문자열 s가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고,
// 분해한 문자열의 개수를 return 하는 함수 solution을 완성하세요.
public class P140108 {
    public static void main(String[] args) {
        String s = "aaabbaccccabba";
        System.out.println(solution1(s));
        System.out.println(solution2(s));

    }

    public static int solution1(String s) {
        int answer = 0;
        String temp = s; // 문자열 분리하고 남은 문자열

        while(temp.length() > 0) {
            //초기화
            char x = temp.charAt(0);
            int[] count = {1, 0}; // 첫번째글자, 첫번재글자가아닌다른글자 개수 세기
            int i = 0;

            //x와 x가아닌글자들이 나온횟수 세기
            while(i < temp.length() -1 && count[0] != count[1]) {
                i++;
                if(x == temp.charAt(i)) {
                    count[0]++;
                } else {
                    count[1]++;
                }
            }
            answer++;
            if(i == temp.length()) {
                break;
            }
            else {
                temp = temp.substring(i+1, temp.length());
            }


        }
        return answer;
    }

    public static int solution2(String s) {

        int answer = 0;
        int same = 0; // x가나온횟수
        int diff = 0; // x가안나온횟수
        char x = ' ';

        for(int i = 0; i< s.length(); i++) {
            //맨처음
            if(same == 0) {
                x = s.charAt(i);
                same = 1;
                answer++;
                continue;
            }
            //x와 x가아닌글자 횟수 세기
            if(s.charAt(i) == x) {
                same++;
            } else {
                diff++;
            }

            //같아지면 초기화
            if(same == diff) {
                same = 0;
                diff = 0;
            }
        }
        return answer;
    }
}
