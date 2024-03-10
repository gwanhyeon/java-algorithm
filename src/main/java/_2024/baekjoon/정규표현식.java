package _2024.baekjoon;

public class 정규표현식 {
    public static void main(String[] args) {
        String s = "adfasd+";
        s = s.replaceAll("\\+$","");
        System.out.println(s);

    }
}
