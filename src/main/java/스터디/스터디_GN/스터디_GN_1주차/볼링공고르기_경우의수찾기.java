package 스터디.스터디_GN.스터디_GN_1주차;

import java.util.Arrays;

/**
 * 경우의 수 찾는 문제!!
 * 볼링공이 1번부터 시작하므로 A 선택, B선택할시의 경우의수 무게 1,2,3 경우의수 * (B가 선택하는 경우의 수) 이미 계산했던 경우 조합은 제외된다는게 포인트이다.
 *
 */
public class 볼링공고르기_경우의수찾기 {
    static int[] check;
    static int answer = 0;
    public static void main(String[] args) {

        // 재귀 호출 정답 X
        solution(5,3,new int[]{1,3,2,3,2});
        solution(8,5,new int[]{1,5,4,3,2,4,5,2});
        // greedy
        solution1(5,3,new int[]{1,3,2,3,2});
    }

    private static void solution1(int n, int m, int[] arr) {

        int[] map = new int[11];
        Arrays.sort(arr); // 12233
        // 볼링공 개수 카운트
        for(int i=0; i<arr.length; i++){
            map[arr[i]]++;
        }
        // map[1] = 1 map[2] = 2 map[3] = 2
        // 무게가 1인 볼링공 1
        // 무게가 2인 볼링공 2
        // 무게가 3인 볼링공 2

        int answer = 0;
        // 볼링공이 1번부터 시작하므로 A 선택, B선택할시의 경우의수 무게 1,2,3 경우의수 * (B가 선택하는 경우의 수)
        for(int i=1; i<m+1; i++){
            n -= map[i];        // 해당무게는 선택된 경우의수므로 n의 값에서 감소
            answer += map[i] * n;
        }

    }

    private static void solution(int n, int m, int[] map) {
        check = new int[n];
        //Arrays.sort(map);
        dfs(n,m,map,0,0);
        System.out.println(answer);
        //System.out.println(hs.size());
    }

    private static void dfs(int n, int m, int[] map, int cnt, int idx) {

        if(cnt == 2){
            answer++;
            for(int i=0; i<n; i++){
                if(check[i] == 1){
                    System.out.print(i+1);
                }
            }
            System.out.println();
            return;
        }

        for(int i=idx; i<n; i++){
            if(check[i] == 1){
                continue;
            }
            check[i] = 1;
            dfs(n,m,map,cnt+1, i);
            check[i] = 0;
        }
    }
}
