import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 국회의원선거1417_코테기출_202012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());


        int[] vote = new int[n-1];
        for(int i=0; i<vote.length; i++){
            vote[i] = Integer.parseInt(br.readLine());
        }

        // comment 자기자신인 경우
        if(n == 1){
            System.out.println("0");
            return;
        }
        // comment 다솜이의 taget 값
        int ans = 0;


        // comment 값을 sort하면서 맨 마지막에 있는 가장 큰값이랑 현재 다솜이의 값과 비교하여 값이 더 크면 해당 다솜이의 득표수와 ans값을 ++해주고 현재 선택된 투표의 값을 감소시킵니다.
        // comment tf == true인 경우는 다솜보다 큰 값이 없다는 의미이므로 해당 로직을 빠져나오게됩니다.
        while(true){
            Arrays.sort(vote);
            boolean tf = true;
            int size = vote.length-1;
            if(target <= vote[size]){
                target++;           // 다솜 득표
                vote[size]--;       // 득표 감소
                tf = false;
                ans++;
            }
            if(tf){
                break;
            }
        }
        System.out.println(ans);
    }
}
