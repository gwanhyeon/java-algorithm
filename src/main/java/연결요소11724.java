import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
BFS DFS두가지 방법으로 사용하
 */
public class 연결요소11724 {
    static int n;
    static int m;
    static boolean[] connCheck;
    static boolean[] check;
    static ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for(int i=0; i<=n; i++){
            A.add(new ArrayList<Integer>());
        }
        check = new boolean[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A.get(x).add(y);
            A.get(y).add(x);
        }

        int answer = 0;
        for(int i=1; i<=n; i++){
            if(!check[i]){
                //dfs(i);
                bfs(i);
                answer++;
            }
        }
        System.out.println(answer);


    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        check[v] = true;

        while(!q.isEmpty()){
            int x = q.poll();

            for(int i=0; i<A.get(x).size(); i++){
                int y = A.get(x).get(i);
                if(!check[y]){
                    check[y] = true;
                    q.offer(y);
                }
            }
        }
    }

    private static void dfs(int x) {
        check[x] = true;
        for(int i=0; i<A.get(x).size(); i++){
            int y = A.get(x).get(i);
            if(!check[y]){
                check[y] = true;
                dfs(y);
            }
        }

    }


}
