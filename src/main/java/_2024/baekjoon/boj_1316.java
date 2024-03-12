package _2024.baekjoon;

import java.util.*;
import java.io.*;
public class boj_1316 {
    public static void main(String[] args) throws IOException{


        // 비교문자 변수
        // SET 선언

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        int answer = 0;
        while(t-- > 0){


            String words = br.readLine();
            Map<Character, Integer> m = new LinkedHashMap<>();
            boolean isGroup = false;

            // 모든 값 해시 처리
            Stack<Character> s = new Stack<>();
            // 짝지어진 것 제거
            for(int i=0; i<words.length(); i++){
                char c = words.charAt(i);
                if(!s.isEmpty() && s.peek() == c){
                    continue;
                }else {
                    s.push(c);
                    m.put(c, m.getOrDefault(c, 0) + 1);
                }
            }
            for(Character key : m.keySet()){
                if(m.get(key) > 1){
                    isGroup = true;
                    break;
                }
            }
            if(!isGroup){
               answer++;
            }
        }
        System.out.println(answer);

    }
}
