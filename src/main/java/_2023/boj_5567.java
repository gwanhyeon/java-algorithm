package _2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_5567 {
    static List<List<Integer>> graph;
    static int[]visited;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList<>();
        visited = new int[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int answer = 0;
        bfs(1);
        for(int i=0; i<=n; i++){
            if(visited[i] == 2 || visited[i] == 3){
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int x) {
        Queue<Integer> q= new LinkedList<>();
        visited[x] = 1;
        q.add(x);

        while(!q.isEmpty()){
            int dx = q.poll();
            for(int i=0; i<graph.get(dx).size(); i++){
                int mx = graph.get(dx).get(i);
                if(visited[mx] == 0){
                    System.out.println("dx " + dx);
                    System.out.println("mx " + mx);
                    visited[mx] = visited[dx]+1;
                    q.add(mx);
                }
            }
        }
    }
}
