package 스터디.스터디_GN.스터디_GN_1주차;

public class 동전_그리디 {
    public static void main(String[] args) {
        solution(1260,new int[]{500,100,50,10});

    }



    // comment 반드시 배수의 동전을 갖고 있어야하고 그게 아닐 경우에는 dp를 사용해야합니다.
    private static void solution(int money, int[] types) {
        int sum = 0;
        for(int i=0; i < types.length; i++){
            sum += money / types[i];
            money = money % types[i];
        }
        System.out.println(sum);
    }
    // 최소개수는 즉, 6개(500-2, 100-2, 50-1, 10-1)
}
