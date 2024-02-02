package _2024.baekjoon;

import java.io.*;
import java.util.*;

public class boj_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Set<Integer> note1;
        Set<Integer> note2 = new HashSet<>();
        int n,m = 0;
        while(t-- > 0){
            note1 = new HashSet<>();
            sb = new StringBuilder();
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<n; i++){
                int v = Integer.parseInt(st.nextToken());
                note1.add(v);
            }

            m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<m; i++){
                int v = Integer.parseInt(st.nextToken());
                if(!note1.isEmpty() && note1.contains(v)){
                    sb.append("1\n");
                }else {
                    sb.append("0\n");
                }
            }
            bw.write(sb.toString());
            note1.clear();
            bw.close();


        }
    }
}
