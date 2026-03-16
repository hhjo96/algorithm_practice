package codingTestPractice.ETC.lv4;

//https://school.programmers.co.kr/learn/courses/30/lessons/92334
// 이용자의 ID가 담긴 문자열 배열 id_list, 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report,
// 정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때,
// 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.

import java.util.*;

public class P92334 {
    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution1(id_list, report, k)));
        System.out.println(Arrays.toString(solution2(id_list, report, k)));

    }

    public static int[] solution1(String[] id_list, String[] report, int k) {

        // 신고 횟수 저장
        Map<String, Integer> reportCount = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            reportCount.put(id_list[i], 0);
        }

        // 누가 누구를 신고했는지 저장 (중복 제거)
        Map<String, Set<String>> reportWho = new HashMap<>();
        for (String id : id_list) {
            reportWho.put(id, new HashSet<>());
        }

        // 신고 처리
        for (int i = 0; i < report.length; i++) {
            String[] reports = report[i].split(" ");
            String reporter = reports[0];
            String reported = reports[1];

            // 이미 신고했으면 무시
            if (!reportWho.get(reporter).contains(reported)) {
                reportWho.get(reporter).add(reported);
                reportCount.put(reported, reportCount.get(reported) + 1);
            }
        }

        // 결과 저장
        Map<String, Integer> tempAnswer = new HashMap<>();

        for (Map.Entry<String, Set<String>> entry : reportWho.entrySet()) {
            String reporter = entry.getKey();

            for (String reported : entry.getValue()) {
                if (reportCount.get(reported) >= k) {
                    tempAnswer.put(
                            reporter,
                            tempAnswer.getOrDefault(reporter, 0) + 1
                    );
                }
            }
        }

        int[] answer = new int[id_list.length];
        int i = 0;
        for (String name : id_list) {
            answer[i] = tempAnswer.getOrDefault(name, 0);
            i++;
        }

        return answer;
    }

    public static int[] solution2(String[] id_list, String[] report, int k) {

        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();

        for (String id : id_list) {
            reportCount.put(id, 0);
            reportMap.put(id, new HashSet<>());
        }

        // 중복 제거
        for (String r : report) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            if (reportMap.get(reporter).add(reported)) {
                reportCount.put(reported, reportCount.get(reported) + 1);
            }
        }

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];

            for (String reported : reportMap.get(user)) {
                if (reportCount.get(reported) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}
