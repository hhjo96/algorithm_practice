package codingTestPractice.ETC.lv5;

import java.util.ArrayList;
import java.util.List;

public class P172927 {
    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println("solution(picks, minerals) = " + solution(picks, minerals));
    }
    public static int solution(int[] picks, String[] minerals) {
        // 곡괭이로 캘 수 있는 최대 광물 개수
        int totalPicks = (picks[0] + picks[1] + picks[2]) * 5;
        int len = Math.min(minerals.length, totalPicks);

        // 5개씩 그룹핑해서 [dia개수, iron개수, stone개수] 저장
        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < len; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < Math.min(i + 5, len); j++) {
                switch (minerals[j]) {
                    case "diamond": dia++; break;
                    case "iron": iron++; break;
                    case "stone": stone++; break;
                }
            }
            groups.add(new int[]{dia, iron, stone});
        }

        // 다이아 많은 순 -> 철 많은 순으로 내림차순 정렬 (피로도 센 그룹이 앞으로)
        groups.sort((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });

        // 곡괭이
        int[] pickCount = picks.clone(); // [dia, iron, stone]
        int answer = 0;

        for (int[] g : groups) {
            int dia = g[0], iron = g[1], stone = g[2];
            if (pickCount[0] > 0) {          // 다이아 곡괭이
                answer += dia * 1 + iron * 1 + stone * 1;
                pickCount[0]--;
            } else if (pickCount[1] > 0) {   // 철 곡괭이
                answer += dia * 5 + iron * 1 + stone * 1;
                pickCount[1]--;
            } else {                          // 돌 곡괭이
                answer += dia * 25 + iron * 5 + stone * 1;
                pickCount[2]--;
            }
        }

        return answer;
    }

}
