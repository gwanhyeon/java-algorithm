package 스터디.스터디_GN.스터디_GN_7주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3 3
1 2
1 3
2 3
 */
public class Union_Find_서로소집합_사이클판별 {
    static int v,e;
    static int[] parent = new int[100001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i=1; i<=v; i++){
            parent[i] = i;
        }
        boolean isCheckCycle = false;
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 사이클 발생한 경우
            if(findParent(x) == findParent(y)){
                isCheckCycle = true;
                break;
            }
            // 사이클이 발생하지 않았다면 union 연산 수행
            else {
                unionParent(x,y);
            }
        }
        if(isCheckCycle){
            System.out.println("싸이클입니다.");
        }else {
            System.out.println("none Cycle");
        }
    }
    private static void unionParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if(x < y){
            parent[y] = x;
        }else {
            parent[x] = y;
        }
    }
    private static int findParent(int x) {
        if(x == parent[x]){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
}
