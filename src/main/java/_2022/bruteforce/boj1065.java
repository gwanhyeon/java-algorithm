package _2022.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1065번 한수 - 브루트포스
 */
public class boj1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        if(n < 100){
            answer = n;
        }else {
            answer = 99;
            if(n == 1000){
                n = 999;
            }
            for(int i=100; i<=n; i++){
                int hundredNumber = i / 100;
                int tenNumber = (i / 10) % 10;
                int oneNumber = (i % 10);

                // 등차 수열 체크
                if((hundredNumber - tenNumber) == (tenNumber - oneNumber)){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
