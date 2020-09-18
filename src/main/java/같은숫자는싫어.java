import java.util.ArrayList;
import java.util.Arrays;

public class 같은숫자는싫어 {
    /*
    public static void main(String[] args) {

        int[] arr = {1,1,3,3,0,1,1};

        ArrayList<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);


        for(int i=1; i <arr.length; i++){
            if(arr[i-1] != arr[i]){
                answer.add(arr[i]);
            }
        }


        for(Integer a : answer){
            System.out.println(a);
        }
    }
    */



    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        //int[] answer = {};
        ArrayList<Integer> answer = new ArrayList<>();
        int curr = -1;
        Boolean check = false;
        int cnt = 0;
        //answer = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++){

                if (arr[i] == arr[j] && j != arr.length-1) {
                    continue;
                } else {
                    answer.add(arr[i]);
                    //answer[cnt] = arr[i];
                    i = j;
                    cnt++;

                }
            }

        }
    }

}
