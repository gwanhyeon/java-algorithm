package hackerrank;

public class repeatString {
    public static void main(String[] args) {
        String s = "aba";
        long n = 10;
        long numOfString = n / s.length();
        long remain = n % s.length();

        if(!s.contains("a")) return;

        long answer = 0L;
        if(s.length() > n){
            answer = counterOfString(s, remain);
        }else {
            answer = numOfString * counterOfString(s, s.length()) + counterOfString(s, remain);
        }
        System.out.println(answer);
    }
    private static long counterOfString(String s, long end){
        int a = 0;
        for(int i=0; i<end; i++){
            if(s.charAt(i) == 'a'){
                a++;
            }
        }
        return a;
    }

}
