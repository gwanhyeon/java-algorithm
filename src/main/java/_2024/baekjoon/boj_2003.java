package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrList.add(Integer.parseInt(st.nextToken()));
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;

        while(true){
            // 1. 현재 sum 값이 타겟 값보다 크면, sum값을 현재값에서 빼주고, start 시작점을 늘려준다.
            if(sum >= m ){
                sum -= arrList.get(start);
                start++;
            }else if(end == n){
                break;
            }
            // 2. 더한값이 m보다 작으면
            else {
                sum += arrList.get(end);
                end++;
            }

            // 3. 그게 아니라면 sum 값을 끝에 있는값을 더해주고, end 인덱스 값을 늘려준다
            if(sum == m){
                cnt++;
            }
        }
        System.out.println(cnt);




    }
}
