package _2021.알고리즘템플릿;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
INPUT:
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
OUTPUT:
0 4 8 6
3 0 7 9
5 9 0 4
7 11 2 0
 */
public class 플로이드워셜_여러점에서_다른점들까지_최단경로 {

    static final int INF = (int)1e9;
    static int n,e;
    static int[][] graph = new int[501][501];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        // 최단거리테이블들을 모두 무한으로 초기화
        for(int i=0; i<501; i++){
            Arrays.fill(graph[i],INF);
        }
        //자기자신으로 가는 비용은 0으로 초기화
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j){
                    graph[i][j] = 0;
                }
            }
        }
        // 간선에 대한 정보를 입력받아 그값으로 초기화
        for(int i=0; i<e; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[x][y] = value;
        }

        // 점화식에 따라 dp 진
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                // 도달할 수 없는 경우, 무한(INFINITY)라고 출력
                if(graph[i][j] == INF) {
                    System.out.println("INFINITY");
                }else {
                    System.out.print(graph[i][j]+ " ");
                }
            }
            System.out.println();
        }
    }
}
