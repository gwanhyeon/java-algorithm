package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 수열과조합 *
 * 수열은 뒤에값 확인 안한다.
 * 조합만 뒤애 값 확인한다.
 */
public class boj_15649 {
    static List<Integer> arrList;
    static boolean[] isVisited;
    static LinkedList<Integer> answer;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrList = new ArrayList<>();
        isVisited = new boolean[n];
        answer = new LinkedList<>();
        for(int i=1; i<=n; i++){
            arrList.add(i);
        }
        dfs(0);
    }

    private static void dfs(int cnt) {
        if(cnt == m){
            for(int i=0; i<answer.size(); i++){

                System.out.print(answer.get(i) + " ");

            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(isVisited[i]){
                continue;
            }
            isVisited[i] = true;
            answer.add(arrList.get(i));
            dfs(cnt+1);
            answer.removeLast();
            isVisited[i] = false;
        }

    }

}
