public class 나라의숫자124 {
    public static void main(String[] args) {

        int n = 10;

        StringBuilder answer = new StringBuilder();


        while(n > 0){
            int res = n % 3;

            if(res == 0){
                res = 4;
                n = (n/3)-1;
            }else {
                n = (n/3);
            }
            answer.append(Integer.toString(res));
        }

//        String answer = "";
//        int tmp = 0;
//        int div = 0;
//        if(n % 3 == 1){
//            tmp = 1;
//            div = n / 3;
//        }else if(n % 3 == 2){
//            tmp = 2;
//            div = n / 3;
//        }else if(n % 3 == 0){
//            tmp = 4;
//            div = (n-1 / 3) + 1;
//        }
//        System.out.println(div);
//        if(div == 0){
//            answer = Integer.toString(tmp);
//        }else {
//            answer = Integer.toString(tmp) + Integer.toString(div);
//        }
        System.out.println(answer.reverse());






    }
}
/*

3으로 나눈 나머지 1 -> 1
3으로 나눈 나머지 2 -> 2
3으로 나눈 나머지 0 -> 4

시작되는값의 몫을 더해준다













n의 값을 4로 나누었을때 몫 앞자리
몫 0 1
몫 1 2
몫 2 4

n의 값을 4로 나눈 나머지 1 앞자리 + 1
n의 값을 4로 나눈 나머지 2 앞자리 + 2
n의 값을 4로 나눈 나머지 3 앞자리 + 4
 */
