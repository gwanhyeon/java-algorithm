package _2021.스터디.스터디_GN.스터디_GN_6주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
다익스트라 방식으로 푸는 문제 BFS와 유사하다. 그 이유는 거리가 1인 경우 BFS로 충분히 해결이 가능하다.
가장 위쪽 칸인 [0][0]위치에서 가장 오른쪽 아래인 [n-1][n-1]위치로 이동하는 최소비용을 출력하는 프로그램을 작성해야합니다.
이때, 상하좌우 인접한곳은 1칸씩 이동할 수 있습니다.
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
 */
public class 화성탐사 {
    static int dir[][] = {{1,0},{0,-1},{-1,0},{0,1}};
    static int[][] arr;
    static int check[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            check = new int[n][n];

            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    check[i][j] = (int)1e9;
                }
            }

            dijkstra(0,0,n, arr);
            System.out.println(check[n-1][n-1]);
        }

    }

    private static void dijkstra(int x, int y, int n, int[][] arr) {
        PriorityQueue<Graph> pq = new PriorityQueue<>();
        pq.offer(new Graph(x,y,arr[0][0]));

        while(!pq.isEmpty()){
            Graph graph = pq.poll();
            int dx = graph.x;
            int dy = graph.y;
            int dw = graph.weight;

            for(int i=0; i<4; i++){
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];
                if(mx >= 0 && mx < n && my >= 0 && my < n){
                    int moveWeight = arr[mx][my] + dw;
                    if(check[mx][my] > moveWeight){
                        check[mx][my] = moveWeight;
                        pq.offer(new Graph(mx,my,moveWeight));
                    }
                }
            }
        }
    }
    private static class Graph implements Comparable<Graph>{
        int x;
        int y;
        int weight;

        public Graph(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
        @Override
        public int compareTo(Graph o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
