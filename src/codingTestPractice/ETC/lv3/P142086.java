package codingTestPractice.ETC.lv3;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/142086
//문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서,
// 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
//b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
//a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
//n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
//a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
//n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
//a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
//따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
//1 ≤ s의 길이 ≤ 10,000
//s은 영어 소문자로만 이루어져 있습니다.
public class P142086 {
    public static void main(String[] args) {

        String s = "foobar";
        System.out.println(Arrays.toString(solution(s)));

    }
   public static int[] solution(String s) {
       //초기 세팅
       int sLength = s.length();
       int index = 1;
       int[] answer = new int[sLength];

       Arrays.fill(answer, -1);


       while(true) {
           if(index == sLength) break;

           int result = -1;
           for(int i = index-1; i>=0; i--) {
               if(s.charAt(index) == s.charAt(i)) {
                   answer[index] = index-i;
                   break;
               }
           }

           index++;
       }
       return answer;
   }

}
