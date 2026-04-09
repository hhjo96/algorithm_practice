package codingTestPractice.ETC.lv4;


import java.util.*;

public class P42586 {
    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println("solution1(progresses, speeds) = " + Arrays.toString(solution1(progresses, speeds)));
        System.out.println("solution2(progresses, speeds) = " + Arrays.toString(solution2(progresses, speeds)));

    }
    public static int[] solution1(int[] progresses, int[] speeds) {

        // 완료일 계산
        int[] deploy = new int[speeds.length];
        for(int i = 0; i< deploy.length; i++) {
            deploy[i] = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
        }

        // 작업이 한개인 경우 미리 리턴
        if(speeds.length == 1) {
            return new int[]{1};
        }

        //배포 가능일 계산
        for(int i = 1; i< deploy.length; i++) {
            if(deploy[i-1] > deploy[i]) {
                deploy[i] = deploy[i-1];
            }
        }

        // 정답 계산(한번에 몇개 기능 배포하는지)

        int count = 1;
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i< deploy.length; i++) {
            if(deploy[i] == deploy[i-1]) {
                count++;
            } else {
                answer.add(count);
                count = 1;
            }
        }
        // 마지막 그룹이 안들어가므로
        answer.add(count);

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution2(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();

        // 1. 완료일까지 계산해서 큐에 넣기
        for(int i = 0; i < progresses.length; i++) {
            int day = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            q.offer(day);
        }

        List<Integer> answer = new ArrayList<>();

        // 2. 배포 묶기
        while(!q.isEmpty()) {
            int current = q.poll(); // 기준 꺼내면서 삭제
            int count = 1;

            // 뒤에 것들 확인 peek: 보기만
            while(!q.isEmpty() && q.peek() <= current) {
                q.poll();
                count++;
            }

            answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
