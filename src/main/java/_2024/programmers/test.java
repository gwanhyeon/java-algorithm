package _2024.programmers;

public class test {
    public static void main(String[] args) {
        System.out.println((gcd(8,12)));
    }
    private static int gcd(int w, int h){
        if(h == 0){
            return w;
        }
        System.out.println(h +","+w%h);
        return gcd(h, w%h);

    }
}
