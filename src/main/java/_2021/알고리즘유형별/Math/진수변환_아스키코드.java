package _2021.알고리즘유형별.Math;

public class 진수변환_아스키코드 {

    static int cnt = 0;
    static StringBuilder nToConvertBinary(int num, int jinsu, StringBuilder arr){
        while(num > 0){
            int remain = num % jinsu;
            if(remain >= 0 && remain <=9){
                arr.append((char) (remain + '0'));
            }else {
                arr.append((char) ('A' + (remain-10)));
            }
            num = num / jinsu;
//            System.out.println(arr[cnt]);
            cnt+=1;
        }
        return arr;
    }
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        int num = 12;
        int jinsu = 16;
        System.out.println(10+'0');         // 10의 값에서 '0'의 아스키코드값을 추가하면 해당되는 값을 얻을 수 있다. 58
        System.out.println(10-'0');         // 10의 값에서 '0'의 아스키코드값을 빼버리면 -38이 나온다. 아스키코드값을 빼버리므
        s = nToConvertBinary(num,jinsu,s);

        for(int i=0; i<s.length(); i++){
            System.out.println(s.charAt(i));
        }
//        for(int a : arr){
//            System.out.println(a);
//        }
//        int cnt = 0;
//        while(cnt >= 0){
//            System.out.println(arr[cnt]);
//            cnt--;
//        }
    }
}
