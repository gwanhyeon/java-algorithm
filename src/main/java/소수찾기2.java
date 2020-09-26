public class 소수찾기2 {

    static boolean[] check;
    static boolean[] str_check;
    static int answer = 0;


    static boolean isPrime(int num){
        if(num == 0 || num == 1){
            return false;
        }

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;

    }
    static void dfs(int cnt, String numbers, String res){

        if(res != "" && check[Integer.parseInt(res)] == false){

            int num = Integer.parseInt(res);
            check[num] = true;

            if(isPrime(num) == true){
                answer +=1;
            }
        }

        for(int i=0; i<numbers.length(); i++){
            if(str_check[i] == true){
                continue;
            }

            str_check[i] = true;
            dfs(cnt, numbers, res + numbers.charAt(i));
            str_check[i] = false;
        }


    }

    public static void main(String[] args) {
        check = new boolean[10000000];
        str_check = new boolean[10];
        String numbers = "17";

        dfs(0, numbers, "");
        System.out.println(answer);

    }
}
