package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isVisited = new boolean[1001];
        isVisited[0] = isVisited[1] = true;

        for(int i=2; i*i<=1000; i++){
            if(!isVisited[i]){
                for(int j=i*i; j<=1000; j += i){
                    isVisited[j] = true;
                }
            }
        }

        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            int target = Integer.parseInt(st.nextToken());
            if(isVisited[target] == false){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
