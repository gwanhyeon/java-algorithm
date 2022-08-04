package _2022.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1065번 한수 - 브루트포스
 * 등차수열은 100이하는 모두 등차수열로 생각한다. 그 외의 경우는 한수는 총 1~99 총 99개를 가지고 있다고 본다. 다른 조건일 경우 한수의 개수는 99개에서 디폴트로 설정된다.
 * 100이상일 경우 각 자리의 값을 뺀 값이 서로 같을 경우 등차수열이라고 생각한다.
 * 1000 일 경우는 예외로 1~999 자리까지만 처리해야하므로 예외 처리를 해준다.
 */
public class boj1065 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        if(n < 100){
            answer = n;
        }else {
            answer = 99;
            if(n == 1000){
                n = 999;
            }
            for(int i=100; i<=n; i++){
                int hundredNumber = (i % 1000) / 100;
                int tenNumber = (i % 100) / 10;
                int oneNumber = (i % 10);
                // 등차 수열 체크
                if((hundredNumber - tenNumber) == (tenNumber - oneNumber)){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
