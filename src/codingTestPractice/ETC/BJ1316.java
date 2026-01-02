package codingTestPractice.ETC;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1316
public class BJ1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();          // 입력될 단어의 개수
        sc.nextLine();                // nextInt 뒤에 남은 엔터 제거

        String[] word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = sc.nextLine();  // 단어 입력
        }

        int count = 0;                // 그룹 단어 개수

        // 각 단어마다 그룹 단어인지 검사
        for (int i = 0; i < n; i++) {

            boolean[] visited = new boolean[26]; // 이미 등장했는지 여부
            String prev = word[i].substring(0, 1); // 이전 문자 (문자열 그대로 유지)
            visited[prev.charAt(0) - 'a'] = true;

            boolean isGroup = true;

            for (int j = 1; j < word[i].length(); j++) {
                String cur = word[i].substring(j, j + 1);

                // 이전 문자와 다를 때만 검사
                if (!prev.equals(cur)) {
                    // 이미 등장한 문자라면 그룹 단어 아님
                    if (visited[cur.charAt(0) - 'a']) {
                        isGroup = false;
                        break;
                    }
                    visited[cur.charAt(0) - 'a'] = true;
                }

                // 이전 문자 갱신
                prev = cur;
            }

            if (isGroup) {
                count++;
            }
        }

        System.out.println(count);
    }
}
