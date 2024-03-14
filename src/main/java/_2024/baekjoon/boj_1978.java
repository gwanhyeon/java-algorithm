package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isVisited = new boolean[n+1];
        isVisited[0] = isVisited[1] = true;
        for(int i=2; i*i<=n; i++){
            System.out.println(i + " ");
            if(!isVisited[i]){
                for(int j = i * i; j <= n; j += i){
                    isVisited[j] = true;
                }
            }
        }
        int answer = 0;
        for(int i=2; i<=n; i++){
            if(!isVisited[i]){
                answer++;
            }
        }
        System.out.println(answer);

    }
}
