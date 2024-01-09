package _2024.programmers_01;

public class 서울에서김서방찾기 {
    public static void main(String[] args) {
        String[] seoul = {"Jane","Kim"};
        int answer = 0;
        for (int i = 0; i < seoul.length; i++) {
            if("Kim".equals(seoul[i])){
                answer = i;
            }
        }
        System.out.println("김서방은 " + answer + "에 있다");

    }
}
