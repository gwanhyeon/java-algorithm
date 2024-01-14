package _2024.baekjoon;

import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15650 {
    static int n;
    static int m;
    static boolean[] isVisited;
    static List<Integer> arrList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrList = new ArrayList<>();
        isVisited = new boolean[n];
        for(int i=1; i<=n; i++){
            arrList.add(i);
        }
        dfs(0, 0);

    }

    private static void dfs(int idx, int cnt) {
        if(cnt == m){
            for(int i=0; i<arrList.size(); i++){
                if(isVisited[i]){
                    System.out.print(arrList.get(i) + " ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=idx; i<n; i++){
            if(isVisited[i]){
                continue;
            }
            isVisited[i] = true;
            dfs(i, cnt+1);
            isVisited[i] = false;
        }
    }
}
