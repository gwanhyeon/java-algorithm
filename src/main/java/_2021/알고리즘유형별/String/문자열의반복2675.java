package _2021.알고리즘유형별.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열의반복2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int val = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            StringBuilder ans = new StringBuilder();

            for(int i=0; i<str.length(); i++){
                for(int j=0; j<val; j++){
                    ans.append(str.charAt(i));
                }
            }
            System.out.println(ans);

        }

    }

}
