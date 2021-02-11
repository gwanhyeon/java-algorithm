package 스터디.스터디_GN.스터디_GN_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제 풀이 시간: 1시간
 * 문제 해결 방법
 * 1. 바이러스만 따로 목록을 구해서 리스트에 담아주기
 * 2. 0인 빈칸인 구간에는 벽을 세개를 세운다.
 * 3. x,y에 대한 모든 좌표의 경우의수(조합을) 구하기 위해서는 n*m 범위까지 순회하고 i/m = x, i % m 으로 처리해서 모든 경우를 구할 수 있다.
 * 조합의 경우를 구하는것이기 때문에 idx의 값으로 이미봤던값들을 쳐다보지 않도록 설정하였다.
 * 4. 만약 벽을 세개 세웠으면 BFS를 수행한다.BFS를 수행시에 벽을 3개세웠을때만 진행할 수 있도록한다.
 * 값이 변경되면 안되기때문에 현재의 값을 copyMap에 담아서 진행한다.
 * 5. BFS를 수행해서 map의 값이 0인 경우가 안전한 영역이 되기 떄뭉네 해당 개수를 구해준다
 * 시간복잡도
 */
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
