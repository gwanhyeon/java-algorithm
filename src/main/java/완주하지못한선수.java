import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        Map<String,Integer> m = new HashMap<>();

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion ={"eden", "kiki"};
        String answer = "";
        for(int i=0; i<completion.length; i++){
            if(!m.containsKey(completion[i])){
                m.put(completion[i],1);
            }else {
                int tmp = m.get(completion[i]);
                m.put(completion[i], tmp+1);
            }
        }

        for(int i=0; i<participant.length; i++){
            // 완주자와 참가명단에서 못찾았으면
            if(!m.containsKey(participant[i])){
                answer = participant[i];
                break;
            }else {
                // 동명이인일 경우 값을 하나씩 줄였을때 0보다 작으면 그 사람이 완주자, 동명이인 체크해주기
                int tmp = m.get(participant[i]);
                m.put(participant[i],tmp-1);
                if(m.get(participant[i])< 0){
                    answer = participant[i];
                    break;
                }
            }
        }

        System.out.println(answer);


    }
}
