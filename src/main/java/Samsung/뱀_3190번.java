package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀_3190번 {
    static int answer = 0;
    static int n,m;
    static int[][] map;
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1},};// 상,우,하,좌
    static int[][] check;
    static LinkedList<SnakeInfo> snakeList;

    static Map<Integer, Character> timeTable;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new int[n][n];
        timeTable = new HashMap<>();
        snakeList = new LinkedList<>();
        StringTokenizer st;
        // 사과 위치
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = 1;
        }
        int k = Integer.parseInt(br.readLine());
        // 타임별 뱀의 방향
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            timeTable.put(time, direction);
        }

        // bfs(0,0)
        bfs(0,0);
        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        // 뱀 현재 위치 갱신
        Queue<Snake> q = new LinkedList<>();
        // 현재 뱀의 위치, 시간, 진행중인 방향 오른쪽 'R'
        q.add(new Snake(x,y,x,y,1, 'R'));
        // 1: 뱀이 현재 위치한 곳, 0: 뱀이 현재 위치하지 않은 곳
        check[x][y] = 1;
        snakeList.addLast(new SnakeInfo(x,y));
        while(!q.isEmpty()){
            // 뱀의 현재 위치
            Snake snake = q.poll();
            int dHeadX = snake.headX;
            int dHeadY = snake.headY;
            int dTailX = snake.tailX;
            int dTailY = snake.tailY;
            int dTime = snake.time;
            char dCurrDir = snake.currDir;

            // 현재 위치한 방향에 맞게 뱀의 방향 진행
            int mHeadX = 0;
            int mHeadY = 0;
            int dirCurrIdx = -1;

            if(dCurrDir == 'U') dirCurrIdx = 0;
            else if(dCurrDir == 'R') dirCurrIdx = 1;
            else if(dCurrDir == 'D') dirCurrIdx = 2;
            else if(dCurrDir == 'L') dirCurrIdx = 3;


            mHeadX = dHeadX + dir[dirCurrIdx][0];
            mHeadY = dHeadY + dir[dirCurrIdx][1];

            // 뱀이 범위에 속해있는 경우 진행
            if(mHeadX >= 0 && mHeadX < n && mHeadY >= 0 && mHeadY < n){
                // 뱀 몸에 걸린경우
                if(check[mHeadX][mHeadY] == 1 && map[mHeadX][mHeadY] == 0){
                    answer = dTime;
                    break;
                }
                if(map[mHeadX][mHeadY] == 1){
                    // 사과가 없어진다.
                    map[mHeadX][mHeadY] = 0;
                    snakeList.addLast(new SnakeInfo(x,y));
                    check[dTailX][dTailY] = 1;
                    check[mHeadX][mHeadY] = 1;
                }
                else if(map[mHeadX][mHeadY] == 0){
                    // 몸의 길이를 줄여 꼬리가 위치한 칸을 비워준다
                    snakeList.removeFirst();
                    snakeList.addLast(new SnakeInfo(mHeadX, mHeadY));
                    check[dTailX][dTailY] = 0;
                    check[mHeadX][mHeadY] = 1;
//                    // 꼬리 위치 갱신
//                    for(int i=0; i<4; i++){
//                        int tailX = dTailX+dir[i][0];
//                        int tailY = dTailY+dir[i][1];
//                        if(tailX >= 0 && tailX < n && tailY >= 0 && tailY < n) {
//                            if (check[dTailX + dir[i][0]][dTailY + dir[i][1]] == 1) {
//                                dTailX = dTailX + dir[i][0];
//                                dTailY = dTailY + dir[i][1];
//                            }
//                        }
//                    }

                }
                if(timeTable.containsKey(dTime)) {
                    char timeDir = timeTable.get(dTime);
                    // 'L' 왼쪽 회전, 'D' 오른쪽 회전
                    if (timeDir == 'D') {
                        dirCurrIdx = dirCurrIdx % 3 == 0 ? 0 : dirCurrIdx + 1;
                    } else if (timeDir == 'L') {
                        dirCurrIdx = dirCurrIdx == 0 ? 3 : dirCurrIdx - 1;
                    }
                    if (dirCurrIdx == 0) dCurrDir = 'U';
                    else if (dirCurrIdx == 1) dCurrDir = 'R';
                    else if (dirCurrIdx == 2) dCurrDir = 'D';
                    else if (dirCurrIdx == 3) dCurrDir = 'L';
                }

                q.add(new Snake(snakeList.getFirst().x, snakeList.getFirst().y, snakeList.getLast().x, snakeList.getLast().y, dTime + 1, dCurrDir));
//                q.add(new Snake(mHeadX, mHeadY, dTailX, dTailY, dTime + 1, dCurrDir));


            }
            // 뱀이 범위에 속해있지 않고 벽에 부딪힌 경우
            else {
                answer = dTime;
                break;
            }
        }
    }

    // 뱀의 머리를 나타내는 클래스
    static class Snake{
        int headX;                  // 헤더 X
        int headY;                  // 헤더 Y
        int tailX;                  // 꼬리 X
        int tailY;                  // 꼬리 Y
        int time;                   // 현재까지 진행된 시간
        char currDir;               // 현재 진행중인 방향

        public Snake(int headX, int headY, int tailX, int tailY, int time, char currDir) {
            this.headX = headX;
            this.headY = headY;
            this.tailX = tailX;
            this.tailY = tailY;
            this.time = time;
            this.currDir = currDir;
        }
    }

    private static class SnakeInfo {
        int x;
        int y;

        public SnakeInfo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
