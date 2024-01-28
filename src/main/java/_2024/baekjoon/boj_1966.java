package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 */
public class boj_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Docs> q = new PriorityQueue<>();
        while(t-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 모든 문서 탐색
            st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<N; i++){
                // 가중치 INSERT
                q.add(new Docs(i, Integer.parseInt(st.nextToken())));
            }
            int answer = 1;
            while(!q.isEmpty()) {
                Docs d = q.poll();
//                System.out.println(d.idx + " " + d.weight);
                // 찾고자하는 인덱스
                if(d.idx == M){
                    System.out.println(answer);
                    break;
                }else {
                    answer++;
                }
            }
            q.clear();
        }
    }

    private static class Docs implements Comparable<Docs> {
        int idx;
        int weight;

        public Docs(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Docs o) {

            // 가중치가 같은 경우

            if(o.weight != this.weight){
                // 인덱스가 낮은 내림차순
                return o.weight - this.weight;
            }else {
                return o.idx - this.idx;
            }
        }
    }
}

// 9 1 1 1 1 1
/*
1
6 0
1 1 9 1 1 1
 */
