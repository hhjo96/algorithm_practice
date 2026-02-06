package codingTestPractice.ETC.lv3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서
// 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
// numbers의 길이는 2 이상 100 이하입니다.
// numbers의 모든 수는 0 이상 100 이하입니다.
public class P68644 {
    public static void main(String[] args) {

        Random random = new Random();
        
        int length = random.nextInt(98)+2; //2~100
        int[] arr = new int[length];
        for(int i = 0; i< length; i++) {
            arr[i] = random.nextInt(101); // 0~100
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int num = numbers[i] + numbers[j];
                set.add(num);
                //System.out.println("num = " + num);
            }
        }

        return set.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }


}
