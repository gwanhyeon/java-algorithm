import java.util.*;

public class 파일명정렬 {
    /* 파일명정렬 풀이하였는데, 올바르지 않은 방법임 */
    /*
    public static void main(String[] args) {

        String[] files = {"foo9.txt", "foo010bar020.zip", "F-15"};
        int answer = 0;
        HashMap<String, Integer> head = new HashMap<>();
        HashMap<Integer, Integer> number = new HashMap<>();
        HashMap<String, Integer> tail = new HashMap<>();

        // foreach
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            String tmp = "";
            int tmp_size = 0;
            for (int j = 0; j < file.length()-1; j++) {

                if (file.charAt(j + 1) >= '0' && file.charAt(j + 1) <= '9') {
                    tmp = file.substring(0, j + 1);
                    tmp_size = tmp.length();
                    head.put(tmp,i);
                }
                if (file.charAt(j + 1) == '.') {
                    number.put(Integer.parseInt(file.substring(tmp_size, j + 1)),i);
                    tail.put(file.substring(j + 1, file.length()), i);
                    break;
                }
            }
        }

        //대소문자 구분없이 정렬
        TreeMap<String,Integer> tm = new TreeMap<String,Integer>(head);
        Set<String> keyset = head.keySet();
        // 오름 차순 정렬
        Iterator<String> keyiterator = tm.keySet().iterator();
        // 내림 차순 정렬
        // Iterator<String> keyiterator = tm.descendingKeySet().iterator();
        String k;
        int v;
        while(keyiterator.hasNext()) {
            k = (String)keyiterator.next();
            v = tm.get(k);
            System.out.println("키 : "+k+" ---> 값 : "+v);
        }

    }
     */
    public static void main(String[] args) {
        String[] files = {"foo9.txt9", "foo010bar020.zip", "F-15"};
        Solution solution = new Solution();
        solution.solution(files);


    }
    static class Solution {
        public String[] solution(String[] files) {

            Arrays.sort(files, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    String head1 = s1.split("[0-9]")[0];
                    String head2 = s2.split("[0-9]")[0];

                    s1 = s1.replace(head1, "");     // foo
                    s2 = s2.replace(head2, "");     // foo

                    head1 = head1.toLowerCase();
                    head2 = head2.toLowerCase();

                    int headCompareValue = head1.compareTo(head2);

                    // head1 == head2 return 0
                    if(headCompareValue == 0) {
                        String num1 = "";
                        for(char c : s1.toCharArray()){
                            if(!(c >= '0' && c <= '9')){
                                break;
                            }
                            num1 += c;
                        }
                        String num2 = "";
                        for(char c : s2.toCharArray()){
                            if(!(c >= '0' && c <= '9')){
                                break;
                            }
                            num2 += c;
                        }

                        return Integer.parseInt(num1) - Integer.parseInt(num2);
                    }else {
                        return headCompareValue;
                    }


                }
            });

            for(String s : files){
                System.out.println(s);
            }

            return files;
        }
    }

}
