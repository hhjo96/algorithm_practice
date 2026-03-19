package codingTestPractice.ETC.lv4;

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
