package _2021.개인문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 시간 초과 !!!!!!!!!!!!!!!! dp문제로 풀어야한다 */
public class 연속합1912 {
    static int[] arr;
    static int[] check;
    static int n;
    static ArrayList<Integer> answer;
    static int max = -1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        check = new int[n];
        answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            dfs(i,1);
        }
        System.out.println(max);
    }

    private static void dfs(int idx, int cnt) {
        if(cnt >= n || idx >= n){
            return;
        }
        int ans = 0;
        for(int i=idx; i<cnt; i++){
            ans += arr[i];
        }
        if(ans != 0){
            if(ans > max){
                max = ans;
            }
        }
        dfs(idx,cnt+1);
        dfs(idx+1,cnt);
    }
}
