import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물14719 {
    static int map[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[m];

        st = new StringTokenizer(br.readLine(), " ");

        int max_idx = 0;
        int min_idx = 0;
        int max_hight_idx = 0;
        for(int i=0; i<m; i++){
            int x = i;
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
            max_idx = Math.max(max_idx, x);
            min_idx = Math.min(min_idx, x);

            if(map[x] > map[max_hight_idx]){
                max_hight_idx = x;
            }
        }
        //3 12
        //0 1 0 2 1 0 1 3 2 1 2 1

        int left_sum = 0;
        int right_sum = 0;

        // left_sum
        int sum = 0;
        int h = 0;
        for(int i=min_idx; i<max_hight_idx; i++){
            left_sum += map[i];
            h = Math.max(map[i], h);
            sum += h;
        }

        // right_sum
        h = 0;
        for(int i=max_idx; i>max_hight_idx; i--){
            right_sum += map[i];
            h = Math.max(map[i], h);
            sum += h;
        }
        int answer = sum - (left_sum + right_sum);
        System.out.println(answer);
    }
}
