package 스터디.스터디_GN.스터디_GN_6주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 다익스트라 가장 간단한 방법 O(V^2) 전체노드개수 5000개 이하까지만 가능하다.
 * 한 지점에서 다른 특정 지점까지 최단 경로(특정 노드에서 출발하여 다른 노드로 가는 최단 경로를 찾는 알고리즘)
 *
 *
 * 1. 출발 노드를 설정한다.
 * 2. 최단거리 테이블을 초기화한다. 모든값을 INF값으로 설정한다. 초기 테이블
 * 3. 방문하지 않은 노드중에서 최단거리가 가장 짧은 노드를 선택한다.
 * 4. 해당 노드를 거쳐 다른노드로 가는 비용을 계산하여 최단거리 테이블을 생성한다.
 * 5. 3,4번 과정을 확인한다.
 *
 */
/*
TEST CASE
INPUT:
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
OUTPUT:
0
2
3
1
2
4
 */
public class 다익스트라_기본 {
    static final int INF = (int)1e9;       // (int) 1e9
    static int n;       // 노드의개수
    static int e;       // 간선의 개수
    static int startNode;       // 시작 노드 번호
    static List<List<Graph>> graph = new ArrayList<>();     // 각 노드에 연결되어 잇는 노드에 대한 정보를 담는 배열
    static boolean[] check = new boolean[100001];      // 방문한적 있는지 체크
    static int[] arr = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(br.readLine());

        // 그래프 초기화
       for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        // 간선의 개수만큼 입력
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            // x->y = value
            graph.get(x).add(new Graph(y,value));
        }
        // 테이블 무한으로 초기화
        Arrays.fill(arr, INF);
        dijkstra(startNode);

        // 모든 노드로 가기 위한 최단 거리 출력
        for(int i=1; i<=n; i++){
            //도달할 수 없는경우 INF출력
            if(arr[i] == INF){
                System.out.println("INFINITY");
            }
            // 도달할 수 있는경우
            else {
                System.out.println(arr[i]);
            }
        }
    }

    private static void dijkstra(int startNode) {
        // 시작점은 거리가 0
        arr[startNode] = 0;
        // 시작점 체크
        check[startNode] = true;
        // 방문한 노드를 기준으로 해당인덱스, 거리 테이블을 초기화
        for(int i=0; i<graph.get(startNode).size(); i++){
            arr[graph.get(startNode).get(i).getIdx()] = graph.get(startNode).get(i).getDistance();
        }

        //시작노드를 제외한 전체 n-1개의 노드에 대해 반복
        for(int i=0; i<n-1; i++){
            // 최단거리가 가장 짧은 노드를 꺼내서, 방문 처리합니다.
            int curr = getMinNode();
            check[curr] = true;

            // 현재 노드와 연결된 다른 노드를 확인합니다.
            for(int j=0; j<graph.get(curr).size(); j++){
                int weight = arr[curr] + graph.get(curr).get(j).getDistance();
                if(weight < arr[graph.get(curr).get(j).getIdx()]){
                    arr[graph.get(curr).get(j).getIdx()] = weight;
                }
            }
        }

    }
    private static int getMinNode() {
        int minValue = INF;
        int idx = 0;        // 최단거리가 가장 짧은 노드 idx
        for(int i=1; i<=n; i++){
            if(arr[i] < minValue && !check[i]){
                minValue = arr[i];
                idx = i;
            }
        }
        return idx;
    }

    // 그래프 클래스 구현
    static class Graph{
        private int idx;
        private int distance;

        public Graph(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        public int getIdx() {
            return idx;
        }

        public int getDistance() {
            return distance;
        }
    }

}
