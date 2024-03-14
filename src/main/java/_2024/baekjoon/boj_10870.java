package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++){
            if(i == n) {
                System.out.println(fibo(i));
            }
        }
    }

    private static int fibo(int n) {
        if(n<=1){
            return n;
        }
        return fibo(n-2) + fibo(n-1);
    }
}
