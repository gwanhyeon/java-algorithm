package 스터디.스터디_GN_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연구소 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] copyMap;
    static int[][] dir = {{1,0}, {0,-1}, {-1,0}, {0,1}};
    static List<Graph> virusList = new ArrayList<>();
    static int answer = 0;
    static class Graph{
        private int x;
        private int y;
        public Graph(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copyMap = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virusList.add(new Graph(i,j));
                }
            }
        }
        dfs(0, 0);
        System.out.println(answer);

    }
    static void dfs(int idx, int cnt) {

        // 벽을 모두 세웠을 경우
        if(cnt == 3){

            // 값을 복사해줍니다.
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    copyMap[i][j] = map[i][j];
                }
            }
            // 바이러스 퍼트리기
            for(Graph graph : virusList){
                virusSpread(graph.x, graph.y);
            }

            // 안전영역 구하기
           int safeAreaCnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(copyMap[i][j] == 0){
                        safeAreaCnt++;
                    }
                }
            }
            answer = Math.max(answer, safeAreaCnt);
            return;
        }

        for(int i=idx; i<n*m; i++){
            // 모든 좌표를 구합니다.
            int x = i / m;      // (0,0) (0,1) (0,2)
            int y = i % m;
            if(map[x][y] == 1 || map[x][y] == 2){
                continue;
            } // 0,0
            map[x][y] = 1;      // 벽을 세우는 경우
            dfs(i+1, cnt+1);
            map[x][y] = 0;
        }
    }

     static void virusSpread(int x, int y) {
        // 네 방향에 대해서 탐색을 진행
        for(int i=0; i<4; i++){
            int mx = x+dir[i][0];
            int my = y+dir[i][1];
            if(mx >= 0 && mx < n && my >= 0 && my < m){
                if(copyMap[mx][my] == 0){
                    copyMap[mx][my] = 2;
                    virusSpread(mx,my);
                }
            }
        }
    }
}
