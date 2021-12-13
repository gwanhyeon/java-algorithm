import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숏다리계단오르기 {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dfs(0,n);
        System.out.print(answer);


    }

    private static void dfs(int cnt, int n) {

        if(cnt == n){
            answer++;
            return;
        }

    }


}
