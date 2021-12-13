package _2021.Samsung.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소_14502번 {
    static int n,m;
    static int answer;
    static int[][] map;
    static int[][] copyMap;
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};       // 북동남서
    static boolean[] isCheckSafe;
    static boolean[][] isCheckVirus;
    static List<Graph> safeAreaList;
    static List<Graph> safeAreaSelectList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        answer = 0;
        safeAreaList = new ArrayList<>();
        safeAreaSelectList = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    safeAreaList.add(new Graph(i,j));
                }
            }
        }
        isCheckSafe = new boolean[safeAreaList.size()];
        dfs_combination(0,0);       //조합으로 풀기
        // dfs_permutation(0);                   //순열으로 돌리기
        System.out.println(answer);
    }

    private static void dfs_combination(int idx, int cnt) {
        // 벽을 세개 다 세운 경우
        if(cnt == 3){
            // map copy
            copyMap = new int[n][m];
            isCheckVirus = new boolean[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    copyMap[i][j] = map[i][j];
                }
            }
            // 복사된 맵에 벽 세우기
            for (int i = 0; i < safeAreaList.size(); i++) {
                if(isCheckSafe[i]){
                    int safeX = safeAreaList.get(i).x;
                    int safeY = safeAreaList.get(i).y;
                    copyMap[safeX][safeY] = 1;
                }

            }

            // 바이러스 전파
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(copyMap[i][j] == 2 && !isCheckVirus[i][j]) {
                        virusSpread(i,j);
                    }
                }
            }
            // 안전영역 구하기
            getSafeAreaSize();
            return;
        }
        for(int i=idx; i<safeAreaList.size(); i++){
            if(isCheckSafe[i]) continue;
            isCheckSafe[i] = true;
            dfs_combination(i,cnt+1);
            isCheckSafe[i] = false;
        }
    }

    private static void dfs_permutation(int cnt) {
        // 벽을 세개 다 세운 경우
        if(cnt == 3){
            // map copy
            copyMap = new int[n][m];
            isCheckVirus = new boolean[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    copyMap[i][j] = map[i][j];
                }
            }
            // 복사된 맵에 벽 세우기
            for (int i = 0; i < safeAreaSelectList.size(); i++) {
                Graph graph = safeAreaSelectList.get(i);
                int x = graph.x;
                int y = graph.y;
                copyMap[x][y] = 1;
            }

            // 바이러스 전파
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(copyMap[i][j] == 2 && !isCheckVirus[i][j]) {
                        virusSpread(i,j);
                    }
                }
            }
            // 안전영역 구하기
            getSafeAreaSize();
            return;
        }
        for(int i=0; i<safeAreaList.size(); i++){
            Graph graph = safeAreaList.get(i);
            if(isCheckSafe[i]) continue;
            isCheckSafe[i] = true;
            safeAreaSelectList.add(new Graph(graph.x, graph.y));
            dfs_permutation(cnt+1);
            safeAreaSelectList.remove(safeAreaSelectList.size()-1);
            isCheckSafe[i] = false;
        }
    }

    private static void getSafeAreaSize() {
        int areaSize = 0;
        for (int i = 0; i < n; i++) {
            for(int j=0; j< m; j++){
                if(copyMap[i][j] == 0) areaSize++;
            }
        }
        answer = Math.max(answer, areaSize);
    }

    private static void virusSpread(int x,int y) {
        Queue<Graph> q = new LinkedList<>();
        q.add(new Graph(x,y));
        isCheckVirus[x][y] = true;

        while(!q.isEmpty()){
            Graph graph = q.remove();
            int dx = graph.x;
            int dy = graph.y;

            for(int i=0; i<4; i++){
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];
                if(isCheckRange(mx, my)) continue;
                if(copyMap[mx][my] == 0 && !isCheckVirus[mx][my]){
                    copyMap[mx][my] = 2;
                    isCheckVirus[mx][my] = true;
                    q.add(new Graph(mx,my));
                }
            }

        }

    }

    private static boolean isCheckRange(int mx, int my) {
        if(mx < 0 || mx >= n || my < 0 || my >= m){
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
