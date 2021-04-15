import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 부등호문제 {
    static boolean[] check;
    static ArrayList<String> answer;
    static String inequality_sign = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        check = new boolean[10];
        answer = new ArrayList<>();


        for(int i=0; i<k; i++){
            inequality_sign += st.nextToken();
        }

        dfs("", 0, k);
        Collections.sort(answer);

        System.out.println(answer.get(answer.size()-1) + "\n" + answer.get(0) + "\n");

    }

    private static void dfs(String s, int idx, int k) {

        if(idx == k+1){
            answer.add(s);
            return;
        }

        for(int i=0; i<10; i++){
            if(check[i]){
                continue;
            }
            //System.out.println(i+'0');
            if(idx == 0 || inequality_check(s.charAt(idx-1), (i+'0'), inequality_sign.charAt(idx-1))){
                check[i] = true;
                dfs(s+i, idx+1, k);
                check[i] = false;
            }
        }
    }

    private static boolean inequality_check(int a, int b,char cal) {
        System.out.println("a"+a +"b"+b);
        if(cal == '<'){
            if(a > b){
                return false;
            }
        }

        if(cal == '>'){
            if(a < b){
                return false;
            }
        }
        return true;
    }
}

/* 풀이 방식 2: 올바른 결과값이 안나오는데 이유를 모르겠음 */
/*
    public class 부등호문제 {
    static boolean[] check;
    static ArrayList<유형별.String> answer;
    static int[] v;
    public static void main(유형별.String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        check = new boolean[10];
        StringBuilder inequality_sign = new StringBuilder();
        answer = new ArrayList<>();
        v = new int[k+1];

        for(int i=0; i<k; i++){
            inequality_sign.append(st.nextToken());
        }

        dfs(inequality_sign, "",0, k);

        for (유형별.String v : answer) {
            System.out.println(v);

        }

//        System.out.println(Collections.max(answer) + "" + Collections.min(answer));
    }

    private static void dfs(StringBuilder inequality_sign,유형별.String comp, int cnt, int k) {

        if(cnt == k+1){
            answer.add(유형별.String.valueOf(comp));


        }

        int tmp = -1;   // 처음나온 문자인지 아닌지 확인
        for(int i=0; i<10; i++){

            int sign = 0;   // 부호끼리 사인이 맞는지 확인
            StringBuilder str = new StringBuilder();
            if(check[i]){
                if(tmp == -1){
                    tmp = i;
                    str.append(유형별.String.valueOf(i));
                    continue;
                }

                if(inequality_sign.charAt(sign) == '<'){
                    if(tmp < i){
                        tmp = i;
                        sign++;
                        str.append(유형별.String.valueOf(i));
                    }
                }else {
                    if(tmp > i){
                        tmp = i;
                        sign++;
                        str.append(유형별.String.valueOf(i));
                    }
                }
            }
            check[i] = true;
            if(sign == k){
                dfs(inequality_sign, 유형별.String.valueOf(str),cnt+1, k);
            }

            check[i] = false;
        }

    }
}

 */
