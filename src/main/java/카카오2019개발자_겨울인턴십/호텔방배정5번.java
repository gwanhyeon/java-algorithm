package 카카오2019개발자_겨울인턴십;
import java.util.*;

/*
Set 사용하기, LinedHashMap 사용하기 정렬되지 않은 순서로 들어가게 된다.

 */
public class 호텔방배정5번 {
    public static void main(String[] args) {
        solution(10, new long[]{1,3,4,1,3,1});
    }

    static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        HashMap<Long,Long> hm = new LinkedHashMap<>();
        // 고객 방 배정
        int idx = 0;
        for(int i=0; i<room_number.length; i++){
            // 방 배정이 안된 경우 -> 방 배정시키기
            if(!hm.containsKey(room_number[i])){
                hm.put(room_number[i], 1L);
                answer[idx++] = room_number[i];
            }
            // 방 배정되어있는 경우 (방번호보다 크면서 방 중 가장 번호가 작은방 배정)
            else {
                Set set = hm.keySet();
                Iterator iterator = set.iterator();
                for(long j=room_number[i]; j<k; j++){
                    if(j > room_number[i] && !hm.containsKey(j)){
                        hm.put(j, 1L);
                        answer[idx++] = j;
                        break;
                    }
                }
            }
        }
//         Set set = hm.keySet();
//         Iterator iterator = set.iterator();
//         int idx = 0;
//         while(iterator.hasNext()){
//             long Key = (long)iterator.next();
//             answer[idx++] = Key;
//         }
        return answer;
    }
}
