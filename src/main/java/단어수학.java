import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어수학 {
    static boolean[] check;
    static int[] v;
    static int n;
    static HashSet<Character> hs;
    static Map<Character,Integer> m;
    static String[] words;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {

        check = new boolean[10];
        hs = new HashSet<>();
        m = new HashMap<>();
        v = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();
        words = new String[n];
        for(int i=0; i<n; i++){
            words[i] = br.readLine();
        }

        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                hs.add(words[i].charAt(j));
            }
        }

        dfs(0, hs.size());
        System.out.println(Collections.max(answer));
    }

    static void dfs(int cnt, int select_num) {

        if(cnt == select_num){
            Iterator<Character> iterator = hs.iterator();
            for(int i=0; i<10; i++){
                if(check[i]){
                    while(iterator.hasNext()){
                        char c = iterator.next();
                        m.put(c, i);
                    }
                }
            }
            int ans = 0;
            for(int i=0; i<words.length; i++){
                String value = "";
                for(int j=0; j<words[i].length(); j++){
                    if(m.containsKey(words[i].charAt(j))){
                        value += m.get(words[i].charAt(j));
                    }
                }
                ans += Integer.parseInt(value);
            }
            answer.add(ans);
            return;
        }

        for(int i=0; i<10; i++){
            if(check[i]){
                continue;
            }
            check[i] = true;
            dfs(cnt+1, select_num);
            check[i] = false;
        }
    }
}
