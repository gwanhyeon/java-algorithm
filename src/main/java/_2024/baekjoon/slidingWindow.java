package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class slidingWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> arrList = new ArrayList<>();
        //3 -2 -4 -9 0 3 7 13 8 -3

        while(st.hasMoreTokens()){
            arrList.add(Integer.valueOf(st.nextToken()));
        }

        int sum = 0;
        int max = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            sum += arrList.get(i);

            if(i == k-1){
                max = sum;
            }

            if(i >= k){
                sum -= arrList.get(i-k);
                max = Math.max(max,sum);
            }

        }
        System.out.println(max);



    }
}
