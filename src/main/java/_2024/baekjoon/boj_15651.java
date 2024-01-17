package _2024.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 수열 or 조합
// 같은수 여러번 골라도 된다.(수열)
public class boj_15651 {
    static int n;
    static int m;
    static boolean[] isVisited;
    static List<Integer> arrList;
    static List<Integer> answer;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        arrList = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n];
        answer = new ArrayList<>();
        for(int i=1; i<=n; i++){
            arrList.add(i);
        }
        dfs(0);
        System.out.print(sb.toString());
    }

    private static void dfs(int cnt) throws IOException {
        if(cnt == m){
            for(int i=0; i<answer.size(); i++){
                sb.append(answer.get(i) +  " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            answer.add(arrList.get(i));
            dfs( cnt+1);
            answer.remove(answer.size()-1);
        }
    }
}
