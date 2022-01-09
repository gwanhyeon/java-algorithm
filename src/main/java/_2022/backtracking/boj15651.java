package _2022.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
boj 15651 n과 m(3)
 */
public class boj15651 {
    static LinkedList<Integer> combinations;
    static List<String> answer;
    static boolean[] isValid;
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int m;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        combinations = new LinkedList<>();
        answer = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isValid = new boolean[n+1];
        sb = new StringBuilder();
        dfs(n, m, 0);
        System.out.println(sb.toString());
        br.close();
    }
    static public void dfs(int n, int m, int idx){

        if(idx == m){

            for(int i=0; i<combinations.size(); i++){
                sb.append(combinations.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            combinations.add(i);
            dfs(n, m, idx+1);
            combinations.removeLast();

        }

    }
}
