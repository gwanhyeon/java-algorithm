package _2024.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class boj_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> arrList = new ArrayList<>();
        for(int i=1; i<=n; i++){
            int value = Integer.parseInt(br.readLine());
            arrList.add(value);
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        Collections.sort(arrList);
        while (end < n && start < n) {
            int comp = arrList.get(end)-arrList.get(start);
            if(comp >= m){
                sum -= arrList.get(start);
                start++;
            }else {
                sum += arrList.get(end);
                end++;
            }
            if(comp >= m){
                min = Math.min(min, comp);
            }
        }
        System.out.println(min);

    }
}
