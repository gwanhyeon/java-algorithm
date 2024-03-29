package _2022.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * boj 7569 - 덩치 브루트포스
 */
public class boj7568 {
    static int[] pound;
    static int[] feet;
    static boolean[] isValidPerson;
    static boolean[] isValidPersonOrder;
    static StringTokenizer st;
    static int cnt;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pound = new int[n+1];
        feet = new int[n+1];
        answer = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pound[i] = x;
            feet[i] = y;
        }

        for(int i=0; i<n; i++){
            isValidPerson[i] = true;
            dfs(pound[i], feet[i], 0, 0, 0, n );
            answer.add(cnt);
            cnt = 1;
            isValidPerson[i] = false;
        }
    }
    private static void dfs(int a, int b, int c, int d, int idx, int n) {
        // 기준점 잡기
        if(idx == 1){
            if(c > a && d > b){
                cnt +=1;
            }
            return;
        }

        for(int i=0; i<n; i++){
            if(isValidPerson[i]){
                continue;
            }
            if(isValidPersonOrder[i]){
                continue;
            }
            isValidPersonOrder[i] = true;
            dfs(pound[i], feet[i], c,d,idx+1, n);
            isValidPersonOrder[i] = false;
        }
        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }
}
/*
public class boj7568 {
    static boolean[] isCheck;
    static boolean[] isCheckValue;
    static int[] weight;
    static int[] stature;
    static int cnt = 1;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        weight = new int[n];
        stature = new int[n];
        isCheck = new boolean[n];
        isCheckValue = new boolean[n];
        answer = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            weight[i] = Integer.parseInt(st.nextToken());
            stature[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            isCheck[i] = true;
            dfs(weight[i], stature[i], 0, 0, 0, n);
            answer.add(cnt);
            cnt = 1;
            isCheck[i] = false;
        }

        for(int i=0; i<answer.size(); i++){
            if(i == answer.size() -1){
                System.out.print(answer.get(i));
                break;
            }
            System.out.println(answer.get(i));
        }
    }

    private static void dfs(int a , int b, int c, int d, int idx, int n) {

        if(idx == 1){
            if(c > a && d > b){
                cnt +=1;
            }
            return;
        }
        for(int i=idx; i<n; i++){
            if(isCheck[i]) continue;
            if(isCheckValue[i]) continue;

            isCheckValue[i] = true;
            dfs(a,b,weight[i],stature[i], idx+1, n);
            isCheckValue[i] = false;
        }
    }
}

 */