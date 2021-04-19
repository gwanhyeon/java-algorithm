package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀_3190번_linkedlist {
    static int answer = 0;
    static int n,m;
    static int[][] map;
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1},};// 상,우,하,좌
    static LinkedList<Snake> snakeList;
    static Map<Integer, Character> timeTable;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n][n];
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
        bfs(0,0);

    }

    static void bfs(int x, int y) {
        // 뱀 현재 위치 갱신
        Deque<Snake> q = new LinkedList<>();
        // 현재 뱀의 위치, 시간, 진행중인 방향 오른쪽 'R'
        q.addFirst(new Snake(x,y,0, 'R'));
        q.addFirst(new Snake(x,y,0, 'R'));
        // 1: 뱀이 현재 위치한 곳, 0: 뱀이 현재 위치하지 않은 곳
        while(!q.isEmpty()){
            // 뱀의 현재 위치
            Snake snake = q.peekFirst();
            int dx = snake.x;
            int dy = snake.y;
            int dTime = snake.time;
            char dCurrDir = snake.currDir;

            // 현재 위치한 방향에 맞게 뱀의 방향 진행
            int mx = 0;
            int my = 0;
            int dirCurrIdx = -1;
            if(dCurrDir == 'U') dirCurrIdx = 0;
            else if(dCurrDir == 'R') dirCurrIdx = 1;
            else if(dCurrDir == 'D') dirCurrIdx = 2;
            else if(dCurrDir == 'L') dirCurrIdx = 3;

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


            mx = dx + dir[dirCurrIdx][0];
            my = dy + dir[dirCurrIdx][1];

            // 뱀이 범위에 속해있는 경우 진행
            if(mx >= 0 && mx < n && my >= 0 && my < n){
                // 몸에 걸린경우
                boolean isCheck = false;
                for (Snake snake1 : q) {
                    if(mx == snake1.x && my == snake1.y){
                        isCheck = true;
                        break;
                    }
                }
                if(isCheck){
                    answer = dTime+1;
                    break;
                }
                // 사과가 없어진다.
                if(map[mx][my] == 1){
                    map[mx][my] = 0;
                }
                else if(map[mx][my] == 0){
                    // 몸의 길이를 줄여 꼬리가 위치한 칸을 비워준다
                    q.pollLast();
                }
                q.addFirst(new Snake(mx,my, dTime+1, dCurrDir));
            }
            // 뱀이 범위에 속해있지 않고 벽에 부딪힌 경우
            else {
                answer = dTime+1;
                break;
            }
        }
        System.out.println(answer);
    }

    // 뱀의 머리를 나타내는 클래스
    static class Snake{
        int x;
        int y;
        int time;                   // 현재까지 진행된 시간
        char currDir;               // 현재 진행중인 방향
        public Snake(int x, int y, int time, char currDir) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.currDir = currDir;
        }
    }
}

/*
5
0
5
4 D
8 D
12 D
15 D
20 L
 */