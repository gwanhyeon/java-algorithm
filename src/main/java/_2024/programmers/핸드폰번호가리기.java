package _2024.programmers;

public class 핸드폰번호가리기 {
    public static void main(String[] args) {
        String phone_number = "01033334444";
        int startIdx = phone_number.length()-4;
        int endIdx = phone_number.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<startIdx; i++){
            sb.append("*");
        }
        sb.append(phone_number.substring(startIdx, endIdx));

        System.out.println(sb.toString());
    }
}
