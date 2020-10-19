import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class 체스판다시칠하기 {
    static int map[][];
    static int min = 80;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String val = st.nextToken();
            for(int j=0; j<m; j++){
                // black - 0
                if(val.charAt(j) == 'B'){
                   map[i][j] = 1;
                }
                // white - 1
                else {
                    map[i][j] = 0;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
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
