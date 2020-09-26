import java.util.HashMap;
import java.util.HashSet;

public class 위장 {
    public static void main(String[] args) {
        HashMap<String,Integer> hs = new HashMap<>();

        String[][] clothes = {{"yellow_hat", "headgear"}, {"zzblue_sunglasses","eyewear"}, {"green_turban","headgear"}};

        for(int i=0; i<clothes.length; i++){
            if(!hs.containsKey(clothes[i][1])){
                hs.put(clothes[i][1], 1);
            }else {
                int tmp = hs.get(clothes[i][1]);
                hs.put(clothes[i][1], tmp+1);
            }

        }
        final int[] answer = {1};

        hs.forEach((key, value) -> {
            answer[0] *= (value+1);
        });
        System.out.println(answer[0] -1);
    }
}
