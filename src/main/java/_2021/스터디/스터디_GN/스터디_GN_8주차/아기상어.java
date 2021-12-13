package _2021.스터디.스터디_GN.스터디_GN_8주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 아기상어는 큰 물고기만 잡아 먹기 가능
 * 2. 크기 같은 물고기 먹지못하지만 이동가능
 * 3. 먹을수 있는 물고기가 1마리라면 그 물고기 먹으로 가기
 * 4. 먹을 수 있는 물고기가 1마리보다 많으면 가장가까운 물고기(지나야하는 칸의 최솟값)
 * 상 -> 좌 순으로 처리
 * 5. 물고기를 먹으면 걸리는 시간도 없고, 먹고나서 해당값은 없어진다
 * 6. 물고기를 먹을때 마다 크기가 3이 된다.
 3
 0 0 1
 0 0 0
 0 9 0
 */
/*
3
0 0 1
0 0 0
0 9 0

4
4 3 2 1
0 0 0 0
0 0 9 0
1 2 3 4
 */
public class 아기상어 {

    static final int h = 21;
    static final int w = 21;
    static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
    static int[][] check = new int[21][21];
    static int[][] map;
    static int minDist = 0;
    static int babySharkSize = 2;
    static int babySharkEatSize = 0;
    static int n;
    static int answer;
    static int minX,minY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        answer = 0;
        int sharkX = 0;
        int sharkY = 0;

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 아기상어위치
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }
        // 상어의 이동시간
        int answer = 0;
        //  최종적으로 먹을수 있는 물고기가 있는지 없는지를 찾아야하기 때문에상어의 위치가 갱신되고 재탐색 진행
        while(true){
            minDist = Integer.MAX_VALUE;
            minX = w;
            minY = h;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    check[i][j] = -1;
                }
            }
            bfs(sharkX, sharkY);
            // 먹을수 있는 물고기를 찾은경우
            if(minX != w && minY != h){
                // 이동시간을 더해줍니다.
                answer += check[minX][minY];
                babySharkEatSize++;

                // 만약 먹은 물고기수가 상어의 크기가 같다면
                if(babySharkEatSize == babySharkSize){
                    babySharkSize++;
                    babySharkEatSize=0;
                }
                // 먹은 물고기 위치 0 갱신
                map[minX][minY] = 0;

                // 상어 위치 갱신
                sharkX = minX;
                sharkY = minY;
            }
            //엄마 상어 찾기
            else {
                break;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int sharkX, int sharkY) {
        Queue<Graph> q = new LinkedList<>();
        q.add(new Graph(sharkX,sharkY));
        check[sharkX][sharkY] = 0;

        while(!q.isEmpty()){
            Graph g = q.remove();
            int dx = g.x;
            int dy = g.y;
            for(int i=0; i<4; i++) {
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];
                if(mx >= 0 && mx < n && my >= 0 && my <n){
                    // 1.자기보다 큰 상어는 지나칠 수 없음
                    if(check[mx][my] != -1 || map[mx][my] > babySharkSize){
                        continue;
                    }
                    // 2. 이동거리를 갱신시켜준다.
                    check[mx][my] = check[dx][dy] + 1;

                    // 3. 먹을수 있는 물고기 인지 체크
                    if(map[mx][my] != 0 && map[mx][my] < babySharkSize){
                        // 3.1최단 거리인지 확인
                        if(check[mx][my] < minDist){
                            minX = mx;
                            minY = my;
                            minDist = check[mx][my];
                        }
                        // 3.2최단거리가 같은게 여러개 일 경우
                        else if(check[mx][my] == minDist){
                            // x점은 동일선상에 있어야하고 위에 있는 값중에서 최소가 되야하므로 my가 min_y보다 작은것이 최소 좌표다.
                            // 3.2.1위쪽
                            if(minX == mx){
                                if(minY > my){
                                    minX = mx;
                                    minY = my;
                                }
                            }
                            // 3.2.2왼쪽
                            else if(minX > mx){
                                minX = mx;
                                minY = my;
                            }
                        }
                    }
                    q.add(new Graph(mx,my));
                }
            }
        }
    }
    private static class Graph{
        int x;
        int y;
        public Graph(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
