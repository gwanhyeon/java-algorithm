package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_15652 {
    static boolean[] isVisited;
    static int n;
    static int m;
    static List<Integer> arrList;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        // 조합문제

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        isVisited = new boolean[n];
        arrList = new ArrayList<>();
        answer = new ArrayList<>();
        for(int i=1; i<=n; i++){
            arrList.add(i);
        }
        Collections.reverse(arrList);
        dfs(0, 0);

    }

    private static void dfs(int idx, int cnt) {
        if(cnt == m){
            for(int i=0; i<arrList.get(i); i++){

            }
            return;
        }
        for(int i=n-1; i>=idx; i++){
            dfs(i, cnt+1);
        }
    }

}
