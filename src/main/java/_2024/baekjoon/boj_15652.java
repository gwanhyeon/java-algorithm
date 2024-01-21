package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15652 {
    static boolean[] isVisited;
    static int n;
    static int m;
    static List<Integer> arrList;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        // 조합문제

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n];
        arrList = new ArrayList<>();
        answer = new ArrayList<>();
        for(int i=1; i<=n; i++){
            arrList.add(i);
        }
        dfs(0, 0);

    }

    private static void dfs(int idx, int cnt) {
        if(cnt == m){
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for(int i=idx; i<n; i++){

            answer.add(arrList.get(i));
            dfs(i, cnt+1);
            answer.remove(answer.size()-1);
        }
    }

}
