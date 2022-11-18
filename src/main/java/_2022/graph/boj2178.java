package _2022.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1
4 6
101111
101010
101011
111011
예제 출력 1
15
 */
public class boj2178 {
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] map;
    static int[][] isValid;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isValid = new int[N][M];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        bfs(0,0);
        System.out.println(isValid[N-1][M-1]);
    }

    private static void bfs(int a, int b) {
        Queue<Graph> q = new LinkedList<>();
        q.add(new Graph(a,b));
        isValid[a][b] = 1;
        while(!q.isEmpty()){
            Graph graph = q.poll();
            int dx = graph.x;
            int dy = graph.y;

            for(int i=0; i<4; i++){
                int mx  = dx + dir[i][0];
                int my = dy + dir[i][1];
                if(isCheckRange(mx, my)) {
                    continue;
                }
                if(isValid[mx][my] == 0 && map[mx][my] == 1){
                    isValid[mx][my] = isValid[dx][dy]+1;
                    q.add(new Graph(mx, my));
                }
            }
        }
    }

    private static boolean isCheckRange(int mx, int my){
        if(mx < 0 || mx >= N || my < 0 || my >= M){
            return true;
        }
        return false;
    }

    private static class Graph {
        int x;
        int y;
        public Graph(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
