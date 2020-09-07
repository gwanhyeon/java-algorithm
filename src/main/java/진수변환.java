public class 진수변환 {

    static int cnt = 0;
    static char[] nToConvertBinary(int num, int jinsu, char[] arr){
        while(num > 0){
            int tmp = num % jinsu;
            if(tmp >= 0 && tmp <=9){
                arr[cnt] = (char) (tmp + '0');
            }else {
                arr[cnt] = (char) ('A' + (tmp-10));
            }
            num = num / jinsu;
            cnt+=1;
        }
        return arr;
    }
    public static void main(String[] args) {
        char[] arr = new char[100];
        int num = 12;
        int jinsu = 2;
        int cnt = 0;
        nToConvertBinary(num,jinsu,arr);
        while(cnt >= 0){
            System.out.println(arr[cnt]);
            cnt--;
        }
    }
}
