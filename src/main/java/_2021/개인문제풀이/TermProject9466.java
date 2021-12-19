package _2021.개인문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-9466-%ED%85%80-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8
 https://dundung.tistory.com/32
 */

/* 내 풀이1. 4%에서 터짐 */
/*
public class TermProject9466 {
    static int t;
    static ArrayList<ArrayList<Integer>> A;
    static int[] check;
    static int cnt = 0;
    public static void main(유형별.String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            check = new int[n+1];
            A = new ArrayList<>();
            for(int i=0; i<=n; i++){
                A.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<n; i++){
                int x = i+1;
                int y = Integer.parseInt(st.nextToken());
                A.get(x).add(y);
                //A.get(y).add(x);
                check[y]++;
            }
            for(int i=1; i<=n; i++){
                if(check[i] == 0){
                    dfs(i);
                    cnt++;
                }
            }

            System.out.println(cnt);
            cnt = 0;
//            System.out.println(n-cnt);
            Arrays.fill(check,0);
        }
    }
    private static void dfs(int x) {
        //check[x] = 1;
        for(int i=0; i<A.get(x).size(); i++){
            int y = A.get(x).get(i);
            check[y]--;
            if(check[y] == 0) {
                dfs(y);
                cnt++;
            }
        }
    }
}
 */
public class TermProject9466 {
    static int t;
    static int[] A;
    static int[] check;
    static int[] startVertex;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            check = new int[100001];
            A = new int[100001];
            startVertex = new int[100001];

            st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<n; i++){
                int x = i+1;
                int y = Integer.parseInt(st.nextToken());
                A[x] = y;
                check[x] = 0;
                startVertex[x] = 0;
            }
            int ans = 0;
            for(int i=1; i<=n; i++){
                if(check[i] == 0){
                    ans += dfs(i,1,i);
                }
            }
            System.out.println(n-ans);
            Arrays.fill(check,0);
        }
    }

    // A (학생번호, 선택번호), check(체크정점, 방문순서), startVertex (시작지점, 시작정점)
    private static int dfs(int x,int cnt, int step) {
        if(check[x] != 0){
            if(step != startVertex[x]){
                return 0;
            }
            //System.out.println(check[x]);
            return cnt-check[x];        // 현재까지 온 cnt순서에서 현재 방문한 방문순서를 뺴준다.
        }
        check[x] = cnt;             // 방문 순서를넣어준다.
        startVertex[x] = step;      // 시작정점을 넣어준다. 4764
        return dfs(A[x], cnt+1, step);
    }
}
