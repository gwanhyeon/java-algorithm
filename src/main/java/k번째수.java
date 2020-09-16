import java.util.ArrayList;
import java.util.Collections;

public class k번째수 {
    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<commands.length; i++){
            int copy[] = array.clone();
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];

            for(int j=start-1; j<end; j++){
                ans.add(copy[j]);
            }
            Collections.sort(ans);

            for(int m=0; m<ans.size(); m++){

                if(m == k-1){
                    System.out.println(ans.get(k-1));
                }
            }
            ans.clear();
        }
    }
}
