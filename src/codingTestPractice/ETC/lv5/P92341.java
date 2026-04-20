package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/92341
// 주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가
// 매개변수로 주어집니다. 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로
// 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P92341 {
    public static void main(String[] args) {

    int[] fees = {180, 5000, 10, 600};
    String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
    System.out.println(Arrays.toString(solution(fees, records)));

    }
    public static int[] solution(int[] fees, String[] records) {

        // 시간을 분으로 바꿔서 차량번호/입차시각, 차량번호/누적주차시간 으로 맵 두개 세팅
        // 다 본 후 누적주차시간이 없으면 2359에 나간것 처리

        Map<String, Integer> ins = new HashMap<>();
        Map<String, Integer> cul = new HashMap<>();

        for(int i = 0; i< records.length; i++) {
            String[] temp = records[i].split(" ");
            // in일때 처리
            if(temp[2].equals("IN")) {
                int time = Integer.parseInt(temp[0].substring(0, 2)) * 60 +
                        Integer.parseInt(temp[0].substring(3, 5));
                ins.put(temp[1], time);

            } else { // out일 때 처리
                int time = Integer.parseInt(temp[0].substring(0, 2)) * 60 +
                        Integer.parseInt(temp[0].substring(3, 5));
                int inTime = ins.get(temp[1]);
                cul.put(temp[1], cul.getOrDefault(temp[1], 0) + time - inTime);
                ins.remove(temp[1]);
            }
        }

        // 나간 시간이 없을 경우 처리
        for(String car: ins.keySet()) {
            int inTime = ins.get(car);
            int outTime = 23 * 60 + 59;
            cul.put(car, cul.getOrDefault(car, 0) + (outTime - inTime));
        }

        // 요금 계산
        // fees: 기본시간 기본요금 단위시간 단위요금 순서
        // 기본요금 + ceil((누적시간 - 기본시간) / 단위시간) * 단위요금
        Map<String, Integer> totalMap = new TreeMap<>();
        for(String car: cul.keySet()) {
            int time = cul.get(car);
            int price;
            if(time > fees[0]) {
                price = fees[1] +(int) Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3];
            } else {
                price = fees[1];
            }
            totalMap.put(car, price);
        }
        int[] answer = new int[totalMap.size()];
        int idx = 0;

        for (int fee : totalMap.values()) {
            answer[idx++] = fee;
        }

        return answer;
    }
}
