package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            if(q.size() == 1){
                System.out.println(q.peek());
                break;
            }else {
                int top = q.poll();
                int nextTop = q.poll();
                q.add(nextTop);
            }
        }




    }
}
