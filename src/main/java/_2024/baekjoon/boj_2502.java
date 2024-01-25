package _2024.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
넘어온날 즉, 몇개를 선택할지 D
호랑이에게 준 떡의 개수 K 합계


넘어온날 3
떡 개수 10

day1 1 2 3
day2 9 8 7
day3 10 10 10
D-1개를 선택한 중복 조합
 */
public class boj_2502 {
    static int D;
    static int K;
    static int MAX;
    static boolean[] isVisited;
    static LinkedList<Integer> arrList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arrList = new LinkedList<>();
        MAX = K / D;
        isVisited = new boolean[MAX];
        for(int i=1; i<=MAX; i++){
            arrList.add(i);
        }
        dfs(0, 0);
    }
    static void dfs(int idx, int cnt){
        if(cnt == D-1){
            int answer = 0;
            int selected = 0;
            int dayOne = 0;
            int dayTwo = 0;
            for (int i = 0; i < arrList.size(); i++) {
                if(isVisited[i]){
                    if(selected == 0){
                        dayOne = arrList.get(i);
                    }else if(selected == 1){
                        dayTwo = arrList.get(i);
                    }
                    answer += arrList.get(i);
                }
                selected++;
            }
            System.out.println(answer + " " + K);
            if(answer == K){
                System.out.println(dayOne + " "+ dayTwo);
            }
            return;
        }

        //
        for(int i=idx; i<arrList.size(); i++){
           isVisited[i] = true;
           dfs(i, cnt+1);
           isVisited[i] = false;
        }

    }
}
