package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 {
    static int[][] map;
    static int[][] isVisited;
    static int n;
    static int m;
    static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisited = new int[n][m];
        answer = 0;
        for(int i=0; i<n; i++){
            String read = br.readLine();

            for(int j=0; j<read.length(); j++){
                map[i][j] = Integer.parseInt(String.valueOf(read.charAt(j)));
            }
        }
        bfs(0,0);
        System.out.println(isVisited[n-1][m-1]);


    }

    private static void bfs(int x, int y) {
        Queue<Graph> q= new LinkedList<>();
        q.add(new Graph(x,y));
        isVisited[x][y] = 1;
        while(!q.isEmpty()){
            Graph g = q.poll();
            int dx = g.x;
            int dy = g.y;

            for(int i=0; i<4; i++){
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];

                if(isRange(mx,my)){
                    continue;
                }
                if(map[mx][my] == 1 && isVisited[mx][my] == 0) {
                    q.add(new Graph(mx, my));
                    isVisited[mx][my] = isVisited[dx][dy]+1;
                }

            }
        }

    }

    private static boolean isRange(int mx, int my) {
        if(mx >= n || mx < 0 || my >= m || my < 0){
            return true;
        }
        return false;
    }

    private static class Graph {
        int x;
        int y;
        public Graph(){
        }
        public Graph(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
