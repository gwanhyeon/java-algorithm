package _2021.스터디.스터디_GN.스터디_GN_7주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25
 */
// 시간복잡도 O(ElogE)시간복잡도 간선의 개수 E
// 크루스칼 알고리즘에서 시간이 가장 오래걸리는부분이 간선을 정렬하는 작업
// 서로소 집합 알고리즘은 정렬 알고리즘의 시간복잡도 보다 작으므로 무시를 진행합니다.
// 최소한의 비용으로 신장트리를 찾아야하는 경우에 발생하는 알고리즘
// N개의 도시중에서 두 도시 사이의 도로를 놓아 전체도시가 연결될 수 있도록 도로를 설치하는 경우




public class 크루스칼알고리즘 {
    // v: 노드개수, 간선: e (노드 최대 100000개)
    static int v,e;
    static int[] parent = new int[100001];

    //모든 간선을 담을 리스트와 최종변수를 담을 변수
    static List<Graph> edges = new ArrayList<>();
    static int answer = 0;

    // 1. 특정 원소가 속한 집합을 찾기(루트노드 찾을때 까지 재귀호출)
    static int findParent(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
    // 2. 두 원소가 속한 집합을 합치기
    static void unionParent(int x,int y){
        x = findParent(x);
        y = findParent(y);
        if(x < y){
            parent[y] = x;
        }else {
            parent[x] = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 부모테이블 자기자신으로 초기화
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        // 간선의 정보 입력받기
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Graph(x,y,w));
        }
        // 간선 비용순으로 정렬진행
        Collections.sort(edges);

        // 간선 모두 탐
        for(int i=0; i<edges.size(); i++){
            int w = edges.get(i).w;
            int x = edges.get(i).getX();
            int y = edges.get(i).getY();

            // 사이클이 발생하지 않는 경우에만 집합에 포함시킵니다.
            if(findParent(x) != findParent(y)){
                unionParent(x,y);
                answer += w;
            }
        }
        System.out.println(answer);

    }

    private static class Graph implements Comparable<Graph>{
        int x;
        int y;
        int w;

        public Graph(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

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

        // 낮은 순서대로 우선순위가지도록 설정
        @Override
        public int compareTo(Graph o) {
            if(this.w < o.w){
                return -1;
            }
            return 1;

        }
    }
}
