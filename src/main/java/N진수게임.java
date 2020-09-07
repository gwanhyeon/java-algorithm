import org.omg.IOP.Encoding;

public class N진수게임 {
    public static void main(String[] args) {
        StringBuilder answer = new StringBuilder();
        StringBuilder arr = new StringBuilder("0");
        String[] upperCase = {"A", "B", "C", "D", "E", "F"}; // 16진수일 경우에 바꿔줄 알파벳들
        int n = 2;      //진법
        int t = 4;      // 미리 구할 숫자의 개수
        int m = 2;      // 게임에 참가하는 인원
        int p = 1;      // 튜브의 순서

        int num = 1;
        while(arr.length() -1 < t * m){
            StringBuilder arr_tmp = new StringBuilder();
            int quot = num; // 몫
            int remain; // 나머지

            while(quot > 0){
                remain = quot % n;
                quot = quot / n;
                if(num >= 0 && num <= 9){
                    arr_tmp.append(remain);
                }else {
                    arr_tmp.append(upperCase[remain-10]);
                }

            }
            arr.append(arr_tmp.reverse());
            num++;
        }

        for(int i=0; i<t; i++){

            answer.append(arr.charAt(p-1));
            p+=m;
        }

        System.out.println(answer.toString());



    }
}


/* 풀이하였는데 오답 정답률 3.8% */
/*
public class N진수게임 {
    static int n = 2;
    static int t = 4;
    static int m = 2;
    static int p = 1;
    static char[] arr = new char[10001];
    static String answer = "";
    static int cnt = 0;
    public static void main(String[] args) {
        nToConvertBinary();
//        int size = cnt;
//        size = size - p;



        for(int i=p+1; i<=t+1; i++){
            System.out.println(arr[i]);
        }
    }

    private static void nToConvertBinary() {
        String str = "";
        for(int i=0; i<=1000; i++){
            int num = i;
            if(num == 0){
                int tmp = num % n;
                arr[cnt] = (char)(tmp + '0');
                cnt +=1;
                continue;
            }
            if(num >= 10){
                str += (num + '0');
                while(!str.isEmpty()){
                    str = str.substring(0,1);
                    str = str.replace(str, "");
                    while(num > 0){
                        int tmp = num % n;
                        if(tmp >= 10 && tmp <= 15){
                            arr[cnt] = (char)('A' + (tmp-10));
                        }else {
                            arr[cnt] = (char)(tmp + '0');
                        }
                        num = num / n;
                        cnt +=1;
                    }
                }
                continue;
            }else {
                while(num > 0){
                    int tmp = num % n;
                    if(tmp >= 10 && tmp <= 15){
                        arr[cnt] = (char)('A' + (tmp-10));
                    }else {
                        arr[cnt] = (char)(tmp + '0');
                    }
                    num = num / n;
                    cnt +=1;
                }
                continue;

            }

        }
    }
}

 */
