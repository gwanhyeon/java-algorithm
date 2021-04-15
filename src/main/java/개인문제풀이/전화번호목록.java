import java.util.Arrays;
import java.util.HashSet;

public class 전화번호목록 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        boolean answer = true;
        //유형별.String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book = {"123","456","789"};
        hs.add(phone_book[0]);
        Arrays.sort(phone_book);
        for(int i=1; i<phone_book.length; i++){
            String tmp ="";
            for(int j=0; j<phone_book[i].length(); j++){
                tmp += phone_book[i].charAt(j);
                if(hs.contains(tmp)){
                    answer = false;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
