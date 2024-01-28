package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1927 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> q = new PriorityQueue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int v = Integer.parseInt(br.readLine());

            if(v == 0){
                if(q.size() == 0){
                    System.out.println("0");
                }else {
                    System.out.println(q.peek());
                    q.poll();
                }
            }else {
                q.add(v);

            }

        }
    }
}
