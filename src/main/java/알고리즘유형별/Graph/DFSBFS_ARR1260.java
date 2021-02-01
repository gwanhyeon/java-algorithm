package 코딩테스트.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Queue는 LinkedList 로 선언되어야한다
DFS 진행시 반드시 ArrayList나 LinkedList에 대한 값을 초기화 시켜주어야한다.
 */
public class DFSBFS_ARR1260 {
    static boolean[] check;
    static int[][] A;
    static int n;
    static int m;
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        check = new boolean[n+1];
        A = new int[n+1][n+1];


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x][y] = 1;
            A[y][x] = 1;
        }


        //인접행렬시에는 정렬이 필요 없다!! 인접리스트만 필요하다.
        //자식이 여러개라면 노드 번호가 작은 것 먼저 방문하므로 오름차순으로 정렬
        dfs(start);
        Arrays.fill(check,false);
        System.out.println();
        bfs(start);
    }
    static void dfs(int x) {
        check[x] = true;
        System.out.print(x + " ");

        // 2. 인접 행렬
        for(int i=1; i<=n; i++){
            if(!check[i] && A[x][i] == 1){
                dfs(i);
            }
        }

    }
    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        check[v] = true;
        q.offer(v);

        // 2. 인접 행렬
        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(int i=1; i<=n; i++){
                if(!check[i] && A[x][i] == 1){
                    check[i] =true;
                    q.offer(i);
                }
            }
        }
    }
}
