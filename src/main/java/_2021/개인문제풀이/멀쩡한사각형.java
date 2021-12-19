package _2021.개인문제풀이;

public class 멀쩡한사각형 {

    static int gcd(int w,int h){


        if(h == 0){
            return w;
        }
        return gcd(h, w % h);
    }
    public static void main(String[] args) {

        int w = 8;
        int h = 12;

        int gcd_num = gcd(w,h);
        System.out.println(gcd_num);

        long squreArea = (long)w * (long)h;
        System.out.println(squreArea);
        long answer = squreArea - ((long)w + (long )h) + gcd_num;
        System.out.println(answer);





    }
}
