package _2021.알고리즘유형별.String;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
    /* ArrayList를 사용한 풀이
    public static void main(유형별.String[] args) {
        유형별.String[] strings = {"sun", "bed", "car"};
        int n = 1;
        유형별.String[] answer;
        ArrayList<유형별.String> arr = new ArrayList<>();

        for (int i = 0; i < strings.length; i++){
            arr.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(arr);


        answer = new 유형별.String[arr.size()];

        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i).substring(1,arr.get(i).length());
        }

        for(int i=0; i<answer.size(); i++){

        }
    }
     */
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        String[] answer;
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                // 사전순으로 정렬하기
                //return s1.charAt(n) - s2.charAt(n);

                // 사전순 역순으로 정렬하기
                return s2.charAt(n) - s1.charAt(n);
//
            }
        });
        // lamda
        // Arrays.sort(strings,(s1,s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(strings));

    }
}
