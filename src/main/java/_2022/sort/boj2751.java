package _2022.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        List<Integer> arrList = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arrList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arrList);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arrList.size(); i++){
            sb.append(arrList.get(i) + "\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
