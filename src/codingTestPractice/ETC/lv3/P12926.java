package codingTestPractice.ETC.lv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/12926
//어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
// 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
// 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
// 공백은 아무리 밀어도 공백입니다.
// s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
//s 의 길이는 8000이하입니다.
// n은 1 이상, 25이하인 자연수입니다.
public class P12926 {
    public static void main(String[] args) {
        //String 연산을 하기 위해 스트링빌더를 사용하고
        String s = "Aa b";
        int n = 3;

        //여기서부터 로직
        StringBuilder sb = new StringBuilder();

        // (c-'a'+n): a기준으로 0~25로 바꾼 후 n만큼 이동하고
        //%26 해서 알파벳 범위 안으로 돌아오게 하고 다시 a를 더한다.
        for(char c: s.toCharArray()) {
            if(c>= 'A' && c<='Z') {
                sb.append((char)((c-'A'+n)%26+'A'));
            } else if(c>= 'a' && c<='z'){
                sb.append((char)((c-'a'+n)%26+'a'));
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());

    }
}
