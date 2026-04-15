package codingTestPractice.ETC.lv5;
// 이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데,
// 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다.
// 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열
// dungeons 가 매개변수로 주어질 때,
// 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.

//https://school.programmers.co.kr/learn/courses/30/lessons/87946

public class P87946 {
    static int maxCount = 0;

    public static void main(String[] args) {

        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println("solution(k, dungeons) = " + solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        // 현재 피로도 k, 던전별 최소필요도와 소모필요도 deugeons
        // 던전의 개수가 1~8이므로 완전탐색
        // 피로도를 최소로 남기는 문제가 아니므로 그리디 X

        int currentCount = 0;
        boolean[] visited = new boolean[dungeons.length];

        dfs(k, dungeons, visited, currentCount);
        return maxCount;
    }
    public static void dfs(int k, int[][] dungeons, boolean[] visited, int current) {
        maxCount = Math.max(maxCount, current);

        for(int i = 0; i< dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, visited, current+1);
                visited[i] = false;
            }
        }
    }
}
