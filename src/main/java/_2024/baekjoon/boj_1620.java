package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1620 {
    public static void main(String[] args) throws IOException {
        System.out.println("11".matches("\\d+"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String,Integer> engNote = new HashMap<>();
        Map<Integer,String> idxNote = new HashMap<>();

        for(int i=1; i<=n; i++){
            String words = br.readLine();
            engNote.put(words, i);
            idxNote.put(i, words);
        }

        for(int i=1; i<=m; i++){
            String words = br.readLine();

            if(words.matches("\\d+")){
                int idx = Integer.parseInt(words);
                if(idxNote.containsKey(idx)){
                    System.out.println(idxNote.get(idx));
                }
            }else {
                if(engNote.containsKey(words)){
                    System.out.println(engNote.get(words));
                }
            }
        }
    }
}
