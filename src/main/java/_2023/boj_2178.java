package _2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2178 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] direction = {{1,0},{-1,0},{0, -1}, {0,1}};
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for(int i=0; i<N; i++){
            String[] value = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(value[j]);
            }
        }
        bfs(0,0);

        System.out.println(visited[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<Graph> q = new LinkedList<>();
        q.add(new Graph(x,y));
        visited[x][y] = 1;

        while(!q.isEmpty()){
            Graph g = q.poll();
            int dx = g.x;
            int dy = g.y;
            for(int i=0; i<4; i++){
                int mx = dx + direction[i][0];
                int my = dy + direction[i][1];
                if(isRange(mx,my)){
                    continue;
                }
                if(map[mx][my] == 1 && visited[mx][my] == 0) {
                    visited[mx][my] = visited[dx][dy] + 1;
                    q.add(new Graph(mx, my));
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

    private static class Graph {
        int x;
        int y;
        public Graph(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
