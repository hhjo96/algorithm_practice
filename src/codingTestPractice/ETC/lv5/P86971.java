package codingTestPractice.ETC.lv5;

// https://school.programmers.co.kr/learn/courses/30/lessons/86971

// n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다. 당신은 이 전선들 중
// 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다. 이때, 두 전력망이 갖게 되는
// 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
//송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다. 전선들 중 하나를 끊어서
// 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때, 두 전력망이 가지고 있는
// 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.
public class P86971 {
    public static void main(String[] args) {

        int[][] wires = {{1,3},{2,3},{3,4}, {4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(9, wires));
    }

    public static int solution(int n, int[][] wires) {

        // answer: 두 전력망의 송전탑 개수 차이의 최솟값
        // 차이는 최대 n까지 날 수 있음
        int answer = n;

        // 전선을 하나씩 끊어보면서 가장 차이가 적은 경우 찾기
        for (int i = 0; i < wires.length; i++) {

            // 송전탑 번호가 1번부터 n번까지라서 크기 n + 1
            // graph[a][b] == true 이면 a번 송전탑과 b번 송전탑이 연결되어 있다는 뜻
            boolean[][] graph = new boolean[n + 1][n + 1];

            // 이번에 끊어볼 전선 i를 제외하고 그래프를 다시 만들기
            for (int j = 0; j < wires.length; j++) {

                if (i == j) continue;

                int a = wires[j][0];
                int b = wires[j][1];

                // 전선은 양방향 연결이므로 양쪽 모두 true 처리
                graph[a][b] = true;
                graph[b][a] = true;
            }

            // 이미 방문했는지 확인용
            boolean[] visited = new boolean[n + 1];

            // 1번 송전탑에서 시작해서 연결된 송전탑 개수를 세기
            // 전선을 하나 끊으면 전력망이 두 덩어리로 나뉘는데,
            // count는 그중 1번 송전탑이 속한 덩어리의 송전탑 개수
            int count = dfs(1, graph, visited, n);

            // 다른 쪽 전력망의 송전탑 개수는 n - count
            int other = n - count;

            // 두 전력망의 송전탑 개수 차이
            int diff = Math.abs(count - other);

            // 지금까지 구한 차이 중 가장 작은 값을 answer에 저장
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    public static int dfs(int current, boolean[][] graph, boolean[] visited, int n) {

        // 현재 송전탑을 방문 처리
        visited[current] = true;

        // 현재 송전탑 하나를 세고 시작
        int count = 1;

        // current와 연결된 다른 송전탑이 있는지 1번부터 n번까지 확인
        for (int i = 1; i <= n; i++) {

            // current와 i가 연결되어 있고,
            // i번 송전탑을 아직 방문하지 않았다면 이동
            if (graph[current][i] && !visited[i]) {

                // i번 송전탑에서 이어진 송전탑 개수를 추가로 센다
                count += dfs(i, graph, visited, n);
            }
        }

        // current에서 출발해서 갈 수 있는 송전탑 개수 반환
        return count;
    }
}
