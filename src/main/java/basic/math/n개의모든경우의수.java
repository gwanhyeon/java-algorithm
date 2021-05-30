package basic.math;

import java.util.ArrayList;
import java.util.List;

public class n개의모든경우의수 {
    static int[] arr = {1,2,3};
    static List<Integer> arrList;
    static boolean[] check;
    public static void main(String[] args) {
        arrList = new ArrayList<>();
        check = new boolean[arr.length];
        //dfs(0, arr.length);       // 순열로 모든 경우 구하기(리스트)
        //dfs1(0, arr.length);      // 순열로 모든 경우 구하기(체크배열)
        // bitMaskDfs();            // 비트마스크로 모든 경우구하기(비트마스크)
//        for(int i=0; i<=3; i++){
//            dfs2(0, i);      // 순열로 모든 경우 구하기(체크배열)
//        }



    }

    // 비트마스크를 이용한 풀이
    private static void bitMaskDfs() {

        int n = 3;
        // 전체집합 (1<<n)-1, -1은 공집합을 뜻한다.

        /* 3의 비트마스크를 구한다. 모든 경우를 다 구하는것을 알 수 있다.
        000
        001
        010
        011
        100
        101
        110
        111
         */
        for(int i=0; i< (1<<n); i++){
            // 001 1
            // 010 2
            // 100 3
            for(int j=0; j<n; j++){
                // AND 연산(&) 대응하는 두 비트가 모두 1일 때, 1을 반환.
                System.out.print("bit: " + (i&1<<j) + " ");
                if((i&1<<j) != 0){
                    System.out.print(arr[j]);
                }
            }
            System.out.println();
        }
    }

    private static void dfs(int cnt, int len) {
        if(cnt == len){
            for (int i = 0; i < arrList.size(); i++) {
                System.out.print(arrList.get(i));
            }
            System.out.println();
            return;
        }
        arrList.add(arr[cnt]);
        dfs(cnt+1, len);
        arrList.remove(arrList.size()-1);
        dfs(cnt+1, len);
    }
    private static void dfs1(int cnt, int len) {
        if(cnt == len){
            for(int i=0; i<arr.length; i++) {
                if (check[i]){
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
            return;
        }
        check[cnt] = true;
        dfs1(cnt+1, len);
        check[cnt] = false;
        dfs1(cnt+1, len);
    }

    private static void dfs2(int cnt, int len) {
        if(cnt == len){
            for(int i=0; i<arr.length; i++) {
                if (check[i]){
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(check[i]) continue;
            check[i] = true;
            dfs2(cnt+1, len);
            check[i] = false;
        }
    }
}
