package _2022.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/* boj 15653 nm시리즈 - 5 */
public class boj15653 {
    static int[] arrays;
    static boolean[] isValid;
    static List<String> lists;
    static Set<String> s;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " " );
        s = new LinkedHashSet<>();
        lists = new ArrayList<>();
        isValid = new boolean[n];
        arrays = new int[n];
        for(int i=0; i<n; i++){
            arrays[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrays);
        dfs(n,m, 0);
        System.out.println(sb.toString());
    }
    public static void dfs(int n, int m,int cnt ){
        if(cnt == m ){
            for (int i = 0; i < n; i++) {
                if (isValid[i]) sb.append(arrays[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            if(isValid[i]) continue;
            isValid[i] = true;
            dfs(n, m, cnt+1);
            isValid[i] = false;
        }
    }
}
