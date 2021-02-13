package 프로그래머스.Level1;

public class 최대공약수최소공배수 {
    public static void main(String[] args) {
        solution(3,12);
    }
    static int[] solution(int n, int m) {
        int[] answer = {};
        int gcdNumber = gcd(n,m);
//        System.out.println(gcdNumber);
//        System.out.println(gcdNumber * (n / gcdNumber) * (m /gcdNumber));
        answer[0] = gcdNumber;
        answer[1] = gcdNumber * (n / gcdNumber) * (m /gcdNumber);


        return answer;
    }
    private static int gcd(int n, int m) {
        if(m == 0){
            return n;
        }
        return gcd(m, n % m);
    }

}
