package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_2755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Double> m = new HashMap<String,Double>(){
            {
                put("A+", 4.3);
                put("A0", 4.0);
                put("A-", 3.7);
                put("B+", 3.3);
                put("B0", 3.0);
                put("B-", 2.7);
                put("C+", 2.3);
                put("C0", 2.0);
                put("C-", 1.7);
                put("D+", 1.3);
                put("D0", 1.0);
                put("D-", 0.7);
                put("F", 0.0);
            }
        };
        StringTokenizer st;
        double answer = 0.0;
        int scoreNum = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String subj = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String scoreName = st.nextToken();
            scoreNum += score;
            answer += (score * m.get(scoreName));
        }
        System.out.println(String.format("%.2f", answer / scoreNum));
    }
}
