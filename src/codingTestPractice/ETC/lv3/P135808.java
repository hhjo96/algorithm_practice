package codingTestPractice.ETC.lv3;

import java.util.Arrays;

public class P135808 {
    public static void main(String[] args) {
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println("solution1= " + solution1(4, 3, score));
        System.out.println("solution2 = " + solution2(4, 3, score));
    }
    public static int solution1(int k, int m, int[] score) {
        int profit = 0;

        //점수의 종류에 따라 몇 개인지 세기
        int[] count = new int[k+1];

        for(int i = 0; i< score.length; i++) {
            switch(score[i]) {
                case 1: count[1]++; break;
                case 2: count[2]++; break;
                case 3: count[3]++; break;
                case 4: count[4]++; break;
                case 5: count[5]++; break;
                case 6: count[6]++; break;
                case 7: count[7]++; break;
                case 8: count[8]++; break;
                case 9: count[9]++; break;
            }
        }

        //카운트한 수를 m개씩 자르기
        int boxCount = 0;
        for(int i = k; i>0; i--) {
            while(count[i] > 0) {
                boxCount++;
                count[i]--;
                if(boxCount == m) {
                    boxCount = 0;
                    profit += i * m;

                }
            }
        }
        return profit;
    }

    public static int solution2(int k, int m, int[] score) {
        int profit = 0;
        Arrays.sort(score);
        int boxCount = 0;

        for(int i = score.length-1; i>=0; i--) {
            boxCount++;

            if(boxCount == m) {
                profit += score[i] * m;
                boxCount = 0;
            }
        }
        return profit;
    }
}
