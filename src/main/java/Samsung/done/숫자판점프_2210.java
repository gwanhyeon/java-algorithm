package Samsung.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자판점프_2210 {
    static int[][] map;
    static List<Graph> arrList;
    static List<Integer> selectList;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int n;
    static Set<Integer> s = new HashSet<>();
    static boolean[][] isCheck;
    public static void main(String[] args) throws IOException {
        n = 5;
        map = new int[n][n];
        isCheck = new boolean[n][n];
        arrList = new ArrayList<>();
        selectList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                arrList.add(new Graph(i,j));
            }
        }
        for (int i = 0; i < arrList.size(); i++) {
            Graph graph = arrList.get(i);
            dfs(graph.x,graph.y,0, 0);
        }
        System.out.println(s.size());
    }

    private static void dfs(int x, int y,int cnt, int num) {

        if(cnt == 6){
            s.add(num);
            return;
        }
        for(int i=0; i<4; i++) {
            int mx = x + dir[i][0];
            int my = y + dir[i][1];
            if (isCheckRange(mx, my)) continue;
            dfs(mx, my, cnt + 1, num * 10 + map[mx][my]);
        }
    }
    private static boolean isCheckRange(int mx, int my) {
        if(mx < 0 || mx >= n || my < 0 || my >= n){
            return true;
        }
        return false;
    }

    private static class Graph {
        int x;
        int y;

        public Graph(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
