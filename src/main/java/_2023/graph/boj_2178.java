package _2023.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
미로 탐색 성공

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	192 MB	150739	65903	42269	42.371%
문제
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
예제 입력 2
4 6
110110
110110
111111
111101
예제 출력 2
9
예제 입력 3
2 25
1011101110111011101110111
1110111011101110111011101
예제 출력 3
38
예제 입력 4
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
예제 출력 4
13
 */
public class boj_2178 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] direction = {{1,0},{-1,0},{0, -1}, {0,1}};
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for(int i=0; i<N; i++){
            String[] value = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(value[j]);
            }
        }
        bfs(0,0);

        System.out.println(visited[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<Graph> q = new LinkedList<>();
        q.add(new Graph(x,y));
        visited[x][y] = 1;

        while(!q.isEmpty()){
            Graph g = q.poll();
            int dx = g.x;
            int dy = g.y;
            for(int i=0; i<4; i++){
                int mx = dx + direction[i][0];
                int my = dy + direction[i][1];
                if(isRange(mx,my)){
                    continue;
                }
                if(map[mx][my] == 1 && visited[mx][my] == 0) {
                    visited[mx][my] = visited[dx][dy] + 1;
                    q.add(new Graph(mx, my));
                }
            }
        }


    }

    private static boolean isRange(int mx, int my) {
        if(mx < 0 || mx >= N || my < 0 || my >= M){
            return true;
        }
        return false;
    }

    private static class Graph {
        int x;
        int y;
        public Graph(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
