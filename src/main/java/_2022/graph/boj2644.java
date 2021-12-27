package _2022.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2644 {
    static List<List<Integer>> graphList;
    static int[] isCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        isCheck = new int[n+1];
        graphList = new ArrayList<>();

        // The Number of Nodes
        for(int i=0; i<=n; i++){
            graphList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graphList.get(a).add(b);
            graphList.get(b).add(a);
        }
        bfs(x,y);

        if(isCheck[y] != 0){
            System.out.println(isCheck[y]);
        }else {
            System.out.println(-1);
        }

    }

    private static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isCheck[start] = 0;

        while(!q.isEmpty()){
            int x = q.poll();
            if(x == end){
                break;
            }

            for(int i=0; i<graphList.get(x).size(); i++){
                int y = graphList.get(x).get(i);
                // System.out.println("x : " + x + ", y : " + y);
                if(isCheck[y] == 0){
                    isCheck[y] = isCheck[x] + 1;
                    q.add(y);
                }
            }
        }
    }
}
