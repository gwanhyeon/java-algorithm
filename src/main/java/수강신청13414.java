import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class 수강신청13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<String> hs = new LinkedHashSet<>();
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());


        for(int i=0; i<l; i++){
            String value = br.readLine();
            if(hs.contains(value)){
                hs.remove(value);
                hs.add(value);
            }else {
                hs.add(value);
            }

        }

        int idx = 0;
        for(String s : hs){
            if(idx < k){
                System.out.println(s);
            }
            idx++;
        }

    }
}
