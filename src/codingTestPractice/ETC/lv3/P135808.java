package codingTestPractice.ETC.lv3;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/135808
// 과일 장수가 사과 상자를 포장하고 있습니다. 사과는 상태에 따라 1점부터 k점까지의 점수로 분류하며,
// k점이 최상품의 사과이고 1점이 최하품의 사과입니다. 사과 한 상자의 가격은 다음과 같이 결정됩니다.
//
//한 상자에 사과를 m개씩 담아 포장합니다.
//상자에 담긴 사과 중 가장 낮은 점수가 p (1 ≤ p ≤ k)점인 경우, 사과 한 상자의 가격은 p * m 입니다.
//과일 장수가 가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익을 계산하고자 합니다.
// (사과는 상자 단위로만 판매하며, 남는 사과는 버립니다)
//
//예를 들어, k = 3, m = 4, 사과 7개의 점수가 [1, 2, 3, 1, 2, 3, 1]이라면,
// 다음과 같이 [2, 3, 2, 3]으로 구성된 사과 상자 1개를 만들어 판매하여 최대 이익을 얻을 수 있습니다.
//
//(최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수) = 2 x 4 x 1 = 8
//사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score가 주어졌을 때,
// 과일 장수가 얻을 수 있는 최대 이익을 return하는 solution 함수를 완성해주세요.
//3 ≤ k ≤ 9
//3 ≤ m ≤ 10
//7 ≤ score의 길이 ≤ 1,000,000
//1 ≤ score[i] ≤ k
//이익이 발생하지 않는 경우에는 0을 return 해주세요.

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
