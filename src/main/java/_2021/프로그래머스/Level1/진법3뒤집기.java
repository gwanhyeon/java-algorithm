package _2021.프로그래머스.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 진법3뒤집기 {
    public static void main(String[] args) {
//        solution(45);
        solution(125);
    }
    static int solution(int n) {
        int answer = 0;
        List<Integer> arrList = new ArrayList<>();
        while(n > 0){
            int div = n % 3;
            n /= 3;
            arrList.add(div);
        }
        arrList.forEach(i -> System.out.print(i));
        System.out.println();
        Collections.reverse(arrList);
        arrList.forEach(i -> System.out.print(i));
        System.out.println();
        int sum = 0;
        for (int i = 0; i < arrList.size(); i++) {
            sum += Math.pow(3,i) * arrList.get(i);
        }
        answer = sum;
        return answer;
    }
}
