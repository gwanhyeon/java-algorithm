package _2022.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
boj 15652 nm series 4 - 중복조합
 */
public class boj15652 {
    static LinkedList<Integer> combinations;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        combinations = new LinkedList<>();
        dfs(n, m, 1, 0);
    }

    private static void dfs(int n, int m, int idx, int cnt) {
        if(cnt == m){
            for (int i = 0; i < combinations.size(); i++) {
                System.out.print(combinations.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i=idx; i<=n; i++){
            combinations.add(i);
            dfs(n, m, i, cnt+1);
            combinations.removeLast();
        }
    }

}
