package 프로그래머스.Level2;

import java.util.HashMap;
import java.util.Map;

public class 순위검색 {
    public static void main(String[] args) {
        solution(new String[]{
                "java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}
        , new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});

    }
    static int[] solution(String[] info, String[] query) {
        Map<String,Integer> m = new HashMap<>();
        Map<Integer,Integer> hyphen = new HashMap<>();
        for(int i=0; i<5; i++){
            hyphen.put(i,0);
        }
        for(int i=0; i<query.length; i++){

            String[] splitStr = query[i].split(" and ");
            for (int j=0; j<splitStr.length; j++) {
                String s = splitStr[j].trim();
                if(splitStr[j].equals("-")){
                    hyphen.put(j,hyphen.get(j)+1);
                }
                if(m.containsKey(s)){
                    m.put(s, m.get(s)+1);
                }else {
                    m.put(s,1);
                }
//                System.out.print(s+" ");
            }
//            System.out.println();
        }
        for(String s : m.keySet()){
            System.out.println("key: " + s + " value:" +m.get(s));
        }

        System.out.println();
        for(Integer i : hyphen.keySet()){
            for(String s : m.keySet()){
                m.put(s,m.get(s)+hyphen.get(i));
            }
        }

        for(String s : m.keySet()){
            System.out.println("key: " + s + " value:" +m.get(s));
        }





        return new int[]{};
    }
}
