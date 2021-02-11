import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** comment 로직
 * 1 최대, 최소 높이의 인덱스값과 가장 높은 인덱스의 값을 따로 구해놓는다.
 * 2. 0~max_hight_idx 왼쪽에서 오른쪽으로 이동하면서 최대값을 가지고 있는 인덱스값을 현재 map에 있는 값과 비교하여 최댓값을 sum에 더해나간다.
 * 3. max_idx ~ max_hight_idx 오른쪽에서 왼쪽으로 이동하면서 최댓값을 가지고 있는 인덱스 값을 현재 map[i]에 있는 값과 비교하여 최댓값을 sum에 더해나간다.
 * 4. 최종적으로 가장 큰 높이를 가진 인덱스가 가지고 있는 값과 현재 왼쪽~hight_max, 오른쪽~hight_max를 진행하면서 더해온 값을 더하면 최종 창고의 최댓값을 구해나간다.
 *
 * comment 재풀이시간 10분
 */

public class 창고다각형2304_완탐 {

    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        map = new int[1001];
        StringTokenizer st;
        int max_idx = 0;
        int min_idx = 0;
        int middle_idx = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine() , " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x] = y;

            if(x > max_idx){
                max_idx = x;
            }
            if(x < min_idx){
                min_idx = x;
            }
            if(map[x] > map[middle_idx]){
                middle_idx = x;
            }
        }


        // 왼 -> 오
        int h = 0;
        int sum = 0;
        for(int i=min_idx; i<middle_idx; i++){
            if(h < map[i]){
                h = map[i];
            }
            sum += h;
        }

        h = 0;
        // 오 -> 왼
        for(int i=max_idx; i>middle_idx; i--){
            if(h < map[i]){
                h = map[i];
            }
            sum += h;
        }
        sum += map[middle_idx];
        answer = sum;
        System.out.println(answer);


    }


}



/*
public class 창고다각형2304_완탐 {
    static int[] map;

    public static void main(유형별.String[] args) throws IOException {
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
            max_idx = 유형별.Math.max(max_idx, x);
            min_idx = 유형별.Math.min(min_idx, x);

            if(map[x] > map[max_hight_idx]){
                max_hight_idx = x;
            }
        }

        // left -> max_hight_idx
        int sum = 0;
        int h = 0;
        for(int i=min_idx; i<max_hight_idx; i++){
            h = 유형별.Math.max(h, map[i]);
            sum += h;
        }
        h = 0;
        // right -> max_hight_idx
        for(int i=max_idx; i>max_hight_idx; i--){
            h = 유형별.Math.max(h, map[i]);
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
*/