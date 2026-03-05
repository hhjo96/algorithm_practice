package codingTestPractice.ETC.lv4;
// https://school.programmers.co.kr/learn/courses/30/lessons/155652
// 두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.
//
//문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
//index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
//skip에 있는 알파벳은 제외하고 건너뜁니다.
//예를 들어 s = "aukks", skip = "wbqd", index = 5일 때, a에서 5만큼 뒤에 있는 알파벳은 f지만
// [b, c, d, e, f]에서 'b'와 'd'는 skip에 포함되므로 세지 않습니다. 따라서 'b', 'd'를 제외하고
// 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다. 나머지 "ukks" 또한
// 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.
//
//두 문자열 s와 skip, 그리고 자연수 index가 매개변수로 주어질 때 위 규칙대로 s를 변환한 결과를 return하도록 solution 함수를 완성해주세요.
public class P155602 {
    public static void main(String[] args) {

        System.out.println("solution1(\"aukks\", \"wbqd\", 5) = " + solution1("aukks", "wbqd", 5));
        System.out.println("solution2(\"aukks\", \"wbqd\", 5) = " + solution2("aukks", "wbqd", 5));

    }

    public static String solution1(String s, String skip, int index) {

        //s 안에 있는 각 글자들을 cArr에 담고, cArr에서 한글자씩 꺼내서 skip에 있는 글자인지 확인 후
        //skip에 있는 글자면 증가카운트를 안세고, skip 에 없는 글자면 증가카운트를 세서
        //증가카운트를 index 가 될때까지 증가
        char[] cArr = s.toCharArray();
        boolean[] skipArr = new boolean[26];
        char[] answer = new char[s.length()];

        //boolean 배열 초기화(true 인 경우 사용불가)
        //기본 false인상태
        for(int i = 0; i<skip.length(); i++) {
            int temp = skip.charAt(i)-'a';
            skipArr[temp] = true;
        }

        for(int j = 0; j< cArr.length; j++) {
            int rSkips = 0;
            char c = cArr[j];
            while(rSkips < index) {
                //c++했을 때 z를 넘었나 확인
                c++;
                if(c > 'z') {
                    c = 'a';
                }

                //skip에 포함된 문자인지 검사하고 skip에 포함되었으면 증가 인덱스를 세지 않음
                if(!skipArr[c-'a']) {
                    rSkips++;
                }
            }
            answer[j] = c;
        }
        return new String(answer);
    }

    public static String solution2(String s, String skip, int index) {

        // skip에 포함된 글자들을 아예 뺀 alphabet 을 만들어서 체크
        String alphabet = "";

        for(char c = 'a'; c <= 'z'; c++){
            if(!skip.contains(String.valueOf(c))){
                alphabet += c;
            }
        }

        StringBuilder answer = new StringBuilder();

        for(char c : s.toCharArray()){
            int pos = alphabet.indexOf(c);
            int newPos = (pos + index) % alphabet.length();
            answer.append(alphabet.charAt(newPos));
        }

        return answer.toString();
    }
}
