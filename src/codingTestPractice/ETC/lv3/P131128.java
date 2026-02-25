package codingTestPractice.ETC.lv3;

public class P131128 {
    public static void main(String[] args) {
        String X = "5525";
        String Y = "1255";
        System.out.println("solution(X, Y) = " + solution(X, Y));
    }
    public static String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        //0부터 9까지 각 숫자가 몇 번 나오는지 카운트

        int[] countX = new int[11];
        int[] countY = new int[11];

        countX = count(X);
        countY = count(Y);

        for(int i = 9; i>=0; i--) {
            for(int j = 0; j < Math.min(countX[i], countY[i]); j++) {
                sb.append(i);
            }
        }

        if(sb.length() == 0) {
            return "-1";
        }
        if(sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }

    public static int[] count(String S) {
        int[] temp = new int[11];
        for(int i = 0; i<S.length(); i++) {
            switch(S.charAt(i)) {
                case '1': temp[1]++; break;
                case '2': temp[2]++; break;
                case '3': temp[3]++; break;
                case '4': temp[4]++; break;
                case '5': temp[5]++; break;
                case '6': temp[6]++; break;
                case '7': temp[7]++; break;
                case '8': temp[8]++; break;
                case '9': temp[9]++; break;
                case '0': temp[0]++; break;
                default: break;
                // 이 스위치 문을 temp[S.charAt(i)-'0']++; 로도 바꿀 수 있다.
            }
        }
        return temp;
    }
}
