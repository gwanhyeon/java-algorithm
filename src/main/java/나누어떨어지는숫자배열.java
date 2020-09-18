import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 나누어떨어지는숫자배열 {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                answer.add(arr[i]);
            }
        }
        int i =0;
        Collections.sort(answer);
        for(Integer t : answer){
            System.out.println(t);
        }

        if(answer.size() == 0){
            answer.add(-1);
        }


    }
}
