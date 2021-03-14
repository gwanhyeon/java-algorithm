package 스터디.스터디_SNU.Section01;

// https://programmers.co.kr/learn/courses/30/lessons/62048
/*
문제 접근법
전체크기 - (가로 + 세로) + 최대공약수(gcd)
 */
public class programmers_멀쩡한사각형_kgh {
    public static void main(String[] args) {
        System.out.print(solution(8,12));
    }
    // 12 8
    // 8 4
    // 4 0
    static long solution(int w, int h) {
        int gcdNum = gcd(w, h);
        long squareArea = (long) w * (long) h;
        long answer = (squareArea - ((long) w + (long) h)) + gcdNum;
        return answer;
    }
    private static int gcd(int w, int h) {
        if(h == 0){
            return w;
        }
        return gcd(h, w % h);
    }
}
