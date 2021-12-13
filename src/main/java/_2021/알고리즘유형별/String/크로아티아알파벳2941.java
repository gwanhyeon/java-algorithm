package _2021.알고리즘유형별.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아알파벳2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] s = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(int i=0; i<s.length; i++){
            str = str.replace(s[i], "n");
        }
        System.out.println(str.length());
    }


}
/* 메모리 초과 다시 풀것
public class 크로아티아알파벳2941 {
    static HashSet<유형별.String> s;
    static int ans = 0;
    static int[] check;
    public static void main(유형별.String[] args) throws IOException {
        s = new HashSet<>();
        s.add("c="); s.add("c-");
        s.add("dz="); s.add("d-");
        s.add("lj"); s.add("nj");
        s.add("s="); s.add("z=");
//        s.add("e"); s.add("a");
//        s.add("k");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        유형별.String str = br.readLine();
        check = new int[101];
        dfs(str, "", 0);

        System.out.println(ans);
    }

    private static void dfs(유형별.String str,유형별.String tmp, int cnt) {

        if(cnt > str.length()-1){
            return;
        }
        if(s.contains(tmp)){
            ans++;
            return;
        }

        check[cnt] = 1;
        dfs(str, tmp+str.charAt(cnt), cnt+1);
        dfs(str, tmp, cnt+1);
        check[cnt] = 0;


    }
}
*/