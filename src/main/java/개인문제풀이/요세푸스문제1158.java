import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> circle = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            q.add(i);
        }
        int idx = 1;
        while(!q.isEmpty()){
            if(idx == k){
                ans.add(q.poll());
                idx = 0;
            }else {
                q.add(q.poll());
            }
            idx++;
        }

        System.out.print("<");
        for(int i=0; i<ans.size(); i++){
            if(i == ans.size()-1){
                System.out.print(ans.get(i));
                System.out.print(">");
            }else {
                System.out.print(ans.get(i)+", ");
            }
        }
    }
}
