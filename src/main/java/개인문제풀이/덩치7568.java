import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 덩치7568 {
    static int[] check;
    static int[] value_check;
    static int[] weight;
    static int[] stature;
    static int cnt = 1;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        weight= new int[n];
        stature = new int[n];
        check = new int[n];
        value_check = new int[n];
        answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            weight[i] = Integer.parseInt(st.nextToken());
            stature[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++){
            check[i] = 1;
            dfs(weight[i],stature[i],0,0,0, n);
            answer.add(cnt);
            cnt = 1;
            check[i] = 0;
        }

        for(int i=0; i<answer.size(); i++){
            if(i == answer.size()-1){
                System.out.print(answer.get(i));
                break;
            }
            System.out.println(answer.get(i));
        }
    }

    private static void dfs(int a, int b, int c, int d, int idx, int n) {
        if(idx == 1){
            if(c > a && d > b){
                cnt +=1;
            }
            return;
        }

        for(int i=idx; i<n; i++){
            if(check[i] == 1){
                continue;
            }
            if(value_check[i] == 1){
                continue;
            }
            value_check[i] = 1;
            dfs(a,b,weight[i],stature[i], idx+1 ,n);
            value_check[i] = 0;
        }

    }
}
