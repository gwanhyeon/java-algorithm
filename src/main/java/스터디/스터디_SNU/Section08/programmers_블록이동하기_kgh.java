package 스터디.스터디_SNU.Section08;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_블록이동하기_kgh {
    static boolean[][][] isCheck;
    static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static int[][] rotateDir = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
    public static void main(String[] args) {
        solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}});
    }
    static int solution(int[][] board) {
        int answer = 0;
        int len = board.length - 1;
        isCheck = new boolean[len][len][4];            // 한칸더 차지하고 있는 칸을 체크해주기 위해서 3차원배열 선언
        bfs(board, 0, 0, len);
        return answer;
    }

    /**
     * @param board 맵
     * @param x     x좌표
     * @param y
     * @param len
     */
    private static int bfs(int[][] board, int x, int y, int len) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y, 0, 0));
        isCheck[0][0][0] = true; // x -> 1,2,3,4

        // 도착지 endX,endY
        int endX = len - 1;
        int endY = len - 1;


        while (!q.isEmpty()) {
            Pair pair = q.remove();
            int mx = pair.x;
            int my = pair.y;
            int mdir = pair.dir;
            int time = pair.time;

            // 다른 로봇의 지점
            int nextX = x + dir[mdir][0];
            int nextY = y + dir[mdir][1];

            // 종료지점에 도착하였을 경우
            if ((mx == endX && my == endY) || (nextX == endX && nextY == endY)) {
                return time;
            }

            // 우하좌상
            for (int i = 0; i < 4; i++) {
                int dx = mx + dir[i][0];
                int dy = my + dir[i][1];
                int dxNext = mx + dir[i][0];
                int dyNext = my + dir[i][1];

                // 범위에 만족하는 경우
                if ((dx >= 0 && dx < len && dy >= 0 && dy < len) && (dxNext >= 0 && dxNext < len && dyNext >= 0 && dyNext < len)) {
                    // 방문하지 않은 경우
                    if (!isCheck[dx][dy][mdir] && board[dx][dy] == 0 && board[dxNext][dyNext] == 0) {
                        isCheck[mx][my][mdir] = true;
                        q.offer(new Pair(mx, my, mdir, time + 1));
                    }
                }
            }
            //x,y 를 축으로 90도 회전
            for (int i = 1; i < 4; i += 2) {
                int ndir = (mdir + i) % 4;
                nextX = x + dir[ndir][0];
                nextY = y + dir[ndir][1];
                int rx, ry; //회전하면서 지나갈 곳의 좌표
                if (i == 1) {
                    //시계방향 회전인 경우
                    rx = x + rotateDir[ndir][0];
                    ry = y + rotateDir[ndir][1];
                }
                else {
                    //반시계방향 회전인 경우
                    rx = x + rotateDir[ndir][0];
                    ry = y + rotateDir[ndir][0];
                }
                // 범위에 만족하는 경우
                if ((nextX >= 0 && nextX < len && nextY >= 0 && nextY < len) && (rx >= 0 && rx < len && ry >= 0 && ry < len)) {
                    // 방문하지 않은 경우
                    if (!isCheck[mx][my][mdir] && board[nextX][nextY] == 0 && board[rx][ry] == 0) {
                        isCheck[mx][my][mdir] = true;
                        q.offer(new Pair(mx, my, mdir, time + 1));
                    }
                }
            }
            //xx, yy 를 축으로 90도 회전
            //xx, yy가 기준이므로 방향이 반대로 바뀐다.
            mdir = (mdir + 2) % 4;


            for (int i = 1; i < 4; i += 2) {
                int ndir = (mdir + i) % 4;
                mx = nextX + dir[ndir][0];
                my = nextY + dir[ndir][1];
                int rx, ry; //회전하면서 지나갈 곳의 좌표
                if (i == 1) {
                    //시계방향 회전인 경우
                    rx = nextX + rotateDir[ndir][0];
                    ry = nextY + rotateDir[ndir][1];
                }
                else {
                    //반시계방향 회전인 경우
                    rx = nextX + rotateDir[mdir][0];
                    ry = nextY + rotateDir[mdir][1];
                }
                // 범위에 만족하는 경우
                if ((mx >= 0 && mx < len && my >= 0 && my < len) && (rx >= 0 && rx < len && ry >= 0 && ry < len)) {
                    // 방문하지 않은 경우
                    if (!isCheck[mx][my][mdir] && board[mx][my] == 0 && board[rx][ry] == 0) {
                        isCheck[mx][my][mdir] = true;
                        q.offer(new Pair(mx, my, mdir, time + 1));
                    }
                }
            }
        }
        return 0;
    }


    private static class Pair {
        int x;
        int y;
        int dir;
        int time;

        public Pair(int x, int y, int dir, int time) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.time = time;
        }

    }
}
