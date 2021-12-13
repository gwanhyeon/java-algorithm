package _2021.알고리즘유형별.Math;

public class 에라토스테네스의체 {
    static long[] prime = new long[10000001];
    static long[] check = new long[10000001];
    static long[] check_prime = new long[10000001];
    static int pn = 0;
    public static void main(String[] args) {

        //long num = 9999962000357;
        int n = 100;
        for(int i=2; i<=n; i++){
            if(check[i] == 1){
                continue;
            }
            prime[pn++] = i;
            for(int j=i+i; j<=n; j+=i){
                check[j] = 1;
            }
        }

        for(int i=2; i<=n; i++){
            if(check[i] == 0){
                System.out.print(i);
            }
        }
//        System.out.println();
//        boolean tf = false;
//        for(int i=0; i<prime.length; i++){
//
//            for(int j=i; j<prime.length; j++){
//                long sum = prime[i] * prime[j];
//
//                if(sum == num){
//                    System.out.println(prime[i] + "," + prime[j]);
//                    tf = true;
//                    break;
//                }
//
//            }
//        }
//
//        if(!tf){
//            System.out.println("-1");
//        }


        //dfs(prime, 0, 1,0, num);

    }

    // 6 [2,3]
    private static void dfs(long[] prime,int idx, long sum, int cnt, int num) {

        if(cnt==2){

            boolean tf = false;
            for(int i=0; i<prime.length; i++){
                if(check_prime[i] == 1){
                    System.out.println(prime[i]);
                    tf = true;
                }
            }
            if(tf){
                System.out.println("-1");
            }
            return;
        }

        for(int i=0; i<prime.length; i++){
            if(check_prime[i] == 1){
                continue;
            }
            check_prime[i] = 1;
            dfs(prime, i,prime[i] * sum, cnt+1, num);
            check_prime[i] = 0;
        }
    }


}
