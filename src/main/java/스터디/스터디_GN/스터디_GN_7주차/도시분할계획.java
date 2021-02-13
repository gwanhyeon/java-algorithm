package 스터디.스터디_GN.스터디_GN_7주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
 */
// 전체그래프에서 2개의 최소 신장트리를 만들어서 최소한의 비용으로 2개의 신장트리로 분할을 해야하는 문제이다.
//다음과 같이 처리하려면, 크루스칼알고리즘으로 최소 신장트리를 찾은뒤에 - 최소 신장트리를 구성하는 간선중에서 가장 비용이 큰 간선을 제거하면 됩니다.
// 이렇게 되면 최소 신장 트리가 2개의 부분 그ㅜ래프로 나누어지며 문제에서 요구하는 최적의 해를 만족하게 됩니다.
public class 도시분할계획 {
    static int v,e;
    static int[] parent = new int[100001];
    static List<Graph> edges = new ArrayList<>();
    static int answer = 0;

    static int findParent(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
    static void unionParent(int x, int y){
        x = findParent(x);
        y = findParent(y);
        if(x > y){
            parent[x] = y;
        }else {
            parent[y] = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Graph(x,y,w));
        }
        Collections.sort(edges);
        int last = 0;
        for(int i=0; i<edges.size(); i++){
            int w = edges.get(i).w;
            int x = edges.get(i).x;
            int y= edges.get(i).y;

            if(findParent(x) != findParent(y)){
                unionParent(x,y);
                answer +=w;
                last = w;
            }
        }
        System.out.println(answer - last);

    }

    private static class Graph implements Comparable<Graph> {
        int x;
        int y;
        int w;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public Graph(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Graph o) {
            if(this.w < o.w){
                return -1;
            }
            return 1;
        }
    }
}
