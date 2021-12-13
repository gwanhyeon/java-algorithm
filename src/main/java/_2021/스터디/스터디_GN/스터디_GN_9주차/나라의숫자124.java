package _2021.스터디.스터디_GN.스터디_GN_9주차;

public class 나라의숫자124 {
    public static void main(String[] args) {
        solution(10);
    }
    static void solution(int n){
        String str = "";
        while(n > 0){
            int res = n % 3;
            if(res == 0){
                res = 4;
                n = (n/3) - 1;
            }else {
                n = (n/3);
            }
            str += res;
        }
        System.out.println(str);
    }
}
