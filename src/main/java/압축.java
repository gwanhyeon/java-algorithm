import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {
    public static void main(String[] args) {
        int[] answer = {};
        String msg = "KAKAO";
        HashMap<String, Integer> dict = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;
        for(char i='A'; i<='Z'; i++){
            dict.put(String.valueOf(i), cnt++);

        }
        /* print hashmap 출력하기 */

//        dict.forEach((key, value)-> {
//            System.out.println("key-> " + key + "value->" + value);
//        });
        int dict_size = dict.size();

        String curr = "";
        String w = "";
        String c = "";
        String ans = "";
        int w_num = 0;
        int c_num = 1;
        Boolean check = false;
        while(true){
            if(msg.length() == 1) {
                w = msg.substring(w_num, c_num);        // 0, 1
                System.out.print(dict.get(w));
                ans += dict.get(w);
                list.add(dict.get(w));
                break;
            }

            w = msg.substring(w_num, c_num);        // 0, 1
            c = msg.substring(w_num+1,c_num+1);     // 1, 2
            String comp = w + c;

            // K는 등록 두번째 KA 없을 경우
            if(dict.containsKey(w) && !dict.containsKey(comp)){
                // 첫번째 색인번호 출력
                System.out.println(dict.get(w));
                ans += dict.get(w);
                list.add(dict.get(w));
                dict.put(comp, ++dict_size);
                msg = msg.replaceFirst(w, "");

            } else if(dict.containsKey(w) && dict.containsKey(comp)){
//                c = msg.substring(w_num+2,c_num+2);     // 1, 2
                c = msg.substring(w_num+2,c_num+2);     // 1, 2
                w = comp;
                comp = w + c;
                System.out.println(dict.get(w));
                list.add(dict.get(w));
                ans += dict.get(w);
                dict.put(comp, ++dict_size);
                msg = msg.replaceFirst(w, "");
            }
//            else {
//                System.out.println(dict.get(comp));
//                dict.put(comp, ++dict_size);
//                msg = msg.replaceFirst(w, "");
//            }
//            if(dict.containsKey(w) && dict.containsKey(c) && !dict.containsKey(comp)){
//                c_num++;
//                w_num++;
//                check = true;
//            }

        }

        System.out.println(ans.toString());
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
    }
}
