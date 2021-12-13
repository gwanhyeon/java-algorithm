package _2021.스터디.스터디_GN.스터디_GN_11주차;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public static void main(String[] args) {
        solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }
    static int solution(String[][] clothes) {

        int answer = 1;

        Map<String,Integer> m = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            String color = clothes[i][0];
            String kind = clothes[i][1];
            if(m.containsKey(kind)){
                m.put(kind, m.get(kind)+1);
            }else {
                m.put(kind, 1);
            }
        }
        for(String key : m.keySet()){
            answer *= (m.get(key)+1);
        }
        System.out.println(answer-1);
        answer -= 1;
        return answer;
    }
}
