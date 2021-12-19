package _2021.개인문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 이분 그래프
정점에 번갈아가면서 색깔을 칠해주는것이 정리
https://lmcoa15.tistory.com/32

 */
public class 이분그래프1707 {
    static int t;
    static ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            check = new int[n+1];
            A = new ArrayList<>();
            for(int i=0; i<=n; i++){
                A.add(new ArrayList<Integer>());
            }

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                A.get(x).add(y);
                A.get(y).add(x);
            }

            for(int i=1; i<=n; i++){
                if(check[i] == 0){

                    dfs(i,1);

                }
            }
            boolean tf = true;
            for(int i=1; i<=n; i++){
                for(int j=0; j<A.get(i).size(); j++){
                    int k = A.get(i).get(j);
                    if(check[i]== check[k]){
                        tf = false;
                    }
                }
            }

            if(!tf){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
            Arrays.fill(check,0);
        }
    }

    private static void dfs(int x, int cnt) {
        check[x] = cnt;
        System.out.println(x);
        //System.out.println(cnt);
        // 해당원리 https://ko.wikipedia.org/wiki/%EC%9D%B4%EB%B6%84_%EA%B7%B8%EB%9E%98%ED%94%84
        // 이분그래프라고해서 정점에서 2개씩나오는게 절대아니다
        // 하나의 정점에서 다른정점으로 색칠을 번갈아해준다 번갈아서하다보면 cnt의 값이 0이 나올일은 절대없다
        // recursive 1->2 2->1로 값이 번갈아서 색칠되는것을 볼 수 있다.
        // 골똘하게 잘 생각해보면 보인다

        for(int i=0; i<A.get(x).size(); i++){
            int y = A.get(x).get(i);
            if(check[y] == 0){
                dfs(y,3-cnt);
            }
        }
    }
}
