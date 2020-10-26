import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창고다각형2304 {
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[1001];

        // 인덱스 가장작은값, 큰값 구하고 기둥중에서 높이가 가장 큰 인덱스를 구한다.
        int max_idx = 0;
        int min_idx = 0;
        int max_hight_idx = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x] = y;
            max_idx = Math.max(max_idx, x);
            min_idx = Math.min(min_idx, x);

            if(map[x] > map[max_hight_idx]){
                max_hight_idx = x;
            }
        }

        // left -> max_hight_idx
        int sum = 0;
        int h = 0;
        for(int i=min_idx; i<max_hight_idx; i++){
            h = Math.max(h, map[i]);
            sum += h;
        }
        h = 0;
        // right -> max_hight_idx
        for(int i=max_idx; i>max_hight_idx; i--){
            h = Math.max(h, map[i]);
            sum += h;
        }
        int left_sum = 0;
        int right_sum = 0;
        for(int i=0; i<map.length; i++){
            if(i < max_hight_idx){
                left_sum += map[i];
            }
        }

        for(int i=map.length-1; i>=0; i--){
            if(i > max_hight_idx){
                right_sum += map[i];
            }
        }
        System.out.println(map[max_hight_idx] + sum);
        //System.out.println("left painting: "+ left_sum + " right painting : " + right_sum + " max painting :" + map[max_hight_idx]);
    }
}
