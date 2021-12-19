package _2021.개인문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
자리수 찾기문제
1234567891011 와같이 수를 이어붙이면 브루트포스로 처리하면
 */
public class 수이어쓰기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        int len = 1;
        for(int i=1; i<=n; i*=10){
            int j = i*10-1;
            if(j > n){
                j = n;
            }
            ans += (long)(j - i + 1) * len;
            len++;
        }
        System.out.println(ans);
    }
}