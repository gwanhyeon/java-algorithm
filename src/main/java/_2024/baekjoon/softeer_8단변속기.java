package _2024.baekjoon;
import java.io.*;
import java.util.*;

public class softeer_8단변속기 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String answer = "";
        int startNumber = 0;
        List<Integer> arrList = new ArrayList<>();
        while(st.hasMoreTokens()){
            arrList.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<arrList.size()-1; i++){
            int currNumber = arrList.get(i);
            int nextToken = arrList.get(i+1);

            if(i == 0){
                startNumber = currNumber;
            }
            if(Math.abs(nextToken - currNumber) != 1){
                answer = "mixed";
                startNumber = -1;
                break;
            }
        }
        if(startNumber == 1){
            answer = "ascending";
        }else if(startNumber == 8){
            answer = "descending";
        }
        System.out.println(answer);
    }
}

