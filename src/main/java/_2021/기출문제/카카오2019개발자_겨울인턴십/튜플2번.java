package _2021.기출문제.카카오2019개발자_겨울인턴십;

import java.util.*;

public class 튜플2번 {
    public static void main(String[] args) {
        //유형별.String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        Set<Integer> hs = new HashSet<>();
        String s = "{{20,111},{111}}";

        ArrayList<String> arr = new ArrayList<>();

        for(int i=1; i<s.length()-1; i++){
            StringBuilder tmp = new StringBuilder();

            if(s.charAt(i) == '{'){
                i++;
                while(s.charAt(i) != '}'){
                    tmp.append(s.charAt(i));
                    i++;
                }
                arr.add(tmp.toString());
            }
        }
        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        //arr.forEach(v -> System.out.println(v));

        int[] answer = new int[arr.size()];
        int idx = 0;

        for(int i=0; i<arr.size(); i++){
            String[] tmp = arr.get(i).split(",");
            for(String s1 : tmp){
                if(!hs.contains(Integer.parseInt(s1))){
                    hs.add(Integer.parseInt(s1));
                    answer[idx++] = Integer.parseInt(s1);

                }
            }
        }
        for (int i : answer) {
            System.out.println(i);
        }


    }
}

