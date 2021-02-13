package 스터디.스터디_GN.스터디_GN_7주차;
// 394P, 581P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * union-find 서로소 집합
 * 1. 자기자신으로 초기화를 진행한다. 해당노드의 번호로 값 초기화
 * 2. 값이 1로 되어있는경우 연결된 경우이므로 1일 경우 union, 0인 경우 무시
 * 3. 플랜계획에 들어가있는 리스트들을 기반으로해서 부모의 노드가 모두 같은지를 체크한다.
 * 부모의 노드가 다르다는것은 결국 다른 여행경로를 가지고 있다는것이기때문에 다르다는게 하나라도 나오면 false, 그게아니면 true
 * 를 처리하여 YES OR NO를 출력시켜준다.
 5 4
 0 1 0 1 1
 1 0 1 1 0
 0 1 0 0 0
 1 1 0 0 0
 1 0 0 0 0
 2 3 4 3
 */
/*
5 4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
2 3 4 3
 */
public class 여행계획_UnionFind {
    static int[] arr = new int[501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 1. 자기 자신으로 초기화를 진행한다.
        for(int i=1; i<=v; i++){
            arr[i] = i;
        }

        // 2. 값이 1로 되어있는경우 연결된 경우이므로 1일 경우 union, 0인 경우 무시
        for(int i=1; i<=v; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    unionParent(i, j);
                }
                j++;
            }
        }
        // 3. 방문해야하는 경로 입력받기
        List<Integer> planList = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            planList.add(Integer.parseInt(st.nextToken()));
        }
        boolean isCheck = true;
        for(int i=0; i<planList.size()-1; i++){
            if (unionFindParent(planList.get(i)) != unionFindParent(planList.get(i + 1))) {
                isCheck = false;
            }
        }
        System.out.println(isCheck? "YES" : "NO");
    }
    // 노드간 union
    private static void unionParent(int x, int y) {
        x = unionFindParent(x);
        y = unionFindParent(y);
        // 값이 더 크다는것은 y가 부모가 될 수 없으므로 x를 부모로 생각하면된다.
        if(x < y){
            arr[y] = x;
        }else {
            arr[x] = y;
        }
    }
    // 가장큰 부모 노드를 찾기
   private static int unionFindParent(int x) {
        if(arr[x] == x){
            return x;
        }
        return arr[x] = unionFindParent(arr[x]);
    }
}
