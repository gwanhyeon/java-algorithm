package _2021.개인문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수4963 {
    static int n,m;
    static int[][] map;
    static int[][] check;
    static int[][] dir= {{-1,0},{0,1},{1,0},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}};
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0){
                break;
            }
            map = new int[n][m];
            check = new int[n][m];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<m; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(check[i][j] == 0 && map[i][j] == 1){
                        bfs(i,j,++cnt);
                    }
                }
            }

            ans = new int[cnt];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(check[i][j] != 0){
                        ans[check[i][j]-1]++;
                    }
                }
            }
            System.out.println(cnt);
            for(int i=0; i<check.length; i++){
                for(int j=0; j<check[i].length; j++){
                    check[i][j] = 0;
                    map[i][j] = 0;
                }
            }
        }

    }

    private static void bfs(int x, int y, int cnt) {
        Queue<Pair> q = new LinkedList<>();
        check[x][y] = cnt;
        q.add(new Pair(x,y));
        while(!q.isEmpty()){
            Pair pair = q.remove();
            int dx = pair.x;
            int dy = pair.y;

            for(int i=0; i<8; i++) {
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];

                if (mx >= 0 && mx < n && my >= 0 && my < m) {
                    if (check[mx][my] == 0 && map[mx][my] == 1) {
                        check[mx][my] = cnt;
                        q.add(new Pair(mx, my));
                    }
                }
            }
        }

    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
