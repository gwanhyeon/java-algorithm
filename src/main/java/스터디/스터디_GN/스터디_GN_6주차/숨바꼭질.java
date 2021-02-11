package 스터디.스터디_GN.스터디_GN_6주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
모든 헛간을 방문한다음에, 가장멀리있는노드에 대한 인덱스와 비용값을 출력해줍니다.
그리고나서, 같은 지점이 있으면 해당 리스트에 담아서 사이즈를 리턴해주면 구할 수 있습니다.
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
 */
public class 숨바꼭질 {
    static int INF = (int)1e9;
    static int start = 1;
    static int n;
    static int m;
    static List<List<Graph>> graph = new ArrayList<>();
    static int[] distance = new int[20001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Graph(y,1));
            graph.get(y).add(new Graph(x,1));
        }
        Arrays.fill(distance,INF);

        dijkstra(start);

        int maxNode = 0;

        int maxDistance = 0;

        List<Integer> answer = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if(maxDistance < distance[i]){
                maxNode = i;
                maxDistance = distance[i];
                answer.clear();
                answer.add(maxNode);
            }else if(maxDistance == distance[i]){
                answer.add(i);
            }
        }
        System.out.println(maxNode + " " + maxDistance + " " + answer.size());


    }

    private static void dijkstra(int start) {
        PriorityQueue<Graph> pq = new PriorityQueue<>();
        pq.offer(new Graph(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Graph g = pq.poll();
            int dist = g.getDistance();
            int idx = g.getIdx();

            // 처리된적이 있는 노드라면 무시하기
            if(distance[idx] < dist){
                continue;
            }
            // 현재노드와 이미 처리된적이 있는 노드라면 무시하기
            for(int i=0; i<graph.get(idx).size(); i++){

                int weight = distance[idx] + graph.get(idx).get(i).getDistance();
                // 현재노드를 거쳐 다른노드로 이동하는 거리가 더 짧은경우
                if(weight < distance[graph.get(idx).get(i).getIdx()]){
                    distance[graph.get(idx).get(i).getIdx()] = weight;
                    pq.offer(new Graph(graph.get(idx).get(i).getIdx(), weight));
                }
            }
        }
    }

    private static class Graph implements Comparable<Graph> {
        int idx;
        int distance;

        public Graph(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(Graph o) {
            if(this.distance < o.distance){
                return -1;
            }
            return 1;
        }
    }
}
