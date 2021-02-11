package 기출문제.카카오인턴십2020;

import java.util.ArrayList;


/* 다시풀기 */



public class 수식최대화2번 {

    public static void main(String[] args) {
        solution("100-200*300-500+20");
    }

    static int[] check;
    static int[] cal;
    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> res = new ArrayList<>();
    static String change_str = "";

    static long solution(String expression) {
        long answer = 0;

        check = new int[3];
        cal = new int[3];

        // *:0, +:1, -:2
        for(int i=0; i<3; i++){
            cal[i] = i;
        }

        dfs(0,expression);
        return answer;
    }
    static void dfs(int cnt, String expression){
        if(cnt == 3){
            // arr: 연산자 우선순위 담고있음
            // cnt: 현재선택된 연산자 개수
            // expression: 연산자

            for(int i=0; i<arr.size(); i++){
                search(expression, 0, arr.get(i));
            }
            return;
        }

        for(int i=0; i<cal.length; i++){
            if(check[i] == 1){
                continue;
            }
            check[i] = 1;
            arr.add(i);
            dfs(cnt+1, expression);
            arr.remove(arr.size()-1);
            check[i] = 0;
        }

        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i));

        }

    }
    static void search(String expression, long answer, int cal) {

        String express = expression;
        String cal_str = "";
        if(cal == 0) cal_str += "*";
        else if(cal == 1) cal_str += "+";
        else if(cal == 2) cal_str += "-";
        while(true){

            StringBuilder tmp1 = new StringBuilder();
            StringBuilder tmp2 = new StringBuilder();
            int sum = 0;
            boolean tf = false;
            int start_idx = 0;
            int end_idx = 0;
            int cal_cnt = 0;
            for(int i=0; i<express.length(); i++){
                if((express.charAt(i) + "").equals(cal_str)){
                    tf = true;
                    cal_cnt++;
                    continue;
                }else if(express.charAt(i) >= '0' && express.charAt(i) <= '9'){
                    if(tf == false){
                        tmp1.append(express.charAt(i));
                    }else {
                        tmp2.append(express.charAt(i));
                    }
                    continue;
                }else {

                    if(tf == true){
                        end_idx = i;
                        break;
                    }else {
                        start_idx = i;
                        tmp1.setLength(0);
                    }
                }
            }


            if (cal_cnt == 0) {
                return;
            }


//            System.out.println(start_idx + "" + end_idx);
//            System.out.println(Integer.parseInt(tmp1.toString()));
//            System.out.println(Integer.parseInt(tmp2.toString()));
            switch (cal) {
                case 0:
                    sum = Integer.parseInt(tmp1.toString()) * Integer.parseInt(tmp2.toString());
                    break;
                case 1:
                    sum = Integer.parseInt(tmp1.toString()) + Integer.parseInt(tmp2.toString());
                    break;
                case 3:
                    sum = Integer.parseInt(tmp1.toString()) - Integer.parseInt(tmp2.toString());
                    break;
            }

            System.out.println(sum);

            String start_str = express.substring(0, start_idx+1);
            String end_str = express.substring(end_idx, express.length());
            if(start_str.length() == 0){
                express = Integer.toString(sum) + end_str;
            }else if(end_str.length() == 0){
                express = start_str + Integer.toString(sum);
            }else if(start_str.length() != 0 && end_str.length() != 0){
                express = start_str + Integer.toString(sum) + end_str;
            }
        }





    }

    /*
    static int search(유형별.String expression, int answer, int cal){



        if(expression.length() == 0){
            return 0;
        }

        유형별.String tmp_cal = "";
        // 어떤연산이 들어왔는지 확인하기
        // 0: *
        if(cal == 0){
            tmp_cal += "*";
        }
        // 1: +
        else if(cal == 1){
            tmp_cal += "+";
        }
        // 2: -
        else if(cal == 2){
            tmp_cal += "-";
        }
        //System.out.println(tmp_cal);
        StringBuilder start_cal = new StringBuilder();
        StringBuilder end_cal = new StringBuilder();
        int start_idx = 0;      // 시작 영역부분 값 자르기 위해서 진행
        int end_idx = 0;        // 끝 영역부분 값 자르기 위해서 진행
        boolean tf = false;

        //System.out.println(expression);
        유형별.String a = "";


        for(int i=0; i<expression.length(); i++) {
            // 연산자가 같은경우
            if ((expression.charAt(i) + "").equals(tmp_cal.charAt(0) + "")) {
                tf = true;
            } else {
                // 숫자 체크
                if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){

                    //원하는 값이 나온 경우
                    if(tf == false){
                        start_cal.append(expression.charAt(i));
                    }else {
                        end_cal.append(expression.charAt(i));
                    }

                }
                // 연산자 체
                else {
                    // 연산된 값을 기준으로 다시 recursive
                    if(tf == true){

                        int tmp_ans = 0;
                        end_idx = i;
                        //System.out.println(start_cal + "" + end_cal);

                        //System.out.println(start_idx + "" + end_idx);
                        유형별.String q = expression.substring(0,start_idx+1);
                        유형별.String w = expression.substring(end_idx,expression.length());
                        //System.out.println(q + "|||||" + w);

                        if(tmp_cal.equals("*")){
                            tmp_ans = Integer.parseInt(start_cal.toString()) * Integer.parseInt(end_cal.toString());
                        }else if(tmp_cal.equals("+")){
                            tmp_ans = Integer.parseInt(start_cal.toString()) + Integer.parseInt(end_cal.toString());
                        }else if(tmp_cal.equals("-")){
                            tmp_ans = Integer.parseInt(start_cal.toString()) - Integer.parseInt(end_cal.toString());
                        }
                        System.out.println("Test"+q + Integer.toString(tmp_ans) + w);
                        search(q + (tmp_ans+"") + w, answer + tmp_ans,cal);

                    }
                    start_idx = i;
                    start_cal.setLength(0);
                    a += expression.charAt(i);
                    //System.out.println(expression.charAt(i));
                }
            }
        }

        return answer;


        //System.out.println(start_cal.toString()+ "" + end_cal.toString());

    }*/



}
