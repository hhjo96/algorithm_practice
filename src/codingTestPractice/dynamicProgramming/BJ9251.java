package codingTestPractice.dynamicProgramming;

import java.util.Scanner;

public class BJ9251 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int[][] answer = new int[arrA.length+1][arrB.length+1];// A의 i번째 길이까지, B의 j번째 길이까지 고려했을 때 LCS 길이

        //루프 돌면서 계산
        for(int i = 1; i <= arrA.length; i++) {
            for(int j = 1; j <= arrB.length; j++) {
                if(arrA[i-1] == arrB[j-1]) { // 같으면
                    answer[i][j] = answer[i-1][j-1] + 1;
                } else { // 다르면
                    answer[i][j] = Math.max(answer[i-1][j], answer[i][j-1]);
                }
            }
        }

        System.out.println(answer[arrA.length][arrB.length]);
    }
}
