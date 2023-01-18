package _2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 음식물 피하기 https://www.acmicpc.net/problem/1743
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
