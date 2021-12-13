package _2021.스터디.스터디_SNU.Section02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_새로운게임_kgh {
    static int[][] map;
    static int[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[12][12];
        check = new int[12][12];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            check[x-1][y-1] = dir;

        }


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                System.out.print(check[i][j]);
            }
            System.out.println();
        }
        // 턴 시작
        while(true){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){

                }
            }
        }




    }
}

