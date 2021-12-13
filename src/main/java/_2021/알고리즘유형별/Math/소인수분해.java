package _2021.알고리즘유형별.Math;

import java.util.HashMap;

/*
1. int형으로 하면 얼마까지 나타낼 수 있는가?

   int형으로 했을 경우 Test해 본 결과로는 21억까지 밖에 계산이 안되네요.
   즉, 2,147,483,646 을 아래처럼 해 봤죠.
    int result = Integer.parseInt("2147483646") + 1;
   은 제대로 계산이 되는데,
    int result = Integer.parseInt("2147483647") + 1;
   의 값은  -2147483648이 나오네요...


2. 그럼 long형으로 하면 얼마까지 가능할까?

   long형은 9,223,372,036,854,775,806 까지 됩니다.
   '조' 다음이 '경'이니까 9백2십2경 3천조 까지구낭...
    long result = Long.parseLong("9223372036854775806 ) + 1;

   9223372036854775807 + 1 은 -9223372036854775808 로 나오네요.

[결론] 따라서 21억 이상을 표현하려면 long형이 필요함을 알수 있습니다.
   만약 소수점 이하 자릿수도 표현해야 한다면 double형이 필요합니다.
   double형으로 했을 경우도 반드시 만능이 아닙니다.

3. 그럼 자바의 최대 소수점 처리가 가능한 double형은 어디까지인가요?

 1)소수 이하의 자리수를 유효숫자 2자리까지 필요하다면 그 수치는
   70조(70,368,744,177,663.99) 까지 입니다.
   아래와 같은 프로그램에서

   import java.text.DecimalFormat;
   DecimalFormat df = new DecimalFormat("#########################.00");
   double d = new Double(src.getText()).doubleValue();
   d += 0.01;
   textfield.setText(df.format(d) );

   70368744177663.99 + 0.01 = 70368744177664 로 제대로 계산되나
   70368744177664.00 + 0.01 = 70368744177664.02 로 0.01의 오차가 발생합니다.

 2







4. 근데, java.math.BigDecimal 은 뭐하는 거예요?
   java.math.BigInteger도 있던데?

   import java.math.BigDecimal;
   BigDecimal op1 = new BigDecimal("100000000000000000000000000000000000.01");
   BigDecimal op2 = new BigDecimal("10002341234124000000000000000000.2134");
   BigDecimal sum = op1.add(op2);
   textArea.setText(sum.toString());

   등과 같이 사용하는데, 아무리 큰 수 일지라도 완벽하게 계산해 냅니다.
   java.math.BigInteger 는 정수형을 계산한다는 것을 제외하고 똑 같습니다.


[진짜 결론]
   날로 통화화폐가치가 떨어 지는 요즘 조단위는 심심찮게 신문에 등장하는 수치입니다.
   이젠 천문학적인 숫자가 아니라 일상적인 숫자로 되는 요즘 돈계산을 하실 때,
   아무 생각없이 사칙연산을 할 것이 아니라 보다 유효자리숫자를 고려하여 연산을
   생각하는 꼼꼼한 프로그래머가 됩시다.... ;

   마지막으로 건의를 주신 이원경님께 감사드리며 반영하도록 해야 겠네요.

[PS] 자바의 Default Decimal 형은 float형이 아니라 double형입니다.
   즉 float f = (float) 5.0; 등과 같이 cast연산자를 사용하는 반면에
     double d = 5.0;  이렇게 사용할 수 있는 거죠.
   구태여 자바에서 float형을 쓸 일은 없다고 보여집니다. 유효숫자 자리수만 낮아질 뿐이죠.
 */
public class 소인수분해 {

    public static void main(String[] args) {

        long num = Long.parseLong("9999962000357");
        long num_tmp = Long.parseLong("9999962000357");
        HashMap<String,Integer> hm = new HashMap<>();

        /*
        long타입을 표현하기 위해서는 Long.parseLong으로 선언한다.

        최적화 방안
        - 지워지지 않은 수를 찾을 때 n이 아니라 sqrt(n) 까지만 찾는다.
        - i의 배수들을 지울 때 2 * i 에서 시작하는 것이 아니라 i * i 에서 시작한다. 2 * i에서 2의 배수 들은 모두 지워졌을 것이고 3 * i 는 3의 배수를 지울 때 이미 지워졌을 테니까.
         */
        for(long i=2; i*i<=num; i++){
            //System.out.println(i);
            while(num % i == 0){
                System.out.println(i);
                num = num / i;
                //System.out.println(num);
            }
        }
        if(num == num_tmp){
            System.out.println("-1");
        }
        else if(num > 1){
            System.out.println(num);
        }
    }
}
