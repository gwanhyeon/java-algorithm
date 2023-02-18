package _2023.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
음식물 피하기 성공다국어

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	13878	6514	5202	46.823%
문제
코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다. 그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다. 이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다.

이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다. 참고로 우리가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다.

통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다.

선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.

입력
첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ N×M)이 주어진다.  그리고 다음 K개의 줄에 음식물이 떨어진 좌표 (r, c)가 주어진다.

좌표 (r, c)의 r은 위에서부터, c는 왼쪽에서부터가 기준이다. 입력으로 주어지는 좌표는 중복되지 않는다.

출력
첫째 줄에 음식물 중 가장 큰 음식물의 크기를 출력하라.

예제 입력 1
3 4 5
3 2
2 2
3 1
2 3
1 1
예제 출력 1
4
힌트
# . . .
. # # .
# # . .

 */
public class boj_1743 {
    static int[][] trashsArray;
    static int[][] isVisited;
    static int N;
    static int M;
    static int K;
    static int[][] dir = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    static int cnt = 0;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isVisited = new int[N][M];
        trashsArray = new int[N][M];
        answer = -1;
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            trashsArray[x-1][y-1] = 1;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(isVisited[i][j] == 0 && trashsArray[i][j] == 1){
                    cnt = 0;
                    bfs(i,j);
                    answer = Math.max(answer, cnt);
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        Queue<Trash> q = new LinkedList<>();
        q.add(new Trash(x,y));
        isVisited[x][y] = 1;
        cnt++;
        while(!q.isEmpty()){
            Trash p = q.poll();
            int dx = p.x;
            int dy = p.y;

            for(int i=0; i<4; i++){
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];
                if(isRange(mx,my)){
                    continue;
                }
                if(isVisited[mx][my] == 0 && trashsArray[mx][my] == 1){
                    isVisited[mx][my] = 1;
                    cnt++;
                    q.add(new Trash(mx,my));
                }
            }
        }
    }
    private static boolean isRange(int mx, int my) {
        if(mx < 0 || mx >= N || my < 0 || my >= M){
            return true;
        }
        return false;
    }

    private static class Trash {
        int x;
        int y;
        public Trash(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
