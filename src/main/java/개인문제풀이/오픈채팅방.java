import java.util.*;

public class 오픈채팅방 {
    static class Pair{
        String x;
        String y;

        Pair(String x, String y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String,String>();
        HashMap<String,String> command_map = new HashMap<String,String>();
        String[] answer = new String[100001];
        String record[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i=0; i<record.length; i++){
            String[] arr = record[i].split(" ");
            // Enter [0], uid1234 [1], Muzi [2]


            // 채팅방에 입장하였을때
            if(arr[0].equals("Enter")){
                q.add(new Pair(arr[0],arr[1]));
                map.put(arr[1],arr[2]);
                //command_map.put(arr[0],arr[1]);
            }
            // 채팅방에 떠났을때
            else if(arr[0].equals("Leave")){
                q.add(new Pair(arr[0],arr[1]));
                //command_map.put(arr[0],arr[1]);
            }
            // 채팅방에 이름을 변경하였을 때
            else if(arr[0].equals("Change")){
                //map.replace(arr[1], "");
                map.replace(arr[1], arr[2]);

            }
        }
        int cnt = 0;
        answer = new String[q.size()];
        while(!q.isEmpty()){
            Pair p = q.poll();
            //Queue<Pair> res = q.poll
            String x = p.x;
            String y = p.y;
            if(x.equals("Enter")){
                answer[cnt] = map.get(y) + "님이 들어왔습니다.";
                //System.out.println(map.get(y) + "님이 들어왔습니다.");
            }else if(x.equals("Leave")){
                answer[cnt] = map.get(y) + "님이 나갔습니다.";
                //System.out.println(map.get(y) + "님이 나갔습니다.");
            }
            cnt++;
        }


//
//        Set set = map.keySet();
//        Iterator iterator = set.iterator();
//
//        int cnt = 0;
//        //KeySet() 활용
//
//        for(유형별.String j : command_map.keySet()) { //저장된 key값 확인
//            if(j.equals("Enter")){
//                System.out.println(map.get(j) + "님이 들어왔습니다.");
//            }else if(j.equals("Leave")){
//                System.out.println(map.get(j) + "님이 나갔습니다.");
//            }
//            cnt++;
//        }
//
//
//
//

    }
}
