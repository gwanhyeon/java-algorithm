package 스터디.스터디_GN.스터디_GN_9주차;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        solution(8 ,12);
    }
    // (직사각형넓이-직사각형 둘레)최대공약수)
    // (96-20) + 4
    static long solution(int w, int h){
        int gcdNumber = gcd(w,h);
        System.out.println("gcdNumber = " + gcdNumber);
        long answer = (long)w*(long)h-(long)w-(long)h+gcdNumber;
        System.out.println(answer);
        return answer;
    }
    // 12 8
    // h w%h
    // 8 4
    // 4 0
    static int gcd(int w, int h){
        if(h==0){
            return w;
        }
        return gcd(h, w%h);
    }
}
