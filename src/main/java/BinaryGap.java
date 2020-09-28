import java.util.ArrayList;
import java.util.Collections;

public class BinaryGap {
    public static void main(String[] args) {
        int N = 9;

        ArrayList<Integer> arr = new ArrayList<>();

        while(N > 0){
            int div = N % 2;
            arr.add(div);
            N = N / 2;
        }

        Collections.reverse(arr);
        String answer = "";
        for (Integer integer : arr) {
            System.out.print(integer);
            answer += Integer.toString(integer);
        }
        System.out.println("answer=>" + answer);

        int cnt = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<answer.length(); i++){
            if(answer.charAt(i) == '1'){
                ans.add(cnt);
                cnt = 0;
            }else {
                cnt++;
            }
        }

        Integer ret = Collections.max(ans);
        System.out.println(ret);






    }
}
