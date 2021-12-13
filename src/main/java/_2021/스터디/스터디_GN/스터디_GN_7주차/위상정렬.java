package _2021.스터디.스터디_GN.스터디_GN_7주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
 */
// 위상정렬 시간복잡도 O(V+E) 위상정렬을 수행할때는 차례대로 모든 노드를 확인하면서 해당노드에서 출발하는 간선을 차례대로 제거한다.
// 결과적으로 노드와 간선을 모두 확인한다는 측면에서 O(V+E)시간소
// 위상정렬은 순서가 정해져있는 일련의 작업을 차례대로 수행해야 할때 사용하는 알고리즘이다.
// 방향그래프의 모든 노드를 방향성에 거스르지않도록 순서대로 나열하는것을 뜻한다.
public class 위상정렬 {
    // v: 노드개수, e: 간선의 개수 노드의 개수는 최대 100,000개
    static int v,e;
    static int[] indegree = new int[100001];
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for(int i=0; i<=v; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 정점 x->y이동
            graph.get(x).add(y);
            // 진입차수를 증가시킨다.
            indegree[y]+=1;
        }
        topologySort();

    }

    private static void topologySort() {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // 처음시작시 진입차수가 0인 노드를 큐에 삽입한다.
        for(int i=1; i<=v; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            answer.add(curr);
            //해당원소가 연결된 노드들의 진입차수에서 -1
            for(int i=0; i<graph.get(curr).size(); i++){
                indegree[graph.get(curr).get(i)] -=1;
                if(indegree[graph.get(curr).get(i)] == 0){
                    q.offer(graph.get(curr).get(i));
                }
            }
        }
        for (Integer ans : answer) {
            System.out.print(ans + " ");
        }
    }

}
