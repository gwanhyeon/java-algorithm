import java.util.*;

public class kakao_test02 {
    static class Pair{
        String x;
        int y;

        Pair(String x, int y){
            this.x = x;
            this.y = y;
        }
    }



    static int[] check;
    static HashMap<String,Integer> map = new HashMap<String,Integer>();
    static ArrayList<Pair> arr = new ArrayList<Pair>();
    static void dfs(int idx, int cnt, String orders, int course){


        if(course == cnt){
            String tmp = "";
            for(int j=0; j<orders.length(); j++){
                if(check[j] == 1){
                    tmp += orders.charAt(j);
                }
            }
            arr.add(new Pair(tmp, cnt));
            return;
        }


        for(int i=idx; i<orders.length(); i++){
            if(check[i] == 1){
                continue;
            }
            check[i] = 1;
            dfs(idx+i, cnt+1, orders, course);
            check[i] = 0;

        }
    }
    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        String[] answer;
        String select = "";
        check = new int[orders.length];

        Arrays.sort(orders);

        // 조합을 하자
        int size = course.length;
        for(int i=0; i<orders.length; i++){
            for(int j=0; j<course.length; j++){
                dfs(0,0,orders[i], course[j]);
            }

        }
        int cnt = 0;
        // lamda

        Collections.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.x.compareTo(o2.x);
            }
        });

        answer = new String[arr.size()];

        for(int i=0; i<arr.size(); i++){
            Pair pair = arr.get(i);
            map.put(pair.x, pair.y);
//            Pair pair1 = arr.get(i);
//            map.put(pair.x, pair.y);
//
//
//            if(pair.x.equals(pair1.x)){
//                answer[pair_size] = pair.x;
//                i+=2;
//            }
//            pair_size++;
        }
        int pair_size = 0;
        map.forEach((key, value) -> {
            answer[pair_size] = key;
        });
    }
}
