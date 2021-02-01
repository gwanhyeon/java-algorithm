package 코딩테스트.Math;

public class 소수찾기2 {

    static boolean[] char_check = new boolean[10];
    static int[] str_check = new int[10000000];
    static int answer = 0;
    public static void main(String[] args) {
        String numbers = "17";
        dfs(numbers,"");
        System.out.println(answer);
    }

    private static void dfs(String numbers, String str) {
        if(!str.equals("") && str_check[Integer.parseInt(str)] == 0){
            int num = Integer.parseInt(str);
            str_check[num] = 1;

            if(isPrime(num)){
                answer++;
            }
        }

        for(int i=0; i<numbers.length(); i++){
            if(char_check[i]){
                continue;
            }
            char_check[i] = true;
            dfs(numbers, str+numbers.charAt(i));
            char_check[i] = false;
        }

    }

    private static boolean isPrime(int num) {

        if(num == 0 || num == 1){
            return false;
        }
        System.out.println(Math.sqrt(num));
        for(int i=2; i<Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
