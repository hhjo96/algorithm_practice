package codingTestPractice.ETC.lv3;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42862
//점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
// 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
// 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
// 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
//
//전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열
// reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
public class P42862 {
    public static void main(String[] args) {
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println("solution(5, lost, reserve) = " + solution(5, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int[] students = new int[n+1];
        int answer = 0;

        //각 학생들이 가지고 있는 체육복의 수를 students 배열에 넣음
        for(int i = 1; i< students.length; i++) {
            students[i] = 1;
        }

        for(int i = 0; i<lost.length; i++) {
            students[lost[i]]--;
        }

        for(int i = 0; i<reserve.length; i++) {
            students[reserve[i]]++;
        }

        // 절댓값이 1인 경우에만 빌려줄 수 있다. 절댓값이 0인 경우  자기가 쓰고 안빌려준다
        for(int i = 1; i<= n; i++) {
            if(students[i] == 0) {
                // 체육복이 없는 사람의 왼쪽 사람과 오른쪽 사람을 비교
                if(i > 1 && students[i-1] == 2) {
                    students[i]++;
                    students[i-1]--;
                } else if( i< n && students[i+1] == 2) {
                    students[i]++;
                    students[i+1]--;
                }
            }
        }

        //1인 개수 세기
        for(int i = 0; i<=n; i++) {
            if(students[i] >= 1) {
                answer++;
            }
        }
        return answer;
    }
}
