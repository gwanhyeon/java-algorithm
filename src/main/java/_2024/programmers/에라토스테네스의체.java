package _2024.programmers;

import java.util.Arrays;

public class 에라토스테네스의체 {
    public static void main(String[] args) {

        int n = 30;
        boolean[] isVisited = new boolean[n+1];

        Arrays.fill(isVisited, false);

        for(int i=2; i*i<=n; i++){
            // 자기자신을 방문하지 않았으면
            if(!isVisited[i]){
                for(int j=i*i; j<=n; j += i){
                    isVisited[j] = true;
                }
            }
        }

        for(int i=2; i<=n; i++){
            if(!isVisited[i]){
                System.out.print(i + " ");
            }
        }


    }
}
