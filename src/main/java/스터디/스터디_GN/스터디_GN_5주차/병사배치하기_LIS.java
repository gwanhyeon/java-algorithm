package 스터디.스터디_GN.스터디_GN_5주차;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 가장긴 감소하는 부분 수열
 * 내림차순으로 처리해야하므로 * 입력으로 주어진 원소의 순서를 뒤집은 뒤에 가장 긴증가하는 부분수열 점화식을 그대로 적용하면 해결이 가능하다.
 */
public class 병사배치하기_LIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /*
        7
        15 11 4 8 5 2 4
         */
        List<Integer> arr = new ArrayList<>();
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
            dp[i] = 1;
        }
        Collections.reverse(arr);

        int answer = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr.get(i) > arr.get(j)){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            if(answer < dp[i]){
                answer = dp[i];
            }
        }

        System.out.println(n - answer);     // 총 병사수 - 최대 가장 증가하는 부분수열의 개수(최대병사의 수) = 열외되어야할 병사수
    }
}
