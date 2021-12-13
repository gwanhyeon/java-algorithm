package _2021.손코딩준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.
 */
public class 최단경로_다익스트라 {
    static List<List<Graph>> graphList = new ArrayList<>();
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(br.readLine());
        distance = new int[n+1];

        Arrays.fill(distance, INF);
        for(int i=0; i<=n; i++){
            graphList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graphList.get(x).add(new Graph(y, w));
        }


        dijkstra(startPoint);

        for(int i=1; i<=n; i++){
             if(distance[i] == INF){
                System.out.println("INF");
            }else {
                System.out.println(distance[i]);
            }
        }
    }

    private static void dijkstra(int startPoint) {
        boolean[] isCheck = new boolean[n+1];
        PriorityQueue<Graph> pq = new PriorityQueue();
        distance[startPoint] = 0;
        pq.add(new Graph(startPoint, 0));

        while(!pq.isEmpty()){
            Graph g = pq.poll();
            int dy = g.getY();
            int dw = g.getW();

            if(isCheck[dy]) continue;
            isCheck[dy] = true;

            for(int i=0; i<graphList.get(dy).size(); i++){
                int my = graphList.get(dy).get(i).y;
                int mw = graphList.get(dy).get(i).w;

                if(distance[my] > distance[dy] + mw){
                    distance[my] = distance[dy] + mw;
                    pq.add(new Graph(my, mw));
                }
            }
        }
    }
    static class Graph implements Comparable<Graph>{
        int y;
        int w;

        Graph(int y, int w) {
            this.y = y;
            this.w = w;
        }

        public int getY() {
            return y;
        }

        public int getW() {
            return w;
        }

        @Override
        public int compareTo(Graph graph) {
            if(this.w < graph.w){
                return -1;
            }else {
                return 1;
            }
        }
    }
}
