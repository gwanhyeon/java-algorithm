package 스터디.스터디_GN.스터디_GN_6주차;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 다익스트라 응용방법 O(ElogV) 전체노드개수 10000개이상도 가능
 * 한 지점에서 다른 특정 지점까지 최단 경로(특정 노드에서 출발하여 다른 노드로 가는 최단 경로를 찾는 알고리즘)
 * 1. 출발 노드를 설정한다.
 * 2. 최단거리 테이블을 초기화한다. 모든값을 INF값으로 설정한다. 초기 테이블
 * 3. 방문하지 않은 노드중에서 최단거리가 가장 짧은 노드를 선택한다.
 * 4. 해당 노드를 거쳐 다른노드로 가는 비용을 계산하여 최단거리 테이블을 생성한다.
 * 5. 3,4번 과정을 확인한다.
 *
 * 다익스트라 기본과 다르게 Priority Queue(힙을 활용하여) 최단거리를 출력합니다.
 * 가장 비용이 높은것들부터 차례대로 처리하기때문에 힙으로 처리하기에 시간복잡도면에서 뛰어나게됩니다.
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

/**
 * 모든 노드로 가기 위한 최단거리 출력 <-> 화성탐사랑 비교해서 풀어보자! 화성탐사는 하나의 노드에서 하나의노드까지의 값을 처리하면됩니다.
 *
 */
public class 다익스트라_응용 {
    static int n;
    static int e;
    static int startNode;
    static List<List<Graph>> graph = new ArrayList<>();
    static int[] arr = new int[100001];
    static final int INF = (int)1e9;
    // 기본에 비해서 체크할 변수가 필요없다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Graph(y,value));
        }
        Arrays.fill(arr, INF);
        dijkstra(startNode);
        // 모든 노드로 가기 위한 최단거리 출력
        for(int i=1; i<=n; i++){
            // 도달할 수 없는 경우, 무한 INFINITY라고 출력
            if(arr[i] == INF){
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(arr[i]);
            }
        }
    }
    private static void dijkstra(int startNode) {
        PriorityQueue<Graph> pq = new PriorityQueue<>();
        // 시작 노드로 가기위한 최단경로는 0으로 설정하여 큐에 삽입
        pq.offer(new Graph(startNode,0));
        arr[startNode] = 0;
        // 큐에 비어있지 않으면
        while(!pq.isEmpty()){
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Graph node = pq.poll();
            // 현재 노드까지 비용
            int dist = node.getDistance();
            // 현재 노드
            int curr = node.getIdx();
            //현재 노드가 이미 처리된적이 있는 노드라면 무시
            if(arr[curr] < dist){
                continue;
            }
            //현재 노드와 연결된 다른 인접한 노드들을 확인
            for(int i=0; i<graph.get(curr).size(); i++){
                int weight = arr[curr] + graph.get(curr).get(i).getDistance();
                //현재 노드를 거쳐서, 다른노드로 이동하는 거리가 더 짧은 경우
                if(weight < arr[graph.get(curr).get(i).getIdx()]){
                    arr[graph.get(curr).get(i).getIdx()] = weight;
                    pq.offer(new Graph(graph.get(curr).get(i).getIdx(),weight));
                }
            }
        }
    }

    static class Graph implements Comparable<Graph>{
        int idx;
        int distance;

        public Graph(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        public int getIdx() {
            return this.idx;
        }

        public int getDistance() {
            return this.distance;
        }

        // 거리비용이 짧은것이 우선순위 높이도록 설정(기준값이 비교대상보다 작은경우 -1, 짧은값대로)
        // (기준값이 비교 대상보다 큰 경우 1)
        /*
        기준 값과 비교대상이 동일한 값일 경우 0
        기준 값이 비교대상 보다 작은 경우 -1
        기준 값이 비교대상 보다 큰 경우 1
         */
        @Override
        public int compareTo(Graph graph) {
            if(this.distance < graph.distance){
                return -1;
            }else {
                return 1;
            }
        }
    }
}
