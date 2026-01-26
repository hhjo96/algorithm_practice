package codingTestPractice.ETC;

import java.util.Arrays;
import java.util.Random;

//https://school.programmers.co.kr/learn/courses/30/lessons/12935
//정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
// 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
// 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
// arr은 길이 1 이상인 배열입니다.
// 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
public class P12935 {
    public static void main(String[] args) {

        //int[] arr = randomIntArr();
        int[] arr = {4, 3, 2, 1};
        System.out.println(Arrays.toString(solution(arr)));
    }
    public static int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1}; // 값이 한개만 있으면 -1 한개만 가진 배열 리턴
        Arrays.sort(arr);
        //arr: 1 2 3 4
        //뒤집기
        //제일 작은수를 제외해야 하는데 arr 배열에서 현재
        //제일 작은수가 제일 앞에 있으므로
        int j = 0;
        int[] newArr = new int[arr.length-1];
        for (int i = arr.length - 1; i >= 1; i--) {
            newArr[j++] = arr[i];
        }
        return newArr;

    }

    public static int[] randomIntArr() {
        Random random = new Random();
        int[] arr = new int[random.nextInt(100)+1]; // 1부터 100개
        for(int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
