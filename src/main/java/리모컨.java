import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 리모컨 {
    static String ch;
    static int broken_number;
    static int[] broken_remote;
    static boolean[] check;
    static boolean[] broken_check;
    static int answer = 500001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ch = br.readLine();
        broken_number = Integer.parseInt(br.readLine());
        broken_remote = new int[broken_number];
        check = new boolean[10];
        broken_check = new boolean[10];
//        answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<broken_number; i++){
            broken_remote[i] = Integer.parseInt(st.nextToken());
            broken_check[broken_remote[i]] = true;
        }
        dfs("",0,0);
        System.out.print(answer);


    }

    private static void dfs(String str, int idx, int cnt) {
        if(Integer.parseInt(ch) - 100 == 0){
            answer = 0;
            return;
        }


        // 4 ==
        if(str.length() == ch.length() && str.length() > 0){

            String tmp = "";

             for(int i=0; i<str.length(); i++){
                 int ans = 0;
                 tmp += str.charAt(i);
                 ans = Math.abs(Integer.parseInt(ch) - Integer.parseInt(tmp));
                 ans = ans + cnt;
                 if(answer > ans){
                     answer = ans;
                 }
                 System.out.println(tmp);
             }


             return;
        }

        for(int i=0; i<10; i++){
            if(broken_check[i]){
                continue;
            }
            dfs(str+Integer.toString(i), i, cnt+1);
        }
    }

}
