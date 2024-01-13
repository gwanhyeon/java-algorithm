package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=Integer.parseInt(s); i++){
            sb.append(i);
        }
        String answer = "";
        String target = s;
        int targetLen = target.length();
        int searchLen = sb.toString().length();

        for(int i=0; i<=searchLen; i++){
            answer = sb.substring(i, targetLen+i);
            if(s.equals(answer)){
                System.out.println(i+1);
                break;
            }
        }
    }
}


// 1234567891 01112 131415
