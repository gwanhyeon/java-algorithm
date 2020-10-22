import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순열사이클10451 {
    static int t;
    static int n;
    static boolean[] check;
    static ArrayList<ArrayList<Integer>> A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            check = new boolean[n+1];
            StringTokenizer st;
            A = new ArrayList<>();
            for(int i=0; i<=n; i++){
                A.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<n; i++){

                int x = i+1;
                int y = Integer.parseInt(st.nextToken());

                A.get(x).add(y);
                A.get(y).add(x);
            }
            int cnt = 0;
            for(int i=1; i<=n; i++){
                if(!check[i]){
                    dfs(i);
                    cnt++;
                }
            }
            System.out.println(cnt);
            Arrays.fill(check,false);
        }
    }

    private static void dfs(int x) {
        check[x] = true;
        for(int i=0; i<A.get(x).size(); i++){
            int y = A.get(x).get(i);
            if(!check[y]){
                dfs(y);
            }
        }
    }
}
