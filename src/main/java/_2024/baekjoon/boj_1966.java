package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            PriorityQueue<Print> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                int w = Integer.parseInt(st.nextToken());
                pq.add(new Print(i, w));
            }

            int cnt = 0;
            while(!pq.isEmpty()) {
                Print print = pq.poll();
                System.out.println(print.idx + " " + print.weight);
//                if(print.idx == target) {
//                    System.out.println(cnt);
//                    break; // 타겟 문서를 찾으면 반복문 종료
//                }
                cnt++;
            }
            System.out.println();
        }
    }

    private static class Print implements Comparable<Print> {
        int idx;
        int weight;

        public Print(){}
        public Print(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
        @Override
        public int compareTo(Print print) {
            if(print.weight == this.weight){
                return print.idx - this.idx;
            }else {
                return print.weight - this.weight;
            }
        }
    }
}
