package 프로그래머스.Level1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        solution(new String[]{"leo","kiki","eden"},
                new String[]{"eden","kiki"}
                );
    }
    static String solution(String[] participant, String[] completion){

        Map<String,Integer> m = new HashMap<>();

        for(int i=0; i<participant.length; i++){
            if(!m.containsKey(participant[i])){
                m.put(participant[i],1);
            }else {
                m.put(participant[i],m.get(participant[i])+1);
            }
        }

        for(int i=0; i<completion.length; i++){
            if(m.containsKey(completion[i])){
               m.put(completion[i],m.get(completion[i])-1);
            }
        }
        String answer = "";
        for(String key : m.keySet()){
            if(m.get(key) > 0){
                answer = key;
            }
        }

        System.out.println(answer);
        return answer;
    }
}
