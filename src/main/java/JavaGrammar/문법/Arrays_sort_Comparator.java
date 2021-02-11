package JavaGrammar.문법;

import java.util.Arrays;
import java.util.Comparator;


/*
배열 Compator

comment: comparator에 들어오는 값들 순서
배열 1,2,3
a: 2 b: 1   2 > 1 기준값이 비교값보다 크므로 return 1
a: 3 b: 2   3 > 2 기준값이 비교값보다 크므로 return 1
a.compareTo(b)

배열 5,3,2
a: 3 b: 5   3 < 5 기준값이 비교값보다 작으므로 return -1
a: 2 b: 3   2 < 3 기준값이 비교값보다 작으므로 return -1

배열: 5,3,3

a: 3 b: 5   3 < 5 기준값이 비교값보다 작으므로 return -1
a: 3 b: 3   3 == 3 기준값이 비교값과 같으므로 return 0;


 A.compareTo(B)
 * A와 B가 같으면 0을 반환
 * A가 B보다 크면 양수를 반환
 * A가 B보다 작으면 음수를 반환
 */
public class Arrays_sort_Comparator {
    public static void main(String[] args) {
        Integer[] arr = {5,3,3};
        int a = 5;
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("o1:" + o1 + " o2:" + o2);
                System.out.println("compareTo:" + o1.compareTo(o2));
                System.out.println();
                return o1.compareTo(o2);
            }
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        for(int value : arr){
            System.out.print(value);
        }
    }
}
