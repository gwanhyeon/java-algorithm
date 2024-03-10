package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 슬라이딩 윈도우
public class boj_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> arrList = new ArrayList<>();
        while(st.hasMoreTokens()){
            arrList.add(Integer.parseInt(st.nextToken()));
        }

        int max = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arrList.get(i);

            // 최대값으로 잡는다 마지막값을
            if(i == m-1){
                max = sum;
            }
            // 범위를 벗어나면 한칸씩 밀어주면서 비교(이때, 슬라이딩 윈도우의 형태인 맨 앞의 값을 제거 해준다)
            if(i >= m){
                sum -= arrList.get(i-m);
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);

    }
}
