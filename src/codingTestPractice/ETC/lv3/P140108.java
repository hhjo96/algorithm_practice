package codingTestPractice.ETC.lv3;

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
