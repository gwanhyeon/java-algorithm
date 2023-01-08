package _2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1260 {
    static List<List<Integer>> arrList = new ArrayList<>();
    static int n = 0;
    static int m = 0;
    static int v = 0;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        arrList = new ArrayList<>();
        isVisited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            arrList.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrList.get(x).add(y);
            arrList.get(y).add(x);
        }
        for(int i=0; i<arrList.size(); i++){
            Collections.sort(arrList.get(i));
        }
        dfs(v);
        System.out.println();
        Arrays.fill(isVisited, false);
        bfs(v);
    }

    private static void dfs(int v) {
        isVisited[v] = true;
        System.out.print(v + " ");
        for(int i=0; i<arrList.get(v).size(); i++){
            int x = arrList.get(v).get(i);
            if(!isVisited[x]){
                dfs(x);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        isVisited[v] = true;

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(int i=0; i<arrList.get(x).size(); i++){
                int y = arrList.get(x).get(i);
                if(!isVisited[y]){
                    isVisited[y] = true;
                    q.add(y);
                }
            }
        }
    }
}
