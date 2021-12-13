import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// https://bcp0109.tistory.com/25
public class 연구소 {
    static class Dot {
        private int x;
        private int y;
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int m;
    static int[][] map;
    static int[][] copy_map;
    static List<Dot> virusList = new ArrayList<Dot>();
    static int[][] dir ={{-1,0},{1,0},{0,1},{0,-1}};
    static int ans = 0;

    static void wallDfs(int idx, int cnt) {

        if(cnt == 3){
            // map Copy
            copyMapFunc();
            // virus spread
            for(Dot dot : virusList){
                virusSpreadBfs(dot.x, dot.y);
            }
            // safe Area
            ans = Math.max(ans, getSafeArea());
            return;
        }

        for(int i=idx; i<n * m; i++){
            int x = i / m;
            int y = i % m;
            if(map[x][y] == 1 || map[x][y] == 2){
                continue;
            }
            map[x][y] = 1;
            wallDfs(i+1, cnt+1);
            map[x][y] = 0;
        }
    }
    // 맵 카피
    static void copyMapFunc() {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy_map[i][j] = map[i][j];
            }
        }
    }
    // 바이러스 퍼트리기
    static void virusSpreadBfs(int x,int y) {
        for(int i=0; i<4; i++){
            int mx = x + dir[i][0];
            int my = y + dir[i][1];

            if(mx >= 0 && mx < n && my >= 0 && my < m){
                if(copy_map[mx][my] == 0){
                    copy_map[mx][my] = 2;
                    virusSpreadBfs(mx,my);
                }
            }
        }

    }
    // 안전영역 개수 체크
    static int getSafeArea() {
        int safe = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copy_map[i][j] == 0){
                    safe += 1;
                }
            }
        }
        return safe;
    }
    /*
    4 6
    0 0 0 0 0 0
    1 0 0 0 0 2
    1 1 1 0 0 2
    0 0 0 0 0 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copy_map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virusList.add(new Dot(i,j));
                }
            }
        }
        wallDfs(0,0);
        System.out.println(ans);
    }



}
