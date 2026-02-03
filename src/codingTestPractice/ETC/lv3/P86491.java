package codingTestPractice.ETC.lv3;

import java.util.Random;

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
