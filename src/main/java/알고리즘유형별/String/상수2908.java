package 알고리즘유형별.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상수2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String n = st.nextToken();
        String m = st.nextToken();
        n = reverseStr(n);
        m = reverseStr(m);

        int a = Integer.parseInt(n);
        int b = Integer.parseInt(m);
        if(a > b){
            System.out.println(a);
        }else {
            System.out.println(b);
        }
    }
    static String reverseStr(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
}
