package _2022.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/***
 * boj 11650 좌표 정렬하기 *
 * https://www.acmicpc.net/problem/11650 *
 */
public class boj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 0;
        int y = 0;
        StringTokenizer st = null;
        List<Graph> arrList = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arrList.add(new Graph(x,y));
        }
        System.out.println();

    }
    static class Graph implements Comparator<Graph> {
        int x;
        int y;

        public Graph(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compare(Graph g1, Graph g2) {
            return g1.x - g2.x;
        }
    }
}
