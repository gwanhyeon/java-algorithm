import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 동아리회장선거 {
    static int[] check;
    static ArrayList<String> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        check = new int[n];
        dfs(n,0, "");
        Collections.reverse(arr);
        arr.forEach(value ->{
            System.out.println(value);
        });

    }

    private static void dfs(int n, int cnt, String str) {

        if(n == cnt){
            arr.add(str);
            return;
        }
        dfs(n, cnt+1, str+"X");
        //System.out.println("dfs("+n+","+(cnt+1)+","+str+"X)");
        dfs(n, cnt+1, str+"O");
        //System.out.println("dfs("+n+","+(cnt+1)+","+str+"O)");
    }
}

/*


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class 동아리회장선거 {

    static int[] check;
    static int[] map;
    static HashSet<유형별.String> hs = new HashSet<>();
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(유형별.String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        check = new int[n*2];
        map = new int[n*2];
        for(int i=0; i<n; i++){
            map[i] = 0;
        }
        for(int i=n; i<n*2; i++){
            map[i] = 1;
        }
        dfs(n, 0,0);
        ArrayList<유형별.String> answer = new ArrayList(hs);
        Collections.sort(answer);

        answer.forEach(value ->{
            System.out.println(value);
        });



    }
    private static void dfs_tmp(int n,int idx,int cnt){

        if(n == cnt){

        }

    }

    private static void dfs(int n,int idx,int cnt) {
        if(n == cnt){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<arr.size(); i++){
                if(arr.get(i) == 0){
                    sb.append("X");
                }else {
                    sb.append("O");
                }

            }
            hs.add(sb.toString());
            return;
        }

        for(int i=idx; i<map.length; i++){
            if(check[i] == 1){
                continue;
            }
            check[i] = 1;
            arr.add(map[i]);
            dfs(n,idx,cnt+1);
            arr.remove(arr.size()-1);
            check[i] = 0;
        }
    }
}


 */
