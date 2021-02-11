package 스터디.스터디_GN.스터디_GN_6주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
INPUT:
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

OUTPUT:
3


INPUT2:
4 2
1 3
2 4
3 4
OUPUT2:
-1

*/

// 해당위치를 거쳐서 가는 경우 목적지에 도착하는 최소거리

// 거쳐 갈때 처리 방법 arr[1][k] 1번노드에 연결된 x까지 + arr[k][x]  k번노드부터 x까지 최소거리
public class 미래도시 {
    static int n;       // 노드
    static int e;       // 간선
    static int x;       // 판매하는 회사 위치
    static int k;       // 소개팅 위치
    static int[][] graph = new int[101][101];
    static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 1. 최단거리 테이블 무한 초기화
        for(int i=0; i<101; i++){
            Arrays.fill(graph[i], INF);
        }

        // 2.자기자신으로 가는 비용 0으로 초기화
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j){
                    graph[i][j] = 0;
                }
            }
        }
        // 3.그래프 가중치 초기화
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        // 4. 방문판매회사, 소개팅 위치
        st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 5. 플로이드 워셜 DP
        for(int z=1; z<=n; z++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][z]+graph[z][j]);
                }
            }
        }
        //수행된 결과를 출력
        int answer = graph[1][k] + graph[k][x];

        //도달 할수 없는 경우 -1
        if(answer >= INF){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }
    }
}


