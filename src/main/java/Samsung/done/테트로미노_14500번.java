package Samsung.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //==입력==//
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        //==테트로미노 경우의수 찾기==//
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                /** 1
                ㅡ ㅡ ㅡ ㅡ
                 */
                if(j+3 < m){
                    answer = Math.max(answer, map[i][j]+map[i][j+1]+map[i][j+2]+map[i][j+3]);
                }

                /** 2
                |
                |
                |
                |
                 */
                if(i+3 < n){
                    answer = Math.max(answer, map[i][j]+map[i+1][j]+map[i+2][j]+map[i+3][j]);
                }

                /** 3
                ㅡ ㅡ
                ㅡ ㅡ
                 */
                if(i+1 < n && j+1 < m){
                    answer = Math.max(answer, map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1]);
                }

                /** 4
                |
                |
                ㅡ ㅡ
                 */

                if(2+i < n && j+1 < m){
                    answer = Math.max(answer, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1]);
                }

                /** 5
                ㅡ ㅡ ㅡ
                ㅡ
                 */

                if(i+1 < n && 2+j < m){
                    answer = Math.max(answer, map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j]);
                }
                /** 6
                   |
                   |
                ㅡ ㅡ
                 */
                if(2+i < n && j+1 < m){
                    answer = Math.max(answer, map[i][j+1] + map[i+1][j+1] + map[i+2][j] + map[i+2][j+1]);
                }
                /** 7
                ㅡ ㅡ
                ㅡ
                ㅡ
                 */

                if(2+i < n && j+1 < m){
                    answer = Math.max(answer, map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j]);
                }


                /** 8
                ㅡ
                ㅡ ㅡ ㅡ
                 */
                if(i+1 < n && j+2 < m){
                    answer = Math.max(answer, map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2]);
                }
                /** 9
                ㅡ ㅡ
                   |
                   |
                 */
                if(i+2 < n && j+1 < m){
                    answer = Math.max(answer, map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1]);
                }

                /** 10
                   ㅡ ㅡ
                ㅡ ㅡ
                 */

                if(i+1 < n && j+2 < m) {
                    answer = Math.max(answer, map[i][j + 1] + map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1]);
                }
                /** 11
                ㅡ
                ㅡ ㅡ
                   ㅡ
                 */
                if(i+2 < n && j+1<m){
                    answer = Math.max(answer, map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+2][j+1]);
                }
                /** 12
                    ㅡ
                 ㅡ ㅡ
                 ㅡ
                 */
                if(i+2 < n && j+1<m){
                    answer = Math.max(answer, map[i][j+1]+map[i+1][j]+map[i+1][j+1]+map[i+2][j]);
                }
                /** 13
                ㅡ ㅡ
                   ㅡ ㅡ
                 */
                if(i+1<n && j+2<m){
                    answer = Math.max(answer , map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i+1][j+2]);
                }
                /** 14
                   |
                ㅡ ㅡ ㅡ
                 */
                if(i+1 < n && j+2 < m){
                    answer = Math.max(answer, map[i][j+1]+map[i+1][j]+map[i+1][j+1]+map[i+1][j+2]);
                }
                /** 15
                |
                | ㅡ
                |
                 */

                if(i+2<n && j+1<m){
                    answer = Math.max(answer, map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+2][j]);
                }

                /** 16
                ㅡ ㅡ ㅡ
                   |
                 */
                if(i+1 < n && j+2 < m){
                    answer = Math.max(answer, map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+1]);
                }
                /** 17
                   |
                 ㅡ |
                   |
                 */

                if(i+2<n && j+1<m){
                    answer = Math.max(answer,map[i][j+1]+map[i+1][j]+map[i+1][j+1]+map[i+2][j+1]);
                }

                /** 18
                 * ㅡ ㅡ ㅡ
                 *      |
                 */

                if(i+1 < n && j+2 < m){
                    answer = Math.max(answer, map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+2]);
                }
                /** 19
                 *      |
                 * ㅡ ㅡ ㅡ
                 */
                if(i+1 < n && j+2 < m){
                    answer = Math.max(answer, map[i][j+2]+map[i+1][j]+map[i+1][j+1]+map[i+1][j+2]);
                }
            }
        }
        System.out.println(answer);
   }
}
