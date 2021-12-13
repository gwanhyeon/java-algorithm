package _2021.스터디.스터디_GN.스터디_GN_15주차;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 배달 {
    static List<List<Graph>> arrList = new ArrayList<>();
    static int[] check;
    public static void main(String[] args) {
        solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3);
    }
    static int solution(int N, int[][] road, int K) {
        int answer = 0;
        check = new int[N+1];
        // TODO 최솟값이므로 Integer.MAX_VALUE
        Arrays.fill(check, Integer.MAX_VALUE);
        for(int i=0; i<=N; i++){
            arrList.add(new ArrayList<>());
        }
        for (int i = 0; i < road.length; i++) {
            int x = road[i][0];
            int y = road[i][1];
            int w = road[i][2];
            arrList.get(x).add(new Graph(y,w));
            arrList.get(y).add(new Graph(x,w));
        }
        bfs(arrList, 1);
        for (int c : check) {
            // K시간 이하 개수 카운트
            // TODO
            if(c <= K) answer++;
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    private static void bfs(List<List<Graph>> arrList, int start){
        PriorityQueue<Graph> pq = new PriorityQueue();
        // TODO
        check[start] = 0;   // check
        pq.add(new Graph(start, 0));
        while(!pq.isEmpty()) {
            Graph g = pq.poll();
            int dy = g.y;
            int dw = g.w;
            for (int i = 0; i < arrList.get(dy).size(); i++) {
                int my = arrList.get(dy).get(i).y;
                int mw = arrList.get(dy).get(i).w;
                // check[dy]+mw less than check[my]
                if (check[my] > check[dy] + mw) {
                    check[my] = check[dy] + mw;
                    pq.add(new Graph(my, mw));
                }
            }
        }
    }
    static class Graph implements Comparable<Graph>{
        int y;
        int w;
        public Graph(int y,int w){
            this.y = y;
            this.w = w;
        }
        @Override
        public int compareTo(Graph g){
            return Integer.compare(this.w, g.w);
        }
    }
}