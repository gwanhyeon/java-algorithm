package _2021.개인문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 단지번호붙이기2667 {
    static int n;
    static int[][] map;
    static int[][] check;
    static int[][] dir= {{-1,0},{0,1},{1,0},{0,-1}};
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new int[n][n];


        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(check[i][j] == 0 && map[i][j] == 1){
                    bfs(i,j,++cnt);
                }
            }
        }
        ans = new int[cnt];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(check[i][j] != 0){
                    ans[check[i][j]-1]++;
                }
            }
        }
        Arrays.sort(ans);
        System.out.println(cnt);
        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]);
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

            for(int i=0; i<4; i++) {
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];

                if (mx >= 0 && mx < n && my >= 0 && my < n) {
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
