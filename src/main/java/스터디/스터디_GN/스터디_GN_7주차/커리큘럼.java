package 스터디.스터디_GN.스터디_GN_7주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */
public class 커리큘럼 {
    static int v,e;
    static int[] indegree = new int[501];
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] times = new int[501];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for(int i=0; i<=v; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            times[i] = x;
            while(true){
                x = Integer.parseInt(st.nextToken());
                if(x == -1){
                    break;
                }
                indegree[i] += 1;
                graph.get(x).add(i);
            }
        }
        topologySort();
    }

    private static void topologySort() {
        int[] answer = new int[501];
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=v; i++){
            answer[i] = times[i];
        }

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int i=0; i<graph.get(curr).size(); i++){
                answer[graph.get(curr).get(i)] = Math.max(answer[graph.get(curr).get(i)], answer[curr] + times[graph.get(curr).get(i)]);
                indegree[graph.get(curr).get(i)] -= 1;
                if(indegree[graph.get(curr).get(i)] == 0){
                    q.offer(graph.get(curr).get(i));
                }
            }
        }

        for (Integer ans : answer) {
            System.out.println(ans);
        }


    }
}
