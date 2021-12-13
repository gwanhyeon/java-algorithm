package _2021.JavaGrammar.문법;
import java.util.Arrays;
import java.util.List;

public class 리스트_asList {
    public static void main(String[] args) {
        // int형을 바꾸는건 불가능하지만 String형태를 변경하는것은 가능하다.
        //유형별.String str;
        int[] arr = {1,2,3,4,5,6};
        String[] str = {"a","b","c"};
        for(int value : arr){
            System.out.println(value);
        }
        for(String value : str){
            System.out.println(value);
        }
        // asList로 생성된 리스트는 add할수없다.
        //List<Integer> arr1 = Arrays.asList(arr);
        List<String> str_list = Arrays.asList(str);
        for(String value : str_list){
            System.out.println(value);
        }
    }
}
