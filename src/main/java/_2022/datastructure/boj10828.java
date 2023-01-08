package _2022.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            int num = 0;
            if("push".equals(cmd)){
                num = Integer.parseInt(st.nextToken());
            }


            if("push".equals(cmd)){
                s.push(num);
            }else if("pop".equals(cmd)){
                if(s.size() == 0){
                    System.out.println(-1);
                }else {
                    System.out.println(s.peek());
                    s.pop();
                }
            }else if("size".equals(cmd)){
                System.out.println(s.size());
            }else if("empty".equals(cmd)){
                if(s.empty()){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }else if("top".equals(cmd)){
                if(s.size() == 0){
                    System.out.println(-1);
                }else {
                    System.out.println(s.peek());
                }
            }
        }
    }
}
