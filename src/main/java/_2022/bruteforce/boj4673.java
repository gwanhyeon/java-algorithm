package _2022.bruteforce;


/* boj 셀프 넘버 4673 */
/*
일의 자리 : v % 10
십의 자리 : (v % 100) / 10
백의 자리 : (v % 1000) / 100
천의 자리 : (v % 10000) / 1000

33, 33+3+3
*/

public class boj4673 {
    static boolean[] isSelfNumber;
    public static void main(String[] args) {
        System.out.println(selfNumber(111));
        int n = 10000;
        isSelfNumber = new boolean[n+1];
        for(int i=1; i<n; i++){
            int num = selfNumber(i);
            if(num <= n){
                isSelfNumber[num] = true;
            }
        }
        for(int i=1; i<n+1; i++){
            if(!isSelfNumber[i]) System.out.println(i);
        }
    }
    private static int selfNumber(int v) {
        int num = v;
        while(v > 0){
            num += v % 10;
            v /= 10;
        }
        return num;
    }
}
