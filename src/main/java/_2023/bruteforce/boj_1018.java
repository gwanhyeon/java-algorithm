package _2023.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1018 {
    static int[][] map;
    static int min;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        min = Integer.MAX_VALUE;
        answer = 0;
        for(int i=0; i<n; i++){
            String color = br.readLine();
            for(int j=0; j<m; j++){
                if(color.charAt(j) == 'B'){
                    map[i][j] = 1;
                }else {
                    map[i][j] = 0;
                }
            }
        }
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                dfs(i,j);
            }
        }
        System.out.println(answer);
    }
    private static void dfs(int start, int end) {
        int blackCnt = 0;
        int whiteCnt = 0;

        for(int i=start; i<start+8; i++){
            for(int j=end; j<end+8; j++){
                if((i+j) % 2 == 0){
                    if(map[i][j] == 1){
                        whiteCnt++;
                    }else {
                        blackCnt++;
                    }
                }else {
                    if(map[i][j] == 1){
                        blackCnt++;
                    }else {
                        whiteCnt++;
                    }
                }
            }
        }
        min = min > blackCnt ? blackCnt : min;
        min = min > whiteCnt ? whiteCnt : min;
        answer = min;
    }
}
