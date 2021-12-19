package _2021.개인문제풀이;/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 반복수열2331 {

    static int[] check;
    static ArrayList<ArrayList<Integer>> 유형별.Graph.AdjList = new ArrayList<>();
    public static void main(유형별.String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        유형별.String A = "";
        int P = 0;
        for(int i=0; i<=1000000; i++){
            유형별.Graph.AdjList.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = 유형별.String.valueOf(Integer.parseInt(st.nextToken()));
        P = Integer.parseInt(st.nextToken());
        check = new int[1000000];
        dfs(A, P);

        int answer = 0;
        for(int i=0; i<check.length; i++){
            if(check[i] == 1){
                answer++;
            }
        }
        System.out.println(answer-1);
    }
    private static void dfs(유형별.String A, int P) {
        int sum = 0;
        int x = A.charAt(0)-'0';

        for(int i=1; i<A.length(); i++){
            int y = A.charAt(i)-'0';
            sum += 유형별.Math.pow(A.charAt(i)-'0', P);
            유형별.Graph.AdjList.get(x).add(y);
            유형별.Graph.AdjList.get(y).add(x);
        }
        if(check[x] == 0){
            check[x] = 1;
        }else{
            check[x] = check[x] + 1;
        }

        for(int i=0; i<유형별.Graph.AdjList.get(x).size(); i++){
            int y = 유형별.Graph.AdjList.get(x).get(i);

            if(check[y] == 0) {
                check[y] = 1;
                dfs(Integer.toString(sum), P);
            }
        }
    }
}
*/

import java.util.*;
public class 반복수열2331 {
    public static int[] check = new int[1000000];
    public static int getNextNumber(int a, int p) {
        int ans = 0;
        while (a > 0) {
            ans += Math.pow(a%10, p);
            a /= 10;
        }
        return ans;
    }
    public static int dfs(int a, int p, int cnt) {
        // 예: check[37]은 이미 할당되어있는 값이므로 중복되는 시점이다. 따라서 현재 값이 할당된 cnt값의 -1은 중복되지 않은 값의 개수를 알 수 있다.
        if (check[a] != 0) {
            return check[a]-1;
        }
        check[a] = cnt;
        int b = getNextNumber(a, p);
        return dfs(b, p, cnt+1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(dfs(a, p, 1));
    }
}


/*
D[1] = A
D[n] = D[n-1]

A = 57 P = 2


5^2 + 7^2 = 25+49 = 74
49 + 16  = 65
36 + 25 = 61
36 + 1 = 37
9 + 49 = 58
25 + 64 = 89
 */

