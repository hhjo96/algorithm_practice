package codingTestPractice.ETC.lv4;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/172928
// 공원을 나타내는 문자열 배열 park, 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때,
// 로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

public class P172928 {
    public static void main(String[] args) {

        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        System.out.println(Arrays.toString(solution1(park, routes)));
        System.out.println(Arrays.toString(solution2(park, routes)));

    }

    public static int[] solution1(String[] park, String[] routes) {
        int[] answer = {0, 0};

        //시작지점을 찾기
        for(int i = 0; i< park.length; i++) {
            for(int j = 0; j<park[0].length(); j++) {
                if(park[i].charAt(j) == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        //이동하기
        int tempI = answer[0];
        int tempJ = answer[1];
        for(int i = 0; i<routes.length; i++) {
            // 이동이 가능한지
            boolean able = true;
            // 이동 길이
            // 문자로 된 숫자를 가져오므로 실제 숫자로 변환 필요
            String[] lengths = routes[i].split(" ");
            char dir = lengths[0].charAt(0);
            int length = Integer.parseInt(lengths[1]);

            switch(dir) {
                case 'E':
                    for(int j = 1; j <= length; j++) {
                        // 공원의 길이보다 크거나 장애물인경우
                        if(tempJ+j >= park[tempI].length() || park[tempI].charAt(tempJ+j) == 'X') {
                            able = false;
                            break;
                        }
                    }
                    if(able) {
                        tempJ+=length;
                    }
                    break;
                case 'W':
                    for(int j = 1; j <= length; j++) {
                        // 공원의 길이보다 작거나 장애물인경우
                        if(tempJ-j < 0 || park[tempI].charAt(tempJ-j) == 'X') {
                            able = false;
                            break;
                        }
                    }
                    if(able) {
                        tempJ-=length;
                    }
                    break;
                case 'S':
                    for(int j = 1; j <= length; j++) {
                        // 공원의 길이보다 크거나 장애물인경우
                        if(tempI+j >= park.length || park[tempI+j].charAt(tempJ) == 'X') {
                            able = false;
                            break;
                        }
                    }
                    if(able) {
                        tempI+=length;
                    }

                    break;
                case 'N':
                    for(int j = 1; j <= length; j++) {
                        // 공원의 길이보다 크거나 장애물인경우
                        if(tempI-j < 0 || park[tempI-j].charAt(tempJ) == 'X') {
                            able = false;
                            break;
                        }
                    }
                    if(able) {
                        tempI-=length;
                    }
                    break;
            }
        }

        answer[0] = tempI;
        answer[1] = tempJ;
        return answer;
    }

    public static int[] solution2(String[] park, String[] routes) {
        int x = 0;
        int y = 0;

        // 시작 위치 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }

        // 이동 처리
        for (String route : routes) {
            String[] parts = route.split(" ");
            char dir = parts[0].charAt(0);
            int len = Integer.parseInt(parts[1]);

            int nx = x;
            int ny = y;
            boolean able = true;

            for (int i = 0; i < len; i++) {

                if (dir == 'E') ny++;
                if (dir == 'W') ny--;
                if (dir == 'S') nx++;
                if (dir == 'N') nx--;

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= park.length || ny >= park[0].length()) {
                    able = false;
                    break;
                }

                // 장애물 체크
                if (park[nx].charAt(ny) == 'X') {
                    able = false;
                    break;
                }
            }

            if (able) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y};
    }
}
