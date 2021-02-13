package 스터디.스터디_GN.스터디_GN_7주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
4
3
4
1
1
 */
public class 탑승구 {
    static int[] parent = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 탑승구 수
        int v = Integer.parseInt(br.readLine());
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }
        // 비행기수
        int a = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0; i<a; i++){
            int x = Integer.parseInt(br.readLine());
            int root = findParent(x);
            if(root == 0){
                break;
            }
            unionParent(root, root-1);
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void unionParent(int x,int y) {
        x = findParent(x);
        y = findParent(y);
        if(x < y){
            parent[y] = x;
        }else {
            parent[x] = y;
        }
    }
    private static int findParent(int x) {
        if(parent[x] == x){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
}
