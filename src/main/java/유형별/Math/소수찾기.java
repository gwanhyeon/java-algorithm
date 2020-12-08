package Math;

public class 소수찾기 {
    static boolean[] check = new boolean[1000001];
    public static void main(String[] args) {

        int n =10;

        check[0] = true;
        check[1] = true;

        for(int i=2; i*i<=n; i++){
            if(!check[i]){
                for(int j=i+i; j<=n;j+=i){
                    check[j] = true;
                }
            }
        }

        int sum = 0;
        for(int i=2; i<=n; i++){
            if(!check[i]){
                sum++;
            }
        }

        System.out.println(sum);


    }
}
