import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 블랙잭2798 {
    static int[] arr;
    static int[] check;
    static int n;
    static int m;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {



        //n개 중에서 3개를 고른다 조합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        check = new int[n];
        answer = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            check[i] = 0;
        }

        Arrays.sort(arr);
        // 조합
        dfs(0,0);

        Collections.sort(answer);

        System.out.print(answer.get(answer.size()-1));
    }

    private static void dfs(int idx,int sum) {

        // 카드 3장을 찾을 수 있는 Basement
        if(idx == 3){
            if(sum <= m) {
                answer.add(sum);
            }
            return;
        }

        for(int i=idx; i<n; i++){
            if(check[i] == 1){
                continue;
            }
            check[i] = 1;
            dfs(idx+1, sum+arr[i]);
            check[i] = 0;
        }
    }
}