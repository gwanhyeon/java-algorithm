package _2024.baekjoon;
import java.io.*;
import java.util.*;
public class softeer_전광판 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Map<Character, String> m = new HashMap<>();
        m.put('0',"1110111");
        m.put('1',"0010010");
        m.put('2',"1011101");
        m.put('3',"1011011");
        m.put('4',"0111010");
        m.put('5',"1101011");
        m.put('6',"1101111");
        m.put('7',"1110010");
        m.put('8',"1111111");
        m.put('9',"1111011");
        m.put(' ',"0000000");

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String prevWords = st.nextToken();
            prevWords = prevWords.format("%5s",prevWords);
            String nextWords = st.nextToken();
            nextWords = nextWords.format("%5s",nextWords);

            char[] prevWord = prevWords.toCharArray();
            char[] nextWord = nextWords.toCharArray();
            int answer = 0;
            for(int i=0; i<5; i++){
                String diff_A = m.get(prevWord[i]);
                String diff_B = m.get(nextWord[i]);
                for(int j=0; j<diff_A.length(); j++){
                    if(diff_A.charAt(j) != diff_B.charAt(j)){
                        answer++;
                    }
                }

            }
            System.out.println(answer);
        }
    }
}
