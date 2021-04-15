import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 단어의개수1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<String,Integer> hs = new HashMap<String,Integer>();

        while(st.hasMoreTokens()){

            String str = st.nextToken();

            if(!hs.containsKey(str)){
                hs.put(str, 1);
            }else {
                int val = hs.get(str);
                hs.put(str, val+1);
            }
        }

        int[] sum = {0};
        hs.forEach((key,value)->{
            sum[0] += value;
        });
        System.out.println(sum[0]);




    }
}
