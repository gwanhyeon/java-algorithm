package 스터디.스터디_GN.스터디_GN_5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
            dp[i] = 1;
        }
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr.get(i) > arr.get(j)){
                    dp[i] = Math.max(dp[i], dp[j]+1);           // 하나더 늘어났을때 최댓값
                }
            }
            if(answer < dp[i]){
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }

}
