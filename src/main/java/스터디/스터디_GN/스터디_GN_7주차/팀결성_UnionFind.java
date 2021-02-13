package 스터디.스터디_GN.스터디_GN_7주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
public class 팀결성_UnionFind {
    static int v,e;
    static int[] parent = new int[100001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 1. 자기 자신으로 초기화시킨다.
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        // 2.union연산을 수행합니다.
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(select == 0){
                unionParent(x,y);
            }else if(select == 1){
                if(findParent(x) == findParent(y)){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }
        }
    }
    private static void unionParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if(x > y){
            parent[x] = y;
        }else {
            parent[y] = x;
        }
    }

    private static int findParent(int x) {
        if(x == parent[x]){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
}
