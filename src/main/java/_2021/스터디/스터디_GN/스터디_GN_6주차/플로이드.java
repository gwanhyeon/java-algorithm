package _2021.스터디.스터디_GN.스터디_GN_6주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/** 시작도시 A와 도착도시 B를 연결하는 간선이 여러개일 수 있다는점이 있다. 반드시 입력시 더 작은값으로 처리한다. 이때 비용은 1
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
 */
public class 플로이드 {
    static int[][] arr;
    static int INF = 100 * 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[101][101];

        for(int i=0; i<101; i++){
            Arrays.fill(arr[i], INF);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j){
                    arr[i][j] = 0;
                }
            }
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            int w= Integer.parseInt(st.nextToken());
            // 동일한 간선이 있을 수 있으니까 반드시 체크해주어야한다. 3,4,1 <-> 3,4,2
            if(w < arr[x][y]){
                arr[x][y] = w;
            }
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i][j] == INF){
                    System.out.print("0 ");
                }else {
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }

    }
}
