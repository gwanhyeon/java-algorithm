package 스터디.스터디_GN.스터디_GN_10주차;

public class 소수찾기 {
    static boolean[] check;
    static boolean[] checkStr;
    static int answer = 0;
    public static void main(String[] args) {
        solution("17");
    }
    static int solution(String numbers) {
        check = new boolean[10];
        checkStr = new boolean[10000000];
        dfs(numbers,"");
        System.out.println(answer);
        return answer;
    }

    private static void dfs(String numbers, String str) {
        if(!str.equals("") && !checkStr[Integer.parseInt(str)]){
            int num = Integer.parseInt(str);
            checkStr[num] = true;
            if(isPrime(num)){
                answer++;
            }
        }
        // 17
        // 71
        for (int i = 0; i < numbers.length(); i++){
            if(check[i]) {
                continue;
            }
            check[i] = true;
            dfs(numbers, str+numbers.charAt(i));
            check[i] = false;
        }
    }
    private static boolean isPrime(int num) {
        if(num == 0 || num == 1){
            return false;
        }
        System.out.println(Math.sqrt(num));
        // 123456789
        for(int i=2; i<Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
