package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1260 {
    static int n;
    static int m;
    static int v;
    static boolean[] isVisited;
    static List<List<Integer>> arrList;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n+1];
        arrList = new ArrayList<>();

        for(int i=0; i<n+1; i++){
            arrList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrList.get(x).add(y);
            arrList.get(y).add(x);
        }

        for(int i=0; i<n+1; i++){
            Collections.sort(arrList.get(i));
        }
        dfs(v);
        Arrays.fill(isVisited, false);
        System.out.println();
        bfs(v);
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        isVisited[v] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(int i=0; i<arrList.get(x).size(); i++){
                int next = arrList.get(x).get(i);
                if(!isVisited[next]){
                    isVisited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    private static void dfs(int v) {
        isVisited[v] = true;
        System.out.print(v + " ");

        for(int i=0; i < arrList.get(v).size(); i++){
            int next = arrList.get(v).get(i);
            if(!isVisited[next]){
                dfs(next);
            }
        }

    }
}
