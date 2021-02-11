import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * 1. n-8, m-8의 진행상황만큼 진행한다.
 * 2. seperate함수를 이용하여 진행한 횟수만큼 함수를 호출진행한다.
 * 3. x: start  ~ start+8 y: end ~ end+8 지점에 대한 경우의 수를 체크를 진행한다.
 * 4. black, white cnt값을 이용하여 (i + j) % == 0 흰색, 검정일경우에 대한 각각의 경우를 체크하여 cnt값을 증가시켜준다.
 * 5. blackCnt, whiteCnt의 값을 최솟값을 비교하여 해당 경우에따라 비교를 진행한다.
 * 6. 결과값을 도출한다.
 */

public class 체스판다시칠하기_완탐 {
    static int map[][];
    static int min = 80;
    public static void main(String[] args) throws IOException {


        // comment 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String val = st.nextToken();
            for(int j=0; j<m; j++){
                // comment black - 0
                if(val.charAt(j) == 'B'){
                   map[i][j] = 1;
                }
                // comment white - 1
                else {
                    map[i][j] = 0;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        // comment x,y의 진행회수 n-8, m-8, 8개의 사각형만 선택할 수 있으므로 n값이 10일경우 x 0,1,2 의 인덱스까지 진행이 가능하다.



        // comment 진행횟수만큼 값을 separate 함수에서 start, end 값으로 진행한다.
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                // first : black,first : white
                separate(i,j);
            }
        }
        System.out.println(min);
    }

    private static void separate(int start, int end) {
        int cntBlack = 0;
        int cntWhite = 0;
        for(int i=start; i<start+8; i++) {
            for (int j = end; j < end+8; j++) {

                // 짝수: white
                if((i+j) % 2 == 0){
                    if(map[i][j] == 1){
                        cntWhite++;
                    }else {
                        cntBlack++;
                    }
                }

                // 홀수: black
                else {
                    if(map[i][j] == 1){
                        cntBlack++;
                    }else {
                        cntWhite++;
                    }
                }
            }
        }
        min = min < cntBlack ? min : cntBlack;
        min = min < cntWhite ? min : cntWhite;

    }
}
