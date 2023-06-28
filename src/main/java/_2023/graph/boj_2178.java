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
    static int[][] map;
    static int[][] isChecked;
    static int n;
    static int m;
    static int answer = 1;
    static int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isChecked = new int[n][m];

        for(int i=0; i<n; i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0; j<c.length; j++){
                map[i][j] = c[j]-'0';
            }
        }

        bfs(0,0);
        System.out.println(isChecked[n-1][m-1]);
    }
    static private void bfs(int x, int y){
        Queue<Graph> q = new LinkedList<Graph>();
        isChecked[x][y] = 1;
        q.add(new Graph(x,y));

        while(!q.isEmpty()){
            Graph g = q.poll();
            int dx = g.x;
            int dy = g.y;
            for(int i=0; i<4; i++){
                int mx = dx + directions[i][0];
                int my = dy + directions[i][1];

                if(isRange(mx,my)){
                    continue;
                }

                if(isChecked[mx][my] == 0 && map[mx][my] == 1){
                    q.offer(new Graph(mx,my));
                    isChecked[mx][my]= isChecked[dx][dy] + 1;
                }
            }
        }

    }
    static private boolean isRange(int mx,int my){
        if(mx < 0 || mx >= n || my < 0 || my >= m){
            return true;
        }
        return false;
    }
    static class Graph{
        int x;
        int y;
        public Graph(){}
        public Graph(int x,int y){
            this.x = x;
            this.y = y;
        }

    }
}
