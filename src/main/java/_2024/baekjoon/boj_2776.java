package _2024.baekjoon;

import javax.swing.plaf.basic.BasicBorders;
import java.io.*;
import java.util.*;

public class boj_2776 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        Set<Integer> s;

        StringTokenizer st;
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            s = new HashSet<>();
            st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<n; i++){
                int v = Integer.parseInt(st.nextToken());
                s.add(v);
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<m; i++){
                int v2 = Integer.parseInt(st.nextToken());
                if(s.contains(v2)){
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            }

        }
        bw.flush();
        bw.close();



    }
}

/*
1
1
0
2
1 1
 */
