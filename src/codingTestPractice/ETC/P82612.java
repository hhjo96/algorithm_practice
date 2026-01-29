package codingTestPractice.ETC;

import java.util.Random;

//https://school.programmers.co.kr/learn/courses/30/lessons/82612
//새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다.
// 이 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다.
// 즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
//놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
//단, 금액이 부족하지 않으면 0을 return 하세요.
public class P82612 {
    public static void main(String[] args) {

        Random random = new Random();
        int price = random.nextInt(2500)+1;
        int money = random.nextInt( 1000000000)+1;
        int count = random.nextInt(2500)+1;
        System.out.println("price = " + price);
        System.out.println("money = " + money);
        System.out.println("count = " + count);
        System.out.println(solution1(price, money, count));
        System.out.println(solution2(price, money, count));
    }
    public static long solution1(int price, int money, int count) {
        long total = 0;

        for (int i = 1; i <= count; i++) {
            total += (long) i * price;
        }

        return total > money ? total - money : 0;
    }

    public static long solution2(int price, int money, int count) {
        //놀이기구를 탈 때 낼 금액은 price * 1, price * 2, price * 3, ... price * count 이런식으로 증가함.
        //따라서 price * (1+2+....+count) 할 수 있음.
        long total = (long) price * count * (count + 1) / 2;
        return total > money ? total - money : 0;
    }
}
