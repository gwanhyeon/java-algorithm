package _2024.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2606 {
    static List<List<Integer>> graphList;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        // 1번 컴퓨터에서 부터 바이러스 전파

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graphList = new ArrayList<>();
        isVisited = new boolean[n+1];
        for(int i=0; i<n+1; i++){
            graphList.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graphList.get(x).add(y);
            graphList.get(y).add(x);
        }
        bfs(1);
        int answer = 0;
        for(int i=2; i<n+1; i++){
            if(isVisited[i]){
                answer++;
            }
        }
    }

    private static void bfs(int v) {
        isVisited[v] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<graphList.get(x).size(); i++){
                int next = graphList.get(x).get(i);
                if(!isVisited[next]){
                    isVisited[next] = true;
                    q.add(next);
                }

            }

        }
    }
}
