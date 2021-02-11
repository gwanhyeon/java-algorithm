package JavaGrammar.문법;

public class 정규표현식_문자숫자 {
    public static void main(String[] args) {
        String str = "01-abc123-한글1234";
        String 숫자 = str.replaceAll("[^0-9]","");
        String 숫자제외 = str.replaceAll("[0-9]","");
        String 문자 = str.replaceAll("[^a-zA-Z]","");
        System.out.println(str + " ==> " + 숫자);
        System.out.println(str + " ==> " + 숫자제외);
        System.out.println(str + " ==> " + 문자);
    }
}


