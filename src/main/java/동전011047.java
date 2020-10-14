import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 동전011047 {
    public static void main(String[] args) throws IOException {

        int n,k = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] value = new int[n];
        for(int i=0; i<n; i++){
            value[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for(int i=value.length-1; i >= 0; i--){
            System.out.println(cnt);
            System.out.println(k);
            cnt += (k / value[i]);
            k = (k % value[i]);
        }
        System.out.println(cnt);
    }
}
