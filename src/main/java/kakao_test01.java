import java.util.regex.Pattern;

/*
입력값 〉	"z-+.^."
기댓값 〉	"z--"
실행 결과 〉	실행한 결괏값 'z-+.^'이(가) 기댓값 'z--'와(과) 다릅니다.
출력 〉	z-+.^
 */
public class kakao_test01 {
    public static void main(String[] args) {
        String answer = "";
        //String new_id = "";
        String new_id = "z-+.^.";
        // 1단계: 대문자->소문자 변경
        new_id = new_id.toLowerCase();
        System.out.println("1단계 -> " + new_id);
        // 2단계: !@#* 포함된 문자 제거
        String match = "[^a-z0-9_.-]";
        //String match = "[!@#*]";
        new_id = new_id.replaceAll(match, "");
        System.out.println("2단계 -> " + new_id);

        // 3단계 연속된 . 문자 치환 -> 하나의 .으로 치환
        String match2 = "[.*]{2,}";
        new_id = new_id.replaceAll(match2, ".");
        System.out.println("3단계 -> " + new_id);

        // 4단계 맨앞, 맨뒤 . 제거
        if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(0,new_id.length());
        }else if(new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        System.out.println("4단계 ->" + new_id);
        // 5단계 빈 문자열이라면 new_id에 "a"를 대입합니다.
        if(new_id.length() == 0){
            new_id += "a";
        }
        System.out.println("5단계 ->" + new_id);
        // 6단계 아이디 길이가 16자이상이면 15자를 제외한 나머지문자들을 제거
        if(new_id.length() > 15){
            new_id = new_id.substring(0,15);
            System.out.println(new_id.length());
            // 만약 제거후 . 이 존재한다면 끝에 위치한 . 문자를 제거합니다.
            if(new_id.charAt(new_id.length()) == '.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        System.out.println("6단계 ->" + new_id);

        String tmp ="";
        tmp += new_id.charAt(new_id.length()-1);

        if(new_id.length() <= 2 && new_id.length() >= 0){
            while(true){
                if(new_id.length() == 3){
                    break;
                }
                new_id += tmp;
            }
        }

        answer = new_id;

        System.out.println("7단계 -> " + new_id);

    }
}
