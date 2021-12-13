package _2021.스터디.스터디_GN.스터디_GN_15주차;

public class N개의최소공배수 {
    public static void main(String[] args) {
        solution(new int[]{2,6,8,14});
    }
    static int solution(int[] arr) {
        int answer = arr[0];
        for (int v : arr) {
            // gcd
            int gcdNumber = gcd(answer, v);

            // 10 20 -> 20
             answer= Math.max(answer, gcdNumber * (answer/gcdNumber) * (v/gcdNumber));
        }
        System.out.println(answer);
        return answer;
    }

    private static int gcd(int n, int m) {
        if(m == 0){
            return n;
        }
        return gcd(m, n % m);
    }
}
