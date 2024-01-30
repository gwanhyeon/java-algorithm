package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n;i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int top = 0;
            if(q.size() == 1){
                top = q.poll();
                System.out.print(top);
                break;
            }else {
                top = q.poll();
                System.out.print(top + " ");
                int nextTop = q.poll();
                q.add(nextTop);
            }
        }
    }
}
