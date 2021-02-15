package 프로그래머스.Level2;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        solution(8,12);
    }
    static long solution(int w, int h) {
        int gcdNumber = gcd(w,h);
        // (정사각형넓이-정사각형 둘레)최대공약수)
        // (96-20) + 4
        long squareArea = ((long)w*(long)h-((long)w+(long)h)) + gcdNumber;
        System.out.println(squareArea);
        return squareArea;

    }
    private static int gcd(int w, int h) {
        if(h == 0){
            return w;
        }
        return gcd(h, w%h);
    }
}
