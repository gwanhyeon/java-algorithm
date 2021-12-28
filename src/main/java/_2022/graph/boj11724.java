package _2022.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj11724 {
    static List<List<Integer>> graphList;
    static boolean[] isCheck;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graphList = new ArrayList<>();
        isCheck = new boolean[n+1];
        answer = 0;
        for(int i=0; i<=n; i++){
            graphList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graphList.get(x).add(y);
            graphList.get(y).add(x);
        }

        for(int i=1; i<=n; i++){
            if(!isCheck[i]) {
                bfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int x) {
        isCheck[x] = true;
        for(int i=0; i<graphList.get(x).size(); i++){
            int y = graphList.get(x).get(i);
            if(!isCheck[y]){
                dfs(y);
            }
        }
    }
    private static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        isCheck[v] = true;

        while(!q.isEmpty()){
            int x = q.poll();

            for(int i=0; i<graphList.get(x).size(); i++){
                int y = graphList.get(x).get(i);
                if(!isCheck[y]){
                    q.add(y);
                    isCheck[y] = true;
                }
            }
        }
    }
}
