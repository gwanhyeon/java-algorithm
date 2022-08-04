package _2022.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 그래프 순회 - BOJ 1260 BFS DFS
 *
 */
public class boj1260 {
    static int n;
    static int m;
    static int v;
    static int[] isCheck;
    static List<List<Integer>> graphList;
    public static void main(String[] args) throws IOException {

        // variable declaration
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graphList = new ArrayList<>();
        isCheck = new int[m+1];

        // graph init
        for(int i=0; i<=m; i++){
            graphList.add(new ArrayList<>());
        }

        // for loop
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graphList.get(x).add(y);
            graphList.get(y).add(x);
        }

        // starting from the small order
        for(int i=1; i<m; i++){
            Collections.sort(graphList.get(i));
        }

        // method 1 - dfs
        dfs(v);

        // init check
        System.out.println();
        Arrays.fill(isCheck, 0);

        // method 2 - bfs
        bfs(v);
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        isCheck[v] = 1;
        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(int i=0; i<graphList.get(x).size(); i++){
                int y = graphList.get(x).get(i);

                if(isCheck[y] == 0){
                    isCheck[y] = 1;
                    q.add(y);
                }
            }
        }
    }

    public static void dfs(int x){
        isCheck[x] = 1;
        System.out.print(x +  " ");
        for(int i=0; i<graphList.get(x).size(); i++){
            int y = graphList.get(x).get(i);
            if(isCheck[y] == 0){
                dfs(y);
            }
        }
    }
}
