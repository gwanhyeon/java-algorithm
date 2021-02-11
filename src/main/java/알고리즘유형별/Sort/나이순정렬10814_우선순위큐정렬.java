package 알고리즘유형별.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
https://devlog-wjdrbs96.tistory.com/68
 */
public class 나이순정렬10814_우선순위큐정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Info> q = new PriorityQueue<Info>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int number = i+1;
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            q.add(new Info(number,age,name));
        }

//        Collections.sort(q, new Comparator<Info>() {
//
//
//            @Override
//            public int compare(Info info1, Info info2) {
//                if(info1.age < info2.age){
//                    return -1;
//                }else if(info1.age > info2.age){
//                    return 0;
//                }else if(info1.age == info2.age){
//                    return info1.number < info2.number ? -1 : 1;
//
//                }
//
//
//            }
//
//        });

        while(!q.isEmpty()){
            Info info = q.poll();
            System.out.println(info.age + " " + info.name);
        }


    }

    private static class Info implements Comparable<Info>{

        int number;
        int age;
        String name;

        public Info(int number, int age, String name) {
            this.number = number;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Info info) {

            if(this.age < info.age){
                return -1;
            }else if(this.age > info.age){
                return 1;
            }else if(this.age == info.age){

                //return this.name.compareTo(info.name);          // 알파벳 순차 A-Z
                //return info.name.compareTo(this.name);          // 알파벳 역순 Z-A
                return this.number < info.number ? -1 : 1;        // 먼저 들어온 순으로 (number이 더 빠른순)

            }
            return 0;
        }
    }
}
