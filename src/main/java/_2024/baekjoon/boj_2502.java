package _2024.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_2502 {
    static int D;
    static int K;
    static int MAX = 1001;
    static boolean[] isVisited;
    static LinkedList<Integer> arrList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isVisited = new boolean[MAX];
        arrList = new LinkedList<>();
        // 1<= 6 <= 6
        dfs(1, 0, 1);
    }
    static void dfs(int idx, int sum, int cnt){
        if(sum == K && cnt == D){
            for (int i = 0; i < arrList.size(); i++) {
                System.out.print(arrList.get(i) + " ");
            }
            return;
        }

        //
        for(int i=1; i<1000; i++){
           if(isVisited[i]){
               continue;
           }
           isVisited[i] = true;
           arrList.add(i);
           sum += i;
           dfs(i, sum, cnt+1);
           arrList.removeLast();
           isVisited[i] = false;
        }

    }
}
