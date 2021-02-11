package 스터디.스터디_GN.스터디_GN_7주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
6 4
1 4
2 3
2 4
5 6
 */

// 노드 개수 : 최대 100,000개 V, 노드의 개수와 간선의 개수 E
public class Union_Find_서로소_기본 {
    static int v,e;
    static int[] parent = new int[100001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 1. 부모 테이블상에서 부모를 자기자신으로 초기화
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        // 2. Union 연산 수행
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            unionParent(x,y);
        }

        // 각 원소가 속한 집합 출력하기
        for(int i=1; i<=v; i++){
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력 하기
        for(int i=1; i<=v; i++){
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

    // 3. 두원소가 속한 집합을 합치기
    private static void unionParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        // y의 부모는 x
        if(x < y){
            parent[y] = x;
        }
        // x의 부모는 y
        else {
            parent[x] = y;
        }
    }
    // 특정 원소가 속한 집합을 찾기
    private static int findParent(int x) {
        // 루트노드가 아니라면 루트노드를 찾을때까지 재귀적으로 호출한다.
        if(x == parent[x]){
            return x;
        }
        return findParent(parent[x]);
    }

}
