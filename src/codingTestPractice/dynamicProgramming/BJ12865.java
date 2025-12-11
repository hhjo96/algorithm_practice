package codingTestPractice.dynamicProgramming;

import java.util.Scanner;

//https://www.acmicpc.net/problem/12865
public class BJ12865 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int maxWeight = scanner.nextInt();
        int [][]input = new int[count+1][2]; // [0]: w, [1]: v

        for(int i = 1; i < count + 1; i++) {
            for (int j = 0; j < 2; j++) {
                input[i][j] = scanner.nextInt();
            }
        }

        //wv[i][j] = i번째 물건까지 고려했고,
        //배낭 용량이 j일 때
        //가장 큰 가치
        int [][]wv = new int[count+1][maxWeight+1];

        if(count == 1) {
            if(input[1][0] <= maxWeight) {
                System.out.println(input[1][1]);
            } else {
                System.out.println(0);
            }

        } else {
            for(int i = 1; i <= count; i++) {
                for(int j = 0; j <= maxWeight; j++) {
                    if(input[i][0] > j) {
                        wv[i][j] = wv[i-1][j];
                    } else {
                        wv[i][j] = Math.max(wv[i-1][j], wv[i-1][j-input[i][0]] + input[i][1]);
                    }
                }
            }
            System.out.println(wv[count][maxWeight]);
        }









    }
}
