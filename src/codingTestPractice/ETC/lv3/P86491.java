package codingTestPractice.ETC.lv3;

import java.util.Random;

//모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
// 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
//sizes의 길이는 1 이상 10,000 이하입니다.
//sizes의 원소는 [w, h] 형식입니다.
//w는 명함의 가로 길이를 나타냅니다.
//h는 명함의 세로 길이를 나타냅니다.
//w와 h는 1 이상 1,000 이하인 자연수입니다.

public class P86491 {
    public static void main(String[] args) {

        Random random = new Random();
        int length = random.nextInt(10000)+1;
        int[][] sizes = new int[length][2];

        for(int i = 0; i<length; i++) {
            sizes[i][0] = random.nextInt(1000)+1;
            sizes[i][1] = random.nextInt(1000)+1;
        }
        System.out.println("solution(sizes) = " + solution1(sizes));
        System.out.println("solution(sizes) = " + solution2(sizes));

    }

    public static int solution1(int[][] sizes) {

        //더 큰 수를 앞에 두기
        int[][] sizesInOrder = new int[sizes.length][sizes[0].length];
        for(int i = 0; i<sizes.length; i++) {
            if(sizes[i][0] <sizes[i][1]) {
                sizesInOrder[i][0] = sizes[i][1];
                sizesInOrder[i][1] = sizes[i][0];
            } else {
                sizesInOrder[i][0] = sizes[i][0];
                sizesInOrder[i][1] = sizes[i][1];
            }
        }

        int gMax = sizesInOrder[0][0];
        int sMax = sizesInOrder[0][1];

        for(int i = 1; i<sizes.length; i++) {
            if(sizesInOrder[i][0] > gMax) {
                gMax = sizesInOrder[i][0];
            }
            if(sizesInOrder[i][1] > sMax) {
                sMax = sizesInOrder[i][1];
            }

            //System.out.println(gMax+" "+sMax);
        }

        return gMax * sMax;

    }

    public static int solution2(int[][] sizes) {
        int gMax = 0;
        int sMax = 0;

        for (int[] size : sizes) {
            int big = Math.max(size[0], size[1]);
            int small = Math.min(size[0], size[1]);

            gMax = Math.max(gMax, big);
            sMax = Math.max(sMax, small);
        }
        return gMax * sMax;
    }
}
