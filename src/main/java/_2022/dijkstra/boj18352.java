package _2022.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* boj 18352 특정 거리의 도시 찾기 */

/** 다익스트라 기본 풀이 방식
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


public class boj18352 {
    static List<List<Graph>> graphList;
    static int[] graphArray;
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graphList = new ArrayList<>();
        graphArray = new int[n+1];
        for(int i=0; i<=n; i++){
            graphList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graphList.get(a).add(new Graph(b,1));
        }

        Arrays.fill(graphArray, INF);
        dijkstra(x);

        boolean isDistance = false;
        for(int i=0; i<=n; i++){

            if(k == graphArray[i]){
                System.out.println(i);
                isDistance = true;
            }
        }

        if(!isDistance){
            System.out.println(-1);
        }
    }

    private static void dijkstra(int x) {
        PriorityQueue<Graph> pq = new PriorityQueue<>();
        pq.add(new Graph(x, 0));
        graphArray[x] = 0;

        while(!pq.isEmpty()){
            Graph g = pq.poll();
            int weight = g.weight;
            int curr = g.node;

            if(graphArray[curr] < weight){
                continue;
            }

            for(int i=0; i<graphList.get(curr).size(); i++){
                int currNode = graphList.get(curr).get(i).getNode();
                int currWeight = graphArray[curr] + graphList.get(curr).get(i).getWeight();

                if(currWeight < graphArray[currNode]){
                    graphArray[currNode] = currWeight;
                    pq.offer(new Graph(currNode, currWeight));
                }
            }

        }
    }

    private static class Graph implements Comparable<Graph>{
        int node;
        int weight;

        public Graph(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }


        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Graph graph) {
            if(this.weight < graph.weight){
                return -1;
            }else {
                return 1;
            }

        }
    }
}
