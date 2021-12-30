package _2022.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
boj 15649 backtracking nm 시리즈(1)
 */
public class boj15649 {
    static boolean[] isNumberCheck;
    static LinkedList<Integer> numbers;
    static int[] arrayNumbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        numbers = new LinkedList<>();
        arrayNumbers = new int[n+1];
        isNumberCheck = new boolean[n+1];
        dfs1(n,m,0);
        Arrays.fill(isNumberCheck, false);
        dfs2(n,m,0);
    }
    // list solution 1
    private static void dfs1(int n, int m, int cnt) {
        if(cnt == m){
            for(int i=0; i<numbers.size(); i++){
                System.out.print(numbers.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++) {
            if (isNumberCheck[i]) continue;
            numbers.add(i);
            isNumberCheck[i] = true;
            dfs1(n, m, cnt + 1);
            isNumberCheck[i] = false;
            numbers.removeLast();

        }
    }
    // arrays solution 2
    private static void dfs2(int n, int m, int cnt){
        if(cnt == m){
            for(int i=0; i<m; i++){
                System.out.print(arrayNumbers[i]);
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++){
            if(isNumberCheck[i]) continue;
            isNumberCheck[i] = true;
            arrayNumbers[cnt] = i;
            dfs2(n,m,cnt+1);
            isNumberCheck[i] = false;
        }
    }
}
