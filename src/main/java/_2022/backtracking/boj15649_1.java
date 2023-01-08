package _2022.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj15649_1 {
    static int n;
    static int m;
    static boolean[] isVaild;
    static LinkedList<Integer> arrList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arrList = new LinkedList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVaild = new boolean[n+1];
        recursive(0);
    }
    private static void recursive(int cnt) {
        if(cnt == m){
            for(int i=0; i<arrList.size(); i++){
                System.out.print(arrList.get(i));
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=n; i++){
            if(!isVaild[i]){
                arrList.add(i);
                isVaild[i] = true;
                recursive(cnt+1);
                isVaild[i] = false;
                arrList.pollLast();
            }
        }
    }
}
